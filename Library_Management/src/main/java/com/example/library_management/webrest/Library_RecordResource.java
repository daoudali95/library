package com.example.library_management.webrest;


import com.example.library_management.dao.Book;
import com.example.library_management.dao.Library_Record;
import com.example.library_management.dto.Library_Recorddto;
import com.example.library_management.service.Library_RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class Library_RecordResource {
    private final Library_RecordService library_recordService;

    public Library_RecordResource(Library_RecordService library_recordService) {
        this.library_recordService = library_recordService;
    }

    @PostMapping("enterRecord")
    public ResponseEntity<Library_Record> creatRecord(@RequestBody Library_Recorddto library_recorddto){
        Library_Record library_RecordRes = library_recordService.createRecord(library_recorddto);
        return ResponseEntity.ok().body(library_RecordRes);
    }

    @GetMapping("/record/{id}")
    public Optional<Library_Record> retrieveRecord(@PathVariable int id){
        return library_recordService.findRecord(id);
    }

    @GetMapping("AllRecords")
    public ResponseEntity<List<Library_Record>>AllRecords(){
        List<Library_Record> library_Records = library_recordService.getAllRecords();
        return ResponseEntity.ok().body(library_Records);
    }

    @DeleteMapping("/delRecord/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable int id){
        library_recordService.deleteRecord(id);
        return ResponseEntity.ok().body("Record deleted id : "+ id);
    }
}
