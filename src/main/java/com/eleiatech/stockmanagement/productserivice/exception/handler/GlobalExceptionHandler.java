package com.eleiatech.stockmanagement.productserivice.exception.handler;

import com.eleiatech.stockmanagement.productserivice.exception.enums.FriendlyMessageCode;
import com.eleiatech.stockmanagement.productserivice.exception.exceptions.ProductNotCreatedException;
import com.eleiatech.stockmanagement.productserivice.exception.utils.FriendlyMessageUtils;
import com.eleiatech.stockmanagement.productserivice.response.FriendlyMessage;
import com.eleiatech.stockmanagement.productserivice.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), FriendlyMessageCode.Error))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(exception.getMessage()))
                .build();

    }
}
