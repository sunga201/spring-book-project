package com.project.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
