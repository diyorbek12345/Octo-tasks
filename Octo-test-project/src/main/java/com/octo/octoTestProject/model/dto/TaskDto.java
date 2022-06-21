package com.octo.octoTestProject.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.octo.octoTestProject.model.domain.Task;
import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.repository.UserRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import java.lang.module.ResolutionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {

    @Autowired
    UserRepository userRepo;

    private Long id;

    @NotBlank
    private String title, text;

    private String deadline;

    private Long userId;

    public Task map2Entity() throws ParseException {
        Task task = new Task();
        task.setTitle(this.getTitle());
        task.setText(this.getText());
        task.setDeadline(new SimpleDateFormat("yyyy.MM.dd HH:mm").parse(this.getDeadline()));
//        task.setUser(userRepo.findById(this.getUserId()).orElseThrow(() -> new ResolutionException("getUserID")));
        return task;
    }
}
