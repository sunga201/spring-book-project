package com.project.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도
                  // 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 추가
public class BaseTimeEntity {
    @CreatedDate // 엔티티가 생성되어 저장될 때 시간이 자동으로 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 엔티티의 값을 변경할 때 시간이 자동으로 저장된다.
    private LocalDateTime modifiedDate;
}
