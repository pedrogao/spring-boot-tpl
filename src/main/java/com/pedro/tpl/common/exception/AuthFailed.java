package com.pedro.tpl.common.exception;

import lombok.Data;

@Data
public class AuthFailed extends HttpException {
    private String msg = ErrorCode.UNAUTHORIZED.getDescription();
    private Integer errorCode = ErrorCode.UNAUTHORIZED.getCode();
    private Integer httpCode = HttpStatus.UNAUTHORIZED.value();

    public AuthFailed(String msg) {
        this.msg = msg;
    }

    public AuthFailed() {
    }
}
