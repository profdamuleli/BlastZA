package com.example.demo.studedent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //because this interface is responsible for data access
public interface StudedentRepository extends JpaRepository<Studedent, Long> {

    // SELECT * FROM studedent WHERE email = ?
    @Query("SELECT s FROM Studedent s WHERE s.email = ?1") // this is jpql not straight sql
    Optional<Studedent> findStudedentByEmail(String email);
}
