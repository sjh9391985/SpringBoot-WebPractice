package com.spring.gmta.mvc.paramter;

import lombok.Data;

/**
 * class 설명:
 * packageName : com.spring.gmta.mvc.paramter
 * fileName : BoardParameter
 * author : sonjaehyeon
 * date : 2022/03/22
 */
@Data
public class BoardParameter {
    private int boardSeq;
    private String title;
    private String contents;
}
