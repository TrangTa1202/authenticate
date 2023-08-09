package com.example.crm.exception;

import com.example.crm.payload.FileResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadException {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<FileResponse> handleMaxSizeException(MaxUploadSizeExceededException exception) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileResponse("File too large!"));
    }
}
