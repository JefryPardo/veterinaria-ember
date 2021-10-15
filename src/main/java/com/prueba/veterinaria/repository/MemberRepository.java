package com.prueba.veterinaria.repository;

import java.util.Optional;
import com.prueba.veterinaria.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer>{
    
    Optional<Member> findByIdentificationDocument(int identificationDocument);
}
