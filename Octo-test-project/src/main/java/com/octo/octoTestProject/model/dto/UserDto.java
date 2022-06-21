package com.octo.octoTestProject.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.octo.octoTestProject.model.domain.Role;
import com.octo.octoTestProject.model.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    private Long id;

    private String fullName;

    @NotBlank
    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$", message = "Phone number is invalid")
    @ApiModelProperty(notes = "phone number ", name = "phoneNumber", required = true, value = "+998912345678")
    private String phoneNumber;

    @NotBlank
    @Email(message = "Please type your email")
    private String email;

    private Set<Role> roles;

    public User map2Entity() {
        User user = new User();
        user.setFullName(this.getFullName());
        return user;
    }
}
