package com.ifon2y.SpringBootAws.web;

import com.ifon2y.SpringBootAws.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
//여기서는 SpringRunner라는 스프링 실행자를 사용
//즉, 스프리 부트 테스트와 JUnit사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)
//여러 테스트 어노테이션 중, Web(spring mvc)에 집중할 수 있는 어노테이션
//선언할경우 @Controller, ControllerAdvice 등을 사용 가능
//단, @Service, @Component, @Repository등은 사용 불가
//여기선 컨트롤러만 사용하기 때문에 선언
public class HelloControllerTest {
    @Autowired
    //빈주입
    private MockMvc mvc;
    //웹 API를 테스트할 때 사용

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                //MockMvc를 통해 /hello 주소로 HTTP GET요청을 함
                .andExpect(status().isOk())
                //mvc.perform의 결과를 검증함
                //HTTP Header의 Status를 검증함
                //여기선 200인지 아닌지
                .andExpect(content().string(hello));
                //mvc.perform의 결과를 검증함
                //응답 본문의 내용을 검증함
                //컨트롤러에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증함
    }
}
