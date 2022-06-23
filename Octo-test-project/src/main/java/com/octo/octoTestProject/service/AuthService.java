package com.octo.octoTestProject.service;

import com.octo.octoTestProject.model.domain.User;
import com.octo.octoTestProject.model.dto.ApiResponse;
import com.octo.octoTestProject.model.dto.UserDto;
import com.octo.octoTestProject.model.enums.RoleName;
import com.octo.octoTestProject.repository.RoleRepository;
import com.octo.octoTestProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ApiResponse registerUser(UserDto userDto) {
        try {
            if (userRepository.existsByEmail(userDto.getEmail())){
                return new ApiResponse("Email exist", HttpStatus.CONFLICT.value());
            }
            if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())){
                return new ApiResponse("Phone Number exist", HttpStatus.CONFLICT.value());
            }
            User savedUser = userRepository.save(makeUser(userDto, false));
            log.info("success: {}", savedUser);
            return new ApiResponse(HttpStatus.CREATED.value(), "Successfully register");
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Error saving", e.getMessage());
        }
    }

    /**
     * This method to help making User
     */
    public User makeUser(UserDto userDto, boolean admin) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(roleRepository.findAllByRoleName(!admin ? RoleName.ROLE_USER : RoleName.ROLE_ADMIN));
        user.setEnabled(true);
        return user;
    }
}
