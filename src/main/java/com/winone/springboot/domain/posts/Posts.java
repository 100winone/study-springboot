package com.winone.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // @NoArgsConstructor - 기본 생성자 자동 추가, public Posts(){} 와 같은 효과
@Entity // @Entity -  테이블과 링크될 클래스, 기본값으로 클래스의 카멜케이스 이름을 (_)으로 테이블 이름 매칭
public class Posts {

    @Id // @Id - 테이블의 PK, Spring Boot 2.0에서는 GenerationType.IDENTITY 옵션 추가해야 auto_increment가능
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) // @Column - 선언하지 않아도 클래스의 필드는 모두 컬럼이 됨 but 사용하는 이유는 기본값 외 추가 옵션있을 때 사용
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;
    @Builder // @Builder - 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함 */
    public Posts(String title, String content, String author){
    }
}