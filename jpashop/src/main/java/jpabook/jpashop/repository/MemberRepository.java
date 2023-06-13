package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {


    @PersistenceContext
    private EntityManager em;

    // 생성 
    public void save(Member member){
        em.persist(member);
    }

    // 한 건 조회
    public Member findOne(Long id) {
        return em.find(Member.class,id);
    }

    // JPQL 작성, SQL 과 다른 점은 Table 아닌 Entity 대상으로 Query
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // 특정 이름으로 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
