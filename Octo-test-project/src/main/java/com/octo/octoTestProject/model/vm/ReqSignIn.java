package com.octo.octoTestProject.model.vm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ReqSignIn {

    @NotBlank(message = "empty")
    @ApiModelProperty(notes = "phone number or email ", name = "username", required = true, value = "+998912345678 or qwerty@gmail.com")
    private String username;

    @NotBlank(message = "password is empty")
    @ApiModelProperty(notes = "password", name = "password", required = true, value = "Qwerty123")
    private String password;

}
