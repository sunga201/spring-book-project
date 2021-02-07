package com.project.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
//SpringBootApplication이 붙으면 메인 클래스 역할을 하게 된다. 여기부터 설정을 읽어가므로, 이 클래스는
//항상 프로젝트 최상단에 있어야 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //내장 WAS 시작(톰캣)
    }
}
