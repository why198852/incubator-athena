package io.inke.athena.common.response;

import io.inke.athena.common.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCommon<T> {

    private Integer code;
    private String message;
    private T detail;

    private void setCodeMessage(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

//    public static ResponseCommon success() {
//        return success(ResponseEnum.SUCCESS, null);
//    }

    /**
     * Combined return success result
     *
     * @param responseEnum response enum
     * @param detail       response result
     * @param <T>          response result class
     * @return result
     */
    public static <T> ResponseCommon success(ResponseEnum responseEnum, T detail) {
        ResponseCommon response = new ResponseCommon();
        if (ObjectUtils.isEmpty(responseEnum)) {
            response = success(detail);
        } else {
            response.setCodeMessage(responseEnum);
            response.setDetail(detail);
        }
        return response;
    }

    /**
     * Combined return success result
     *
     * @param detail response result
     * @param <T>    response result class
     * @return result
     */
    public static <T> ResponseCommon success(T detail) {
        return success(ResponseEnum.SUCCESS, detail);
    }

    /**
     * Combined return error result
     *
     * @param responseEnum response enum
     * @param detail       response result
     * @param <T>          response result class
     * @return result
     */
    public static <T> ResponseCommon error(ResponseEnum responseEnum, T detail) {
        ResponseCommon response = new ResponseCommon();
        if (ObjectUtils.isEmpty(responseEnum)) {
            response = error(detail);
        } else {
            response.setCodeMessage(responseEnum);
            response.setDetail(detail);
        }
        return response;
    }

    /**
     * Combined return error result
     *
     * @param detail response result
     * @param <T>    response result class
     * @return result
     */
    public static <T> ResponseCommon error(T detail) {
        return error(ResponseEnum.ERROR, detail);
    }

}
