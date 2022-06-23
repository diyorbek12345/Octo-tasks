package com.octo.octoTestProject.model.vm;

import com.octo.octoTestProject.model.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskPageable {
    private int number;
    private boolean last;
    private int size;
    private int numberOfElements;
    private int totalPages;
    private Pageable pageable;
    private Sort sort;
    private boolean first;
    private long totalElements;
    private boolean empty;
    private List<TaskDto> content;
}
