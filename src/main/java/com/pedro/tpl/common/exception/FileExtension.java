package com.pedro.tpl.common.exception;

import lombok.Data;

@Data
public class FileExtension extends HttpException {
    private String msg = ErrorCode.File_Extension.getDescription();
    private Integer errorCode = ErrorCode.File_Extension.getCode();
    private Integer httpCode = HttpStatus.NOT_ACCEPTABLE.value();

    public FileExtension(String msg) {
        this.msg = msg;
    }

    public FileExtension() {
    }
}
