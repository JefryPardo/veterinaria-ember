package com.prueba.veterinaria.service;

import java.util.List;
import javax.validation.Valid;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.Member;

public interface IMemberService {
    
    List<Member> searchAll();
    Optional<Member> searchById(int member_id);
    Member saveMember(@Valid Member member);
    Response delete(int member_id);
}
