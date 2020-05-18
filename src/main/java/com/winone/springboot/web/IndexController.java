package com.winone.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/") // 머스테치 스타터가 컨트롤러에서 문자열 반환시 앞의 경로와 뒤의 파일 확장자는 자동으로 지정
    public String index() {
        return "index"; // 여기서 index가 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리..!!
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
