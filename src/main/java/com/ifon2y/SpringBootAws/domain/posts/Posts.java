package com.ifon2y.SpringBootAws.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
//기본 생성자 자동 추가
@Entity
//테이블과 링크도리 클래스
//테이블 이름 카멜케이스로
public class Posts {
    @Id
    //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK의 생성 규칙
    //IDENTITY옵션을 추가해야만 auto increment가 됨
    private Long id;

    @Column(length = 500, nullable = false)
    //꼭 선얺안해도 필드가 모두 칼럼이 되지만 옵션추가때문에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    //빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
