package com.winone.springboot.domain.posts;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit에서 단위 테스트 끝날 때마다 수행되는 메소드 지정, 여러 테스트 동시 실행 시 H2 db에 데이터가 그대로 남아있어 다음 테스트 실행 시 실패가 일어날 수 있음
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title).content(content).author("aya01317@gmail.com").build()); // PostsRepository.save - 테이블 posts에 insert/update 쿼리 실행,
                                                                                        // id값 있으면 update, 없으면 insert 쿼리 실행

        //when
        List<Posts> postsList = postsRepository.findAll(); // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
