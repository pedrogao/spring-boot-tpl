package com.pedro.tpl.common.exception;


import lombok.Data;

@Data
public class Forbidden extends HttpException {
    private String msg = ErrorCode.FORBIDDEN.getDescription();
    private Integer errorCode = ErrorCode.FORBIDDEN.getCode();
    private Integer httpCode = HttpStatus.FORBIDDEN.value();

    public Forbidden(String msg) {
        this.msg = msg;
    }

    public Forbidden() {
    }
}
