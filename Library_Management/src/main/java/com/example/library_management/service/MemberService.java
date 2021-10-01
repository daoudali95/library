package com.example.library_management.service;

import com.example.library_management.dao.Library_Record;
import com.example.library_management.dao.Member;
import com.example.library_management.repo.MemberRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(Member member){return memberRepository.save(member);}

    public Optional<Member> findMember(Integer id){return memberRepository.findById(id);}

    public List<Member> getAllMembers(){return memberRepository.findAll();}

    public void deleteMember(int id){
        memberRepository.deleteById(id);
    }

}
