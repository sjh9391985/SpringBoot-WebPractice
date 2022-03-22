package com.spring.gmta.configuration.http;

import lombok.Data;
/**
 * class 설명:
 * packageName : com.spring.gmta.configuration.http
 * fileName : BaseResponse
 * author : sonjaehyeon
 * date : 2022/03/22
 */
@Data
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private T data;

    public BaseResponse(T data){
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }
}
