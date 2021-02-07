package com.project.book.springboot.web.Controller;

import com.project.book.springboot.service.posts.PostsService;
import com.project.book.springboot.web.dto.PostsResponseDto;
import com.project.book.springboot.web.dto.PostsSaveRequestDto;
import com.project.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
