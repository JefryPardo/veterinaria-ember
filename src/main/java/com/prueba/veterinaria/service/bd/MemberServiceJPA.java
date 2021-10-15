package com.prueba.veterinaria.service.bd;

import java.util.List;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.model.Member;
import com.prueba.veterinaria.repository.MemberRepository;
import com.prueba.veterinaria.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MemberServiceJPA implements IMemberService{

    @Autowired
    private MemberRepository memberRepo;

    public List<Member> searchAll() {

        return memberRepo.findAll();
    }

    public Optional<Member> searchById(int member_id) {

        return memberRepo.findById(member_id);
    }

    public Member saveMember(Member member) {

        return memberRepo.save(member);
    }

    public Response delete(int member_id) {
        
        try {
            memberRepo.deleteById(member_id);
             return new Response("Con exito.","Se pudo borrar el usuario con id: "+member_id,"200 OK");
        } catch (Exception e) {
            return new Response("Sin exito","No se pudo borrar el usuario con id: "+member_id,"404 Not Found");                
        }
    }    
}
