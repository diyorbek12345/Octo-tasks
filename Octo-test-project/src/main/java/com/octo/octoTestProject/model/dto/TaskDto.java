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
import java.io.Serializable;
import java.lang.module.ResolutionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto implements Serializable {

    private Long id;

    @NotBlank
    private String title, text;

    private String deadline;

    private Long userId;

    private boolean active;
}
