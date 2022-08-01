package umc_sjs.smallestShelter;

import org.springframework.stereotype.Repository;
import umc_sjs.smallestShelter.domain.Animal;
import umc_sjs.smallestShelter.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    // 게시글(피드) 생성
    public void create(Post post){
        em.persist(post);
    }

    // 게시물 조회
    public Post findById(Long postIdx){
        return em.find(Post.class, postIdx);
//        return em.createQuery("select p from Post p where p.post_idx = :postIdx", Post.class)
//                .setParameter("postIdx", postIdx)
//                .getSingleResult();
    }

    // 동물 찾기 (이후 삭제 필요)
    public Animal findAnimalByIdx(Long animalIdx){
        return em.find(Animal.class, animalIdx);
    }
}
