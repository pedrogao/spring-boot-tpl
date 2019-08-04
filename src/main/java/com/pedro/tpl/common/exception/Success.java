package com.pedro.tpl.common.exception;


import lombok.Data;

@Data
public class Success extends HttpException {
    private String msg = ErrorCode.SUCCESS.getDescription();
    private Integer errorCode = ErrorCode.SUCCESS.getCode();
    private Integer httpCode = HttpStatus.OK.value();

}
