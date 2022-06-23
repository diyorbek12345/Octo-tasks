package com.octo.octoTestProject.repository;

import com.octo.octoTestProject.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumberOrEmail(String phoneNumber, String email);
}
