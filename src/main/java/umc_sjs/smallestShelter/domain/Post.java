package umc_sjs.smallestShelter.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.sql.Timestamp;

import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 못쓰게 막아둠
@Getter
@Setter
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_idx")
    private Long idx;

    // 게시물 이미지
    private String imgUrl;

    // 게시물 내용
    private String content;

    // 해당 게시물을 등록한 동물
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "animal_idx")
    private Animal animal;

    // 게시물이 만들어진 시간
    @CreationTimestamp
    private Timestamp createDate;

    // 생성자
    public static Post createPost(String imgUrl, String content, Animal animal){
        Post post = new Post();
        post.setImgUrl(imgUrl);
        post.setContent(content);
        post.setAnimal(animal);

        return post;
    }
}
