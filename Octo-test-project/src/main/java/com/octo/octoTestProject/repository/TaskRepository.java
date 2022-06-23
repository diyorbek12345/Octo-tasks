package com.octo.octoTestProject.repository;

import com.octo.octoTestProject.model.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByUserIdAndActive(Long user_id, boolean active, Pageable pageable);

    Optional<Task> findByIdAndUserId(Long id, Long user_id);

    void deleteByIdAndUserId(Long id, Long user_id);

    void findByDeadline(Date deadline);
}
