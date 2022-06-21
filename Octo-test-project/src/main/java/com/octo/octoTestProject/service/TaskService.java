package com.octo.octoTestProject.service;

import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.dto.ApiResponse;
import com.octo.octoTestProject.model.dto.TaskDto;

public interface TaskService {

    ApiResponse saveTask(TaskDto taskDto);

    ApiResponse editTask(Long id, TaskDto taskDto);

    ApiResponse getTask(Long id,User user);

    ApiResponse getTaskList(int page, int size, String sort, User user);

    ApiResponse deleteTask(Long id, User user);
}
