package com.pandemic.apirest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandemic.apirest.dto.HospitalDTO;
import com.pandemic.apirest.models.Hospital;
import com.pandemic.apirest.repository.HospitalRepository;

@RestController
@RequestMapping(value = "/api")
public class HospitalResource {

	@Autowired
	HospitalRepository hospitalRepository;

	@GetMapping("/hospitais")
	public List<HospitalDTO> listaHospitais() {

		List<Hospital> hospitais = hospitalRepository.findAll();

		List<HospitalDTO> hospitaisDTO = new ArrayList<HospitalDTO>();

		for (Hospital hospital : hospitais) {
			hospitaisDTO.add(new HospitalDTO(hospital)); 
		}

		return hospitaisDTO;
	}

	@GetMapping("/hospital/{id}")
	public HospitalDTO procuraHospital(@PathVariable long id) {

		Optional<Hospital> hospitalOptional = hospitalRepository.findById(id);

		if (hospitalOptional.isEmpty()) {
			return null;
		}

		return new HospitalDTO(hospitalOptional.get());

	}
}
