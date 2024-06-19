package fr.florian.mazur.service;

import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.entity.Atome;
import fr.florian.mazur.repository.AtomeRepository;

@Service
public class AtomeServiceImpl implements AtomeService {

	private AtomeRepository atomeRepository;
	
	public AtomeServiceImpl(AtomeRepository atomeRepository) {
		this.atomeRepository = atomeRepository;
	}



	@Override
	public AtomeDto obtenirInfosBasiqueAtomeEtIons(String symbole, int a, int charge) {
		Atome atome;
		String symboleRequest = null;
		try {
			if (charge == 0) {
				symboleRequest = symbole;
			}
			else if(charge == 1) {
				symboleRequest = symbole.replace("+", "");
			}
			else if(charge == -1) {
				symboleRequest = symbole.replace("-", "");
			} else {
				symboleRequest = symbole.split(String.valueOf(charge))[0];
			}
			atome = atomeRepository.findBySymbole(symboleRequest);

		} catch (PatternSyntaxException e){
			throw new PatternSyntaxException("Impossible de split le symbole", symboleRequest, charge);
		}
		  catch (RuntimeException e) {
			throw new RuntimeException("Impossible d'accéder à la table Atome");
		}
		int protons = atome.getZ();
		int neutrons = a - atome.getZ();
		int electrons = atome.getZ()-charge;
		AtomeDto atomeDto = new AtomeDto(protons, neutrons, electrons);
		return atomeDto;
	}

}
