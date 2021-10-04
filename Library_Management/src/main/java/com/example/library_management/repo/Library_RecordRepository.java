package com.example.library_management.repo;

import com.example.library_management.dao.Book;
import com.example.library_management.dao.Library_Record;
import com.example.library_management.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Library_RecordRepository extends JpaRepository<Library_Record, Integer> {
//    Optional<Library_Record> findByMemberName(String memberName);
//    Optional<Library_Record> findByBookName(String bookName);
}