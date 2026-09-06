package com.gaurav.payload.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private String  message;
    private String  error;
    private LocalDateTime timestamp;

}
