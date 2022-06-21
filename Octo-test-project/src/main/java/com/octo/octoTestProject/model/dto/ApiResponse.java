package com.octo.octoTestProject.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("ApiResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    @ApiModelProperty(name = "success code", position = 1, example = "200")
    private int success;

    @ApiModelProperty(name = "response message", position = 2, example = "successes")
    private String message;

    @ApiModelProperty(name = "response object", position = 3, example = "null")
    private Object object;

    public ApiResponse(String message, int success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(int success, Object object) {
        this.success = success;
        this.object = object;
    }

    public ApiResponse(int success, String message) {
        this.success = success;
        this.message = message;
    }



    public ApiResponse(String message, Object object) {
        this.message = message;
        this.object = object;
    }
}
