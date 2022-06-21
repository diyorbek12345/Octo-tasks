package com.octo.octoTestProject.components;


import com.octo.octoTestProject.model.domain.Role;
import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.enums.RoleName;
import com.octo.octoTestProject.repository.RoleRepository;
import com.octo.octoTestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("always")) {

            roleRepo.save(new Role(1, RoleName.ROLE_ADMIN));
            roleRepo.save(new Role(2, RoleName.ROLE_USER));

            userRepo.save(
                    new User(
                            "Admin",
                            "Admin@gmail.com",
                            "+998901234567",
                            new HashSet<>(roleRepo.findAllByRoleName(RoleName.ROLE_ADMIN)),
                            true
                    )
            );

            userRepo.save(
                    new User(
                            "User",
                            "user@gmail.com",
                            "+998912345678",
                            new HashSet<>(roleRepo.findAllByRoleName(RoleName.ROLE_USER)),
                            true
                    )
            );
        }
    }
}
