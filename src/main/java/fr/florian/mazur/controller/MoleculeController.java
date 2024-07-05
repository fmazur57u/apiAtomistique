package fr.florian.mazur.controller;

import org.openscience.cdk.exception.InvalidSmilesException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.florian.mazur.dto.MoleculeDto;
import fr.florian.mazur.service.MoleculeService;

@RestController
@RequestMapping("/molecule")
public class MoleculeController {

	private MoleculeService service;

	public MoleculeController(MoleculeService service) {
		this.service = service;
	}
	
	@PostMapping(value="/saveMolecule", produces="application/json")
	public void sauvegarderMolecule(@RequestBody MoleculeDto moleculeDto) throws InvalidSmilesException {
		service.saveMolecule(moleculeDto);
	}
}
