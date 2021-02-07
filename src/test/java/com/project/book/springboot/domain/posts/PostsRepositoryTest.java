package com.project.book.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;

    @After // 단위 테스트가 끝날 때마다 수행됨.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void post_save(){
        String title = "test title";
        String contents = "test contents";

        postsRepository.save(Posts.builder()
                             .title(title)
                             .content(contents)
                             .author("test")
                             .build());

        List<Posts> postsList = postsRepository.findAll();
        Assertions.assertThat(postsList.get(0).getTitle()).isEqualTo("test title");
        Assertions.assertThat(postsList.get(0).getContent()).isEqualTo("test contents");
        Assertions.assertThat(postsList.get(0).getAuthor()).isEqualTo("test");
    }

    @Test
    public void BaseTimeEntity_post(){
        //given
        LocalDateTime now = LocalDateTime.of(2021, 1, 27, 0, 0, 0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate : " + posts.getCreatedDate() +
                ", modifiedDate : " + posts.getModifiedDate());

        Assertions.assertThat(posts.getCreatedDate()).isAfter(now);
        Assertions.assertThat(posts.getModifiedDate()).isAfter(now);
    }
}