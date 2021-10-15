package com.prueba.veterinaria.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import java.util.Optional;
import com.prueba.veterinaria.config.exception.NotFoundException;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.dto.MemberDTO;
import com.prueba.veterinaria.model.Member;
import com.prueba.veterinaria.service.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vet/member")
public class MemberController {
    
    @Autowired
    private IMemberService serviceMember;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public MemberDTO save(@Valid @RequestBody MemberDTO memberDTO) {

        Member member = modelMapper.map(memberDTO, Member.class);
        member = serviceMember.saveMember(member);
        return modelMapper.map(member,MemberDTO.class);
    }

    @GetMapping
	public List<MemberDTO> searchAllMember() {

        List<Member> memberList = serviceMember.searchAll();
        if(memberList.size() > 0) {

        	return memberList.stream()
                .map(Member -> modelMapper
                .map(Member, MemberDTO.class))
                .collect(Collectors.toList());            
        }else {
           
            throw new NotFoundException("No se encontro ningun usuario.");
        }
	}

    @GetMapping("/{id}")
	public MemberDTO findById(@Valid @PathVariable("id") int member_id) {

        Optional<Member> member = serviceMember.searchById(member_id);
        if(member.isPresent()) {

            return modelMapper.map(member.get(), MemberDTO.class);
        }else{

            throw new NotFoundException("No se encontro ningun usuario con el id: "+member_id);
        } 
	}

    @DeleteMapping("/{id}")
	public Response deleteById(@PathVariable("id") int member_id) {

		return serviceMember.delete(member_id);
	}
}
