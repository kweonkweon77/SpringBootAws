package com.ifon2y.SpringBootAws.domain.posts;


import com.ifon2y.SpringBootAws.domain.posts.Posts;
import com.ifon2y.SpringBootAws.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    //Junit에서 단위 테스트가 끝날 때마다 수해오디는 메소드 지정
    //보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용
    //여러 테스트가 동시에 수행되면 테스트용 db인 h2에 데이터가 그대로 남아있어 다음 테스트 실행 시 테스트가 실패할 수 있음
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                //테이블 posts에 insert/update 쿼리 실행
                //id 값 기준
                .title(title)
                .content(content)
                .author("kweonifon2y@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        //모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
