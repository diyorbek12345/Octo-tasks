package com.octo.octoTestProject.service.impl;

import com.octo.octoTestProject.model.domain.Task;
import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.dto.ApiResponse;
import com.octo.octoTestProject.model.dto.TaskDto;
import com.octo.octoTestProject.repository.TaskRepository;
import com.octo.octoTestProject.repository.UserRepository;
import com.octo.octoTestProject.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepo;

    @Autowired
    UserRepository userRepo;

    @Value("${app.data.format}")
    private String format;


    @Override
    public ApiResponse saveTask(TaskDto taskDto) {
        try {
            Date current = new Date();
            Date checkTime = new SimpleDateFormat(format).parse(taskDto.getDeadline());
            if (!(checkTime.after(current) || checkTime.equals(current))) {
                log.error("This time is invalid: {}", checkTime);
                return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Time is past");
            }
            taskDto.map2Entity().setUser(userRepo.findById(taskDto.getUserId()).orElseThrow(() -> new ResolutionException("getUserID")));
            log.info("Success");
            return new ApiResponse(HttpStatus.CREATED.value(), taskRepo.save(taskDto.map2Entity()));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ApiResponse(HttpStatus.CONFLICT.value(), "Save Error");
        }
    }

    @Override
    public ApiResponse editTask(Long id, TaskDto taskDto) {
        try {
            Task task = taskRepo.findById(id).orElseThrow(() -> new ResolutionException("getTaskID"));
            if (task.getTitle().equals(taskDto.getTitle())) {
                log.error("This title is exist: {}", task.getTitle());
                return new ApiResponse(HttpStatus.CONFLICT.value(), "Title is exist");
            }
            Date current = new Date();
            Date checkTime = new SimpleDateFormat(format).parse(taskDto.getDeadline());
            if (!(checkTime.after(current) || checkTime.equals(current))) {
                log.error("This time is invalid: {}", checkTime);
                return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Time is past");
            }
            task.setTitle(taskDto.getTitle());
            task.setText(taskDto.getText());
            task.setDeadline(new SimpleDateFormat(format).parse(taskDto.getDeadline()));
            task.setUser(userRepo.findById(taskDto.getUserId()).orElseThrow(() -> new ResolutionException("getUserID")));
            return new ApiResponse(HttpStatus.CREATED.value(), taskRepo.save(task));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Edit Error");
        }
    }

    @Override
    public ApiResponse getTask(Long id, User user) {
        try {
            log.info("OK");
            return new ApiResponse(HttpStatus.OK.value(),
                    taskRepo.findByIdAndUserId(id, user.getId()).orElseThrow(() -> new ResolutionException("Not found")));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ApiResponse(HttpStatus.NOT_FOUND.value(), "Not found");
        }
    }

    @Override
    public ApiResponse getTaskList(int page, int size, String sort, User user) {
        try {
            log.info("OK");
            return new ApiResponse(HttpStatus.OK.value(), "OK", taskRepo.findAllByUserId(user.getId(), PageRequest.of(page, size, Sort.by(sort).descending())));
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ApiResponse(HttpStatus.NOT_FOUND.value(), "Error");
        }
    }

    @Override
    public ApiResponse deleteTask(Long id, User user) {
        try {
            log.info("Deleted");
            taskRepo.deleteByIdAndUserId(id, user.getId());
            return new ApiResponse("Success deleted", HttpStatus.OK.value());
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ApiResponse(HttpStatus.NOT_FOUND.value(), "Task not found");
        }

    }
}
