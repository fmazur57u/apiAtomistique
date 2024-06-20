package fr.florian.mazur.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.service.AtomeService;

@RestController
@RequestMapping("/atome")
public class AtomeController {
	
	private AtomeService atomeService;
	
	public AtomeController(AtomeService atomeService) {
		this.atomeService = atomeService;
	}



	@GetMapping(value="/basic_info/{symbole}/{a}", produces="application/json")
	public ResponseEntity<AtomeDto> getBasicInfos(@PathVariable String symbole, @PathVariable int a) {
		AtomeDto atomeDto = atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a);
		return new ResponseEntity<AtomeDto>(atomeDto, HttpStatus.OK);	
	}
	
}
