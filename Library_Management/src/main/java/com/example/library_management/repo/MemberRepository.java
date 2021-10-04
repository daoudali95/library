package com.example.library_management.repo;

import com.example.library_management.dao.Book;
import com.example.library_management.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberName(String memberName);
}