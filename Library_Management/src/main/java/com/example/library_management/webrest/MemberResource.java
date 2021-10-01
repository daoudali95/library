package com.example.library_management.webrest;

import com.example.library_management.dao.Book;
import com.example.library_management.dao.Library_Record;
import com.example.library_management.dao.Member;
import com.example.library_management.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class MemberResource {
    private final MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("member")
    public ResponseEntity<Member> creatMember(@RequestBody Member member){
        Member memberRes = memberService.create(member);
        return ResponseEntity.ok().body(memberRes);
    }

    @GetMapping("Allmembers")
    public ResponseEntity<List<Member>>AllMembers(){
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok().body(members);
    }

    @GetMapping("/member/{id}")
    public Optional<Member> retrieveMember(@PathVariable int id){
        return memberService.findMember(id);
    }

    @DeleteMapping("/delMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable int id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().body("Record deleted id : "+ id);
    }
}
