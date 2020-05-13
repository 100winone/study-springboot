package com.winone.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // 인터페이스 생성후 JpaRepository<Entity클래스, PK타입>을 상속하면 기본 CRUD가 자동생성
    
}
