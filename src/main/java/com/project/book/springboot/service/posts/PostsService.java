package com.project.book.springboot.service.posts;

import com.project.book.springboot.domain.posts.Posts;
import com.project.book.springboot.domain.posts.PostsRepository;
import com.project.book.springboot.web.dto.PostsResponseDto;
import com.project.book.springboot.web.dto.PostsSaveRequestDto;
import com.project.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
        
        posts.update(requestDto.getTitle(), requestDto.getContent());
        // update 기능에서 데이터베이스에 쿼리를 날리는 부분이 없는 이유?
        // -> JPA의 영속성 컨텍스트 때문, 데이터를 조회한 뒤 이를 수정하면 트랜잭션이 끝나는 시점에서
        // 자동으로 변경내역을 DB에 반영한다.
        
        return id;
    }
    
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));

        return new PostsResponseDto(posts);
    }
}
