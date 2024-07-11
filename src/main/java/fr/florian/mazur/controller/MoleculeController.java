package fr.florian.mazur.controller;

import java.util.List;

import org.openscience.cdk.exception.InvalidSmilesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.florian.mazur.dto.MoleculeGetDto;
import fr.florian.mazur.dto.MoleculeSaveDto;
import fr.florian.mazur.service.MoleculeService;
import fr.florian.mazur.utils.ApiAtomistiqueException;

@RestController
@RequestMapping("/molecule")
public class MoleculeController {

	private MoleculeService service;

	public MoleculeController(MoleculeService service) {
		this.service = service;
	}
	
	@PostMapping(value="/saveMolecule", produces="application/json")
	public void sauvegarderMolecule(@RequestBody MoleculeSaveDto moleculeDto) throws InvalidSmilesException {
		service.saveMolecule(moleculeDto);
	}
	
	@PostMapping(value="/updateMolecule", produces="application/json")
	public void updateMolecule(@RequestBody MoleculeSaveDto moleculeDto) throws InvalidSmilesException, ApiAtomistiqueException {
		service.updateMolecule(moleculeDto);
	}
	
	@GetMapping(value="/getAllMolecules", produces="application/json")
	public ResponseEntity<List<MoleculeGetDto>> getAllMolecules() {
		return new ResponseEntity<>(service.getAllMolecules(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getMoleculeById/{id}", produces="application/json")
	public ResponseEntity<MoleculeGetDto> getMoleculeById(@PathVariable int id) {
		return new ResponseEntity<>(service.getMoleculeByID(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteMolecule/{id}", produces="application/json")
	public void deleteMolecule(@PathVariable int id) {
		service.deleteMolecule(id);
	}
}
