package com.example.library_management.service;

import com.example.library_management.dao.Book;
import com.example.library_management.dao.Library_Record;
import com.example.library_management.dao.Member;
import com.example.library_management.dto.Library_Recorddto;
import com.example.library_management.repo.BookRepository;
import com.example.library_management.repo.Library_RecordRepository;
import com.example.library_management.repo.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Library_RecordService {
    private final Library_RecordRepository library_RecordRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public Library_RecordService(Library_RecordRepository library_RecordRepository, BookRepository bookRepository,
        MemberRepository memberRepository) {
        this.library_RecordRepository = library_RecordRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public Library_Record createRecord(Library_Recorddto library_recorddto){
        Library_Record library_record = new Library_Record();

        library_record.setIssue_date(library_recorddto.getIssue_date());
        library_record.setReturn_date(library_recorddto.getReturn_date());

        Optional<Book> book = bookRepository.findById(library_recorddto.getBook_id());
        if (book.isPresent())
            library_record.setBook(book.get());

        Optional<Member> member = memberRepository.findById(library_recorddto.getMember_id());
        if (member.isPresent())
            library_record.setMember(member.get());

        return library_RecordRepository.save(library_record);
    }

    public Optional<Library_Record> findRecord(Integer id){return library_RecordRepository.findById(id);}

    public List<Library_Record> getAllRecords(){return library_RecordRepository.findAll();}

    public void deleteRecord(int id){
        library_RecordRepository.deleteById(id);
    }
}