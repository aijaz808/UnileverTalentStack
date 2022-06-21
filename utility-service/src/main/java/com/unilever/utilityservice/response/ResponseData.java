package com.unilever.utilityservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class ResponseData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Object data;
    private String message;
    private String statusDescription;
    private Date timestamp;
    private int statusCode;

    /**
     * This would be provided only when webservice involves pagination.
     */
    private long totalCount;
    private static final String SUCCESS_MESSAGE = "Success";

    private ResponseData(Object data) {
        this.data = data;
        this.statusCode = HttpStatus.OK.value();
        this.message = SUCCESS_MESSAGE;
        this.statusDescription = this.message;
    }

    private ResponseData(Object data, long totalCount) {
        this.data = data;
        this.totalCount = totalCount;
        this.statusCode = HttpStatus.OK.value();
        this.message = SUCCESS_MESSAGE;
        this.statusDescription = this.message;
    }


    private ResponseData(Object data, HttpStatus httpStatus, Date timestamp) {
        this.data = data;
        this.statusCode = httpStatus.value();
        this.message = SUCCESS_MESSAGE;
        this.statusDescription = this.message;
    }

    private ResponseData(String message, HttpStatus httpStatus, Date timestamp) {
        this.message = message;
        this.statusCode = httpStatus.value();
        this.timestamp = timestamp;
        this.statusDescription = this.message;
    }

    private ResponseData(String message, String statusDescription, Date timestamp) {
        this.message = message;
        this.statusDescription = statusDescription;
        this.timestamp = timestamp;
    }

    public static ResponseData createInstance(Object data) {
        return new ResponseData(data);
    }

    public static ResponseData createInstance(String message, String description) {
        return new ResponseData(message, description, new Date());
    }

    public static ResponseData createInstance(Object data, long totalCount) {
        return new ResponseData(data, totalCount);
    }

    public static ResponseData createInstance(Object data, HttpStatus httpStatus) {
        return new ResponseData(data, httpStatus, new Date());
    }

    public static ResponseData createInstance(String message, HttpStatus httpStatus) {
        return new ResponseData(message, httpStatus, new Date());
    }
}




