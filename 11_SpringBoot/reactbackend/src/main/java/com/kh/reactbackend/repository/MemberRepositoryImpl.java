package com.kh.reactbackend.repository;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // 해당 클레스는 DB와 관련된 작업을 수행하는 클래스다.
public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext // EntityManager를 주입해줘.
    private EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member); // 영속
    }

    public Optional<Member> findOne(String userId) {
        return Optional.ofNullable(em.find(Member.class, userId));
    }

    @Override
    public void delete(Member member) { em.remove(member); }

    @Override
    public List<Member> findAll() {
        //JPQL : 엔티티기반 쿼리를 전달하는 방법
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Override
    public List<Member> findByName(String name) {
        String query = "select m from Member m where m.userName LIKE :username";
        return em.createQuery(query, Member.class).setParameter("username", "%"+name+"%").getResultList();
    }

    @Override
    public void isDeleted(Member member) {
        String query = "update Member m set m.isDeleted='Y' where m.userId = :userId";

        em.createQuery(query)
                .setParameter("userId", member.getUserId())
                .executeUpdate();

    }

    @Override
    public Optional<Member> findByIdandPwd(String userId, String userPwd) {
        String query = "select  m from Member m where m.userId = :userId and m.userPwd = :userPwd";

        return em.createQuery(query, Member.class).setParameter("userId", userId).setParameter("userPwd", userPwd).getResultList().stream().findFirst();

    }

    @Override
    public MemberDto.MemberLoginResponse MemberLoginResponse(Member member) {
        String query = "select m from Member m where m.userId = :userId";
        return em.createQuery(query, Member.class)
                .setParameter("userId", member.getUserId())
                .getResultStream()
                .map(MemberDto.MemberLoginResponse::toDto)
                .findFirst()
                .orElse(null);
        //return em.createQuery(query, Member.class).setParameter("userId", member.getUserId()).getResultStream().map(MemberDto.MemberLoginResponse::toDto).findFirst().orElse(null);
//        return em.createQuery(query, Member.class).setParameter("userId", member.getUserId()).getResultStream();
    }
}
