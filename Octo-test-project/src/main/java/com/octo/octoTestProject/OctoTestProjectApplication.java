package com.octo.octoTestProject;

import com.octo.octoTestProject.model.domain.Task;
import com.octo.octoTestProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
public class OctoTestProjectApplication {

    @Autowired
    TaskRepository taskRepo;

    public static void main(String[] args) {
        SpringApplication.run(OctoTestProjectApplication.class, args);
    }

    //the top of every hour of every day
    @Scheduled(cron = "0 0 * * * *")
    public void changeActive() {
        for (Task task : taskRepo.findAll()) {
            if (task.getDeadline().before(new Date())) {
                task.setActive(false);
                taskRepo.save(task);
            }
        }
    }

}
