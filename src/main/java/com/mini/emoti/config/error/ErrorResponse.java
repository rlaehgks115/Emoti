package com.mini.emoti.config.error;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

// https://studyandwrite.tistory.com/502
// https://velog.io/@leehyeonmin34/exception-handling

@Getter
public class ErrorResponse {
    private String message;
    private String code;
    private int status;
    private List<FieldError> errors = new ArrayList<>();

    @Builder
    public ErrorResponse(String message, String code, int status, List<FieldError> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.errors = initErrors(errors);
    }

    private List<FieldError> initErrors(List<FieldError> errors) {
        return (errors == null) ? new ArrayList<>() : errors;
    }

    @Getter
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        @Builder
        public FieldError(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }
    }
}
