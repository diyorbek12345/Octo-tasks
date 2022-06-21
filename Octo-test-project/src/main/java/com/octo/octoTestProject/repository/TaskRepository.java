package com.octo.octoTestProject.repository;

import com.octo.octoTestProject.model.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByUserId(Long user_id, Pageable pageable);

    Optional<Task> findByIdAndUserId(Long id, Long user_id);

    void deleteByIdAndUserId(Long id, Long user_id);
}
