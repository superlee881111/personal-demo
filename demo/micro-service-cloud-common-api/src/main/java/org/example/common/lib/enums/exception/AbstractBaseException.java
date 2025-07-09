package org.example.common.lib.enums.exception;

import org.example.common.lib.enums.ShowTypeEnum;

public interface AbstractBaseException {
    Integer getCode();

    String getMessage();

    default Integer getShowType() {
        return ShowTypeEnum.SILENT.getCode();
    }
}
