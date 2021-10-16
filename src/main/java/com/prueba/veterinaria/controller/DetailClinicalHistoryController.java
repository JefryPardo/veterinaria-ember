package com.prueba.veterinaria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.prueba.veterinaria.config.exception.NotFoundException;
import com.prueba.veterinaria.config.exception.Response;
import com.prueba.veterinaria.dto.DetailClinicalHistoryDTO;
import com.prueba.veterinaria.model.DetailClinicalHistory;
import com.prueba.veterinaria.service.IDetailClinicalHistoryService;
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
@RequestMapping("/vet/detail")
public class DetailClinicalHistoryController {
    
    @Autowired
    private IDetailClinicalHistoryService serviceDetailsClinicalHistory;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public DetailClinicalHistoryDTO save(@Valid @RequestBody DetailClinicalHistoryDTO detailDTO) {

        DetailClinicalHistory detail = modelMapper.map(detailDTO, DetailClinicalHistory.class);
        detail = serviceDetailsClinicalHistory.saveDetailClinicalHistory(detail);
        return modelMapper.map(detail,DetailClinicalHistoryDTO.class);
    }  
    
    @GetMapping
	public List<DetailClinicalHistoryDTO> searchAllDetail() {

        List<DetailClinicalHistory> detailList = serviceDetailsClinicalHistory.searchAll();
        return detailList.stream()
            .map(DetailClinicalHistory -> modelMapper
            .map(DetailClinicalHistory, DetailClinicalHistoryDTO.class))
            .collect(Collectors.toList()); 
	}

    @GetMapping("/{id}")
	public DetailClinicalHistoryDTO findById(@Valid @PathVariable("id") int detail_id) {

        Optional<DetailClinicalHistory> detail = serviceDetailsClinicalHistory.searchById(detail_id);
        if(detail.isPresent()) {

            return modelMapper.map(detail.get(), DetailClinicalHistoryDTO.class);
        }else{

            throw new NotFoundException("No se encontro ningun Detalle de la historia clinica con el id: "+detail_id);
        } 
	}

    @GetMapping("/my/{id}")
	public List<DetailClinicalHistoryDTO> findAllDetailsByClinical(@Valid @PathVariable("id") int clinical_history_id) {

        List<DetailClinicalHistory> detailList = serviceDetailsClinicalHistory.searchAllDetailClinicalHistoryByClinicalId(clinical_history_id);
        return detailList.stream()
            .map(DetailClinicalHistory -> modelMapper
            .map(DetailClinicalHistory, DetailClinicalHistoryDTO.class))
            .collect(Collectors.toList());  
	}

    @DeleteMapping("/{id}")
	public Response deleteById(@PathVariable("id") int detail_id) {

		return serviceDetailsClinicalHistory.delete(detail_id);
	}
}
