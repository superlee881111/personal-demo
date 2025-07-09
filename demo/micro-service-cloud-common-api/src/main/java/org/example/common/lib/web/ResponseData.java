package org.example.common.lib.web;

import io.swagger.annotations.ApiModelProperty;
import org.example.common.lib.enums.ShowTypeEnum;

import java.util.List;

public class ResponseData<T> {
    public static final String DEFAULT_SUCCESS_MESSAGE = "success";
    public static final String DEFAULT_ERROR_MESSAGE = "error";
    public static final Integer DEFAULT_SUCCESS_CODE = 200;
    public static final Integer DEFAULT_ERROR_CODE = 500;
    public static final Integer DEFAULT_CONFIRM_YES_CODE = 300;
    public static final Integer DEFAULT_CONFIRM_NO_CODE = 301;
    public static final Integer DEFAULT_CONFIRM_WARN_CODE = 302;
    public static final Integer DEFAULT_CONFIRM_YES_NO_CODE = 303;
    public static final Integer DEFAULT_SUCCESS_WARNING_CODE = 310;
    public static final Integer DEFAULT_SUCCESS_NO_DATE_CODE = 210;
    public static final Integer DEFAULT_ERROR_DOWNLOAD_FILE = 420;
    public static final Integer DEFAULT_ERROR_CLOSE_PAGE = 430;
    public static final List<Integer> logableStatus;
    private Boolean success;
    @ApiModelProperty("レスポンスステータスコード。200（正常に処理した），210（正常に処理したが、主なデータの取得は出来なかった），300（再確認する、Yesをクリックして再送信），301（再確認する、Noをクリックして再送信），310（正常的に処理したが、警告ある）")
    private Integer code;
    private String message;
    private Integer level;
    private T data;
    private Integer showType;

    public ResponseData() {
        this.showType = ShowTypeEnum.SILENT.getCode();
    }

    public ResponseData(Boolean success, Integer code, String message, T data, Integer showType) {
        this.showType = ShowTypeEnum.SILENT.getCode();
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        if (showType == null) {
            this.showType = ShowTypeEnum.SILENT.getCode();
        } else {
            this.showType = showType;
        }

    }

    public ResponseData(Boolean success, Integer code, String message, T data, Integer showType, Integer level) {
        this.showType = ShowTypeEnum.SILENT.getCode();
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        if (showType == null) {
            this.showType = ShowTypeEnum.SILENT.getCode();
        } else {
            this.showType = showType;
        }

        this.level = level;
    }

    public static <T> SuccessResponseData<T> success() {
        return new SuccessResponseData();
    }

    public static <T> SuccessResponseData<T> successOf(T object) {
        return new SuccessResponseData(object);
    }

    public static <T> SuccessResponseData<T> success(T object) {
        return new SuccessResponseData(object);
    }

    public static <T> SuccessResponseData<T> success(Integer code, String message, T object) {
        return new SuccessResponseData(code, message, object);
    }

    public static ErrorResponseData error(String message) {
        return new ErrorResponseData(message);
    }

    public static ErrorResponseData error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    public static ErrorResponseData error(Integer code, String message, Object object) {
        return new ErrorResponseData(code, message, object);
    }

    public static <T> SuccessResponseData<T> confirm(String message) {
        SuccessResponseData<T> srd = new SuccessResponseData();
        srd.setCode(DEFAULT_CONFIRM_YES_CODE);
        srd.setMessage(message);
        return srd;
    }

    public static <T> SuccessResponseData<T> confirm(Integer code, String message) {
        SuccessResponseData<T> srd = new SuccessResponseData();
        srd.setCode(code);
        srd.setMessage(message);
        return srd;
    }

    public static <T> SuccessResponseData<T> confirm(Integer code, String message, T data) {
        SuccessResponseData<T> srd = new SuccessResponseData();
        srd.setCode(code);
        srd.setMessage(message);
        srd.setData(data);
        return srd;
    }

    public static <T> SuccessResponseData<T> successNoData(String message) {
        return successNoData(message, null);
    }

    public static <T> SuccessResponseData<T> successNoData() {
        return successNoData((String)null, null);
    }

    public static <T> SuccessResponseData<T> successNoData(String message, T object) {
        SuccessResponseData<T> srd = new SuccessResponseData();
        srd.setCode(210);
        srd.setData(object);
        srd.setMessage(message);
        return srd;
    }

    public static <T> SuccessResponseData<T> successNoData(T object) {
        return successNoData((String)null, object);
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setLevel(final Integer level) {
        this.level = level;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setShowType(final Integer showType) {
        this.showType = showType;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getLevel() {
        return this.level;
    }

    public T getData() {
        return this.data;
    }

    public Integer getShowType() {
        return this.showType;
    }

    static {
        logableStatus = List.of(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_WARNING_CODE, DEFAULT_SUCCESS_NO_DATE_CODE);
    }
}
