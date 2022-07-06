package com.example.demo.studedent;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudedentController {

    private final StudedentService studentService;

    public StudedentController(StudedentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Studedent> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudedent(@RequestBody Studedent studedent){
        studentService.addNewStudedent(studedent);
    }

    @DeleteMapping(path = "{studedentId}")
    public void deleteStudedent(@PathVariable("studedentId") Long id){
        studentService.deleteStudedent(id);
    }


    @PutMapping(path = "{studedentId}")
    public void updateStudedent(@PathVariable("studedentId") Long id,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String email){
        studentService.updateStudedent(id, name, email);
    }
}
