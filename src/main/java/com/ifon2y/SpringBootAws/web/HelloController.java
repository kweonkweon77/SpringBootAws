package com.ifon2y.SpringBootAws.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//컨트롤러를 Json을 반환하는 컨트롤러로 만들어줌
//예전에는 @RespnseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌

public class HelloController {
    @GetMapping("/hello")

    //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 줍니다.
    //예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용되었지만 이제 이 프로젝트는 /hello로 요청이 오면 문자열 hello를
        //반환하는 기능을 가지게 되엇음
    public String hello() {
        return "hello";
    }
}

//이제 이 코드를 test코드에 그대로 넣어봤음
