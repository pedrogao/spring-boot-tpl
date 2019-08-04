package com.pedro.tpl.common.exception;


import lombok.Data;

@Data
public class NotFound extends HttpException {
    private String msg = ErrorCode.NOT_FOUND.getDescription();
    private Integer errorCode = ErrorCode.NOT_FOUND.getCode();
    private Integer httpCode = HttpStatus.NOT_FOUND.value();

    public NotFound(String msg) {
        this.msg = msg;
    }

    public NotFound() {
    }
}
