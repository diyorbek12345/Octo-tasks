package com.octo.octoTestProject.service;

import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.dto.UserDto;
import com.octo.octoTestProject.model.enums.RoleName;
import com.octo.octoTestProject.repository.RoleRepository;
import com.octo.octoTestProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.UUID;

@Service
@Slf4j
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    public UserDetails getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResolutionException("getUser"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumberOrEmail(username, username).orElseThrow(() -> new UsernameNotFoundException("Don't found"));
    }

    /**
     * This method register User
     */
    public User registerUser(UserDto userDto) {
        try {
            User savedUser = userRepository.save(makeUser(userDto, false));
            log.info("success: {}", savedUser);
            return savedUser;
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new User();
        }
    }

    /**
     * This method to help making User
     */
    public User makeUser(UserDto userDto, boolean admin) {
        User user = userDto.map2Entity();
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(roleRepository.findAllByRoleName(!admin ? RoleName.ROLE_USER : RoleName.ROLE_ADMIN));
        user.setEnabled(true);
        return user;
    }
}
