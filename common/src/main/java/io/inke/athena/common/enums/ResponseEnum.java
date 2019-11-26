package io.inke.athena.common.enums;

public enum ResponseEnum {

    SUCCESS(2000, "Successful run. See details for the results"),
    ERROR(5000, "There is an exception on the server, please check the details");

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
