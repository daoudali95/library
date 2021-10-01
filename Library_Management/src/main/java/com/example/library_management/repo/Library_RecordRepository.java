package com.example.library_management.repo;

import com.example.library_management.dao.Library_Record;
import com.example.library_management.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Library_RecordRepository extends JpaRepository<Library_Record, Integer> {
}
