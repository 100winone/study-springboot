/*모든 응답들을 기록하는 Dto*/
package com.winone.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드 생성해줌
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
