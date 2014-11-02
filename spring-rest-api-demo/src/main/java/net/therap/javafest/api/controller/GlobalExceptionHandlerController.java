package net.therap.javafest.api.controller;

import net.therap.javafest.api.util.ErrorResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> noRequestHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        log.debug("noRequestHandlerFound: stacktrace={}", ExceptionUtils.getStackTrace(e));

        String errorCode = "400 - Bad Request";
        String errorMsg = "Requested URL doesn't exist";

        return new ResponseEntity<>(new ErrorResponse(errorCode, errorMsg), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErrorResponse> internalServerErrorExceptionHandler(Exception e) {
        log.debug("internalServerErrorExceptionHandler: stacktrace={}", ExceptionUtils.getStackTrace(e));

        String errorCode = "500 - Internal Server Error";
        String errorMsg = "Something went wrong in server";

        return new ResponseEntity<>(new ErrorResponse(errorCode, errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
