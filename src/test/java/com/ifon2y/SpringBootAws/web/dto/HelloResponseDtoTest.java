package com.ifon2y.SpringBootAws.web.dto;

import com.ifon2y.SpringBootAws.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertThat assertj라는 테스트 검증 라이브러리 검증 메소드
        //검증하고 싶은 대상을 메소드 인자로 받음
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
