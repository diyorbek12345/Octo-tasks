package com.octo.octoTestProject.model.domain;

import com.octo.octoTestProject.model.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String text;

    private Date deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public TaskDto map2DTO(){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(this.getId());
        taskDto.setTitle(this.getTitle());
        taskDto.setText(this.getText());
        taskDto.setDeadline(String.valueOf(this.getDeadline()));
        taskDto.setUserId(this.getUser().getId());
        return taskDto;
    }
}
