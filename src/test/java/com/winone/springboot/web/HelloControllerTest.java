package com.winone.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class) // 테스트 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자 실행, 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest // Controller와 ControllerAdvice 사용 가능
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean 주입받음
    private MockMvc mvc; // 웹 API 테스트시 사용 API 테스트 가능하게함

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
        /*
        * mvc.perform(get("/hello")), MockMvc통해 /hello주소로 HTTP get요청
        * andExpect(status().isOk()), ok인지 상태검증
        * andExpect(content().string(hello), hello가 맞는지 결과 검증
        * */
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name", is(name))).andExpect(jsonPath("$.amount", is(amount)));
        /*
        * param -> API 테스트할 떄 사용될 요청 파라미터 설정
        * String만 허용
        * jsonPath -> JSON 응답값을 필드별로 검증할 수 있는 메소드
        * $를 기준으로 필드명을 명시
        * $.name $.amount 이런식*/
    }
}
