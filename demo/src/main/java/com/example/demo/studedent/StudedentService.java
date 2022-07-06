package com.example.demo.studedent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // business logic
public class StudedentService {

    private final StudedentRepository studedentRepository;

    @Autowired
    public StudedentService(StudedentRepository studedentRepository){
        this.studedentRepository = studedentRepository;
    }
    public List<Studedent> getStudents() {
        return studedentRepository.findAll();
    }

    public void addNewStudedent(Studedent studedent) {
        Optional<Studedent> studedentByEmail = studedentRepository.findStudedentByEmail(studedent.getEmail());
        if(studedentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        //if the student is not present we want to save the student
        studedentRepository.save(studedent);
    }

    public void deleteStudedent(Long id) {
        boolean b = studedentRepository.existsById(id);
        if(!b) {
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }
        studedentRepository.deleteById(id);
    }
    @Transactional // doesn't use jpql query
    public void updateStudedent(Long id, String name, String email) {
        Studedent studedent = studedentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "studedent with id " + id + " does not exist"
                ));

        if(name != null && name.length() > 0 && !Objects.equals(studedent.getName(), name)) {
            studedent.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(studedent.getEmail(), email)) {

            Optional<Studedent> studedentOptional = studedentRepository.findStudedentByEmail(email);
            if(studedentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            studedent.setEmail(email);

        }

    }
}
