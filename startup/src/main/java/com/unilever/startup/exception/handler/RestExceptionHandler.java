package com.unilever.startup.exception.handler;

import com.unilever.authservice.exception.TokenRefreshException;
import com.unilever.utilityservice.exception.EntityAlreadyExistException;
import com.unilever.utilityservice.exception.EntityNotFoundException;
import com.unilever.utilityservice.exception.IncorrectArgumentException;
import com.unilever.utilityservice.exception.UnauthorizedException;
import com.unilever.utilityservice.response.ResponseData;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.security.auth.login.AccountLockedException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseData> handleException(Exception ex, WebRequest webRequest) {
        ex.printStackTrace();
        ResponseData responseData = ResponseData
                .createInstance("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenRefreshException.class)
    public final ResponseEntity<ResponseData> handleRefreshTokenException(TokenRefreshException ex, WebRequest webRequest) {
        ResponseData responseData = ResponseData.createInstance(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<ResponseData> handleUnauthorizedException(UnauthorizedException ex, WebRequest webRequest) {
        ResponseData responseData = ResponseData.createInstance(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ResponseData> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest webRequest) {

        ResponseData responseData = ResponseData
                .createInstance(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public final ResponseEntity<ResponseData> handleExpiredJwtTokenException(ExpiredJwtException ex, WebRequest webRequest) {
        ResponseData responseData = ResponseData
                .createInstance("Your token has expired", HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ResponseData> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest webRequest) {

        ResponseData responseData = ResponseData
                .createInstance("Illegal argument request", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(AccountLockedException.class)
    public final ResponseEntity<ResponseData> handleAccountLockedException(AccountLockedException ex, WebRequest webRequest) {
        ResponseData responseData = ResponseData.createInstance(ex.getMessage(), HttpStatus.LOCKED);
        return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
    }


}