package org.example.common.lib.web;

import org.example.common.lib.enums.exception.AbstractBaseException;

public class ErrorResponseData extends ResponseData {
    private String exceptionClazz;
    private String stackTraceInfo;

    public ErrorResponseData(String message) {
        super(false, DEFAULT_ERROR_CODE, message, (Object)null, (Integer)null, (Integer)null);
    }

    public ErrorResponseData(AbstractBaseException baseException) {
        super(false, baseException.getCode(), baseException.getMessage(), (Object)null, baseException.getShowType(), (Integer)null);
    }

    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, (Object)null, (Integer)null, (Integer)null);
    }

    public ErrorResponseData(Integer code, String message, Object object) {
        super(false, code, message, object, (Integer)null, (Integer)null);
    }

    public ErrorResponseData(Integer code, String message, Object object, Integer showType) {
        super(false, code, message, object, showType);
    }

    public ErrorResponseData(Integer code, String message, Object object, Integer showType, Integer level) {
        super(false, code, message, object, showType, level);
    }

    public ErrorResponseData(Integer code, String message, Object object, Integer showType, Integer level, String stackTraceInfo) {
        super(false, code, message, object, showType, level);
        this.stackTraceInfo = stackTraceInfo;
    }

    public void setExceptionClazz(final String exceptionClazz) {
        this.exceptionClazz = exceptionClazz;
    }

    public void setStackTraceInfo(final String stackTraceInfo) {
        this.stackTraceInfo = stackTraceInfo;
    }

    public String getExceptionClazz() {
        return this.exceptionClazz;
    }

    public String getStackTraceInfo() {
        return this.stackTraceInfo;
    }

}
