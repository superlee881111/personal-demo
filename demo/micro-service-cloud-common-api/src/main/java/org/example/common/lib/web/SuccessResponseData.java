package org.example.common.lib.web;

public class SuccessResponseData<T> extends ResponseData<T>  {
    public SuccessResponseData() {
        super(true, DEFAULT_SUCCESS_CODE, "success", null, (Integer)null, (Integer)null);
    }

    public SuccessResponseData(T object) {
        super(true, DEFAULT_SUCCESS_CODE, "success", object, (Integer)null, (Integer)null);
    }

    public SuccessResponseData(Integer code, String message, T object) {
        super(true, code, message, object, (Integer)null, (Integer)null);
    }
}
