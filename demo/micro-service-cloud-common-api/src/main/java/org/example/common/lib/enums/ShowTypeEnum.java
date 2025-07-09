package org.example.common.lib.enums;

public enum ShowTypeEnum {
    NOTIFICATION(0, "NOTIFICATION"),
    MESSAGE(1, "MESSAGE"),
    MESSAGE_BOX(2, "MESSAGE_BOX"),
    SILENT(4, "SILENT"),
    REDIRECT(9, "REDIRECT");

    private final Integer code;
    private final String desc;

    private ShowTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getNameByCode(Integer code) {
        if (null != code) {
            ShowTypeEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                ShowTypeEnum enumItem = var1[var3];
                if (enumItem.getCode().equals(code)) {
                    return enumItem.getDesc();
                }
            }
        }

        return "";
    }

    public static ShowTypeEnum toEnum(Integer code) {
        if (null != code) {
            ShowTypeEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                ShowTypeEnum e = var1[var3];
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }

        return null;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
