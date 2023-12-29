package com.pssservice.pssservice.Handlers;

import com.pssservice.pssservice.Exception.ErrorCodes;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private int httpCode;

    private ErrorCodes errorCodes;

    private String message;

    private List<String > errors = new ArrayList<>();

}
