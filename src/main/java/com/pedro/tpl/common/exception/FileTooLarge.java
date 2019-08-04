package com.pedro.tpl.common.exception;

import lombok.Data;

@Data
public class FileTooLarge extends HttpException {

    private String msg = ErrorCode.FILE_TOO_LARGE.getDescription();
    private Integer errorCode = ErrorCode.FILE_TOO_LARGE.getCode();
    private Integer httpCode = HttpStatus.PAYLOAD_TOO_LARGE.value();

    public FileTooLarge(String msg) {
        this.msg = msg;
    }

    public FileTooLarge() {
    }
}
