package com.winone.springboot.web;

import com.winone.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환 하는 컨트롤러로 만들어줌, 예전 ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌
public class HelloController {
    
    @GetMapping("/hello") // HTTP Get요청 받을 수 있는 API 만들어줌
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto") // @RequestParam("name") 이란 이름으로 넘긴 파라미터를 name(String name)에 저장!
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
