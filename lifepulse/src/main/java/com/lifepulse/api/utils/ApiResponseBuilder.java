package com.lifepulse.api.utils;

import com.lifepulse.api.model.common.ApiResponseModel;

public class ApiResponseBuilder {
    public static ApiResponseModel buildApiResponse(int code, String message) {

        return ApiResponseModel.builder()
                .statusCode(code)
                .message(message)
                .build();
    }
}
