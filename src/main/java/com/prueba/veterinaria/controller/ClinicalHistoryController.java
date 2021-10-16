package com.prueba.veterinaria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.prueba.veterinaria.config.exception.NotFoundException;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.dto.ClinicalHistoryDTO;
import com.prueba.veterinaria.model.ClinicalHistory;
import com.prueba.veterinaria.service.IClinicalHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vet/CliHis")
public class ClinicalHistoryController {
    
    @Autowired
    private IClinicalHistoryService serviceClinicaHistory;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
	public ClinicalHistoryDTO findById(@Valid @PathVariable("id") int clinical_history_id) {

        Optional<ClinicalHistory> clinicalHistory = serviceClinicaHistory.searchById(clinical_history_id);
        if(clinicalHistory.isPresent()) {

            return modelMapper.map(clinicalHistory.get(), ClinicalHistoryDTO.class);
        }else{

            throw new NotFoundException("No se encontro ninguna historia clinica con el id: "+clinical_history_id);
        } 
	}

    @GetMapping("/my/{id}")
	public List<ClinicalHistoryDTO> findByPet(@Valid @PathVariable("id") int pet_id) {

        List<ClinicalHistory> cliHisPet = serviceClinicaHistory.searchAllClinicalHistoryByPetId(pet_id);
        return cliHisPet.stream()
            .map(ClinicalHistory -> modelMapper
            .map(ClinicalHistory, ClinicalHistoryDTO.class))
            .collect(Collectors.toList()); 
	}

    @DeleteMapping("/{id}")
	public Response deleteById(@PathVariable("id") int clinical_history_id) {

		return serviceClinicaHistory.delete(clinical_history_id);
	}

    @GetMapping()
	public List<ClinicalHistoryDTO> findAllPets() {		

        List<ClinicalHistory> cliHisList = serviceClinicaHistory.searchAll();
		
        return cliHisList.stream()
            .map(ClinicalHistory -> modelMapper
            .map(ClinicalHistory, ClinicalHistoryDTO.class))
            .collect(Collectors.toList());       
	}
}
