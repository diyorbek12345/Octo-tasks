package com.octo.octoTestProject.controller;

import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.dto.ApiResponse;
import com.octo.octoTestProject.model.dto.TaskDto;
import com.octo.octoTestProject.security.CurrentUser;
import com.octo.octoTestProject.service.impl.TaskServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token"))
    @PostMapping
    public ApiResponse saveTask(@RequestBody @Valid TaskDto taskDto) {
        return taskService.saveTask(taskDto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token"))
    @PutMapping("/{id}")
    public ApiResponse editTask(@PathVariable Long id, @RequestBody @Valid TaskDto taskDto, @CurrentUser User user) {
        return taskService.editTask(id, taskDto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token"))
    @GetMapping("/{id}")
    public ApiResponse getTask(@PathVariable Long id, @CurrentUser User user) {
        return taskService.getTask(id, user);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token"))
    @GetMapping
    public ApiResponse getTaskList(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                   @RequestParam(value = "sort", defaultValue = "deadline") String sort,
                                   @CurrentUser User user) {
        return taskService.getTaskList(page, size, sort, user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token"))
    @DeleteMapping("/{id}")
    public ApiResponse deleteTask(@PathVariable Long id, @CurrentUser User user) {
        return taskService.deleteTask(id, user);
    }
}
