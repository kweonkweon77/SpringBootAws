package com.ifon2y.SpringBootAws.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//필드의 get 메소드 생성
@Getter

//필드의 모든 final필드가 포함된 생성자 생성
//final이 없으면 생성자에 포함 안됨
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}