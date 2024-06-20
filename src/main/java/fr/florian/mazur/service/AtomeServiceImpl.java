package fr.florian.mazur.service;

import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.CharMatcher;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.entity.Atome;
import fr.florian.mazur.repository.AtomeRepository;
import fr.florian.mazur.utils.NombreDeMasse;

@Service
public class AtomeServiceImpl implements AtomeService {

	private AtomeRepository atomeRepository;
	
	public AtomeServiceImpl(AtomeRepository atomeRepository) {
		this.atomeRepository = atomeRepository;
	}



	@Override
	public AtomeDto obtenirInfosBasiqueAtomeEtIons(String symbole, int a) {
		Atome atome;
		String symboleRequest = CharMatcher.anyOf("12345678+-").removeFrom(symbole);
		int charge;
		try {
			if(NombreDeMasse.valueOf(symboleRequest).getValeur().stream().noneMatch(numA -> numA == a)) {
				return null;
			} else {
				atome = atomeRepository.findBySymbole(symboleRequest);
			};
		} catch (IllegalArgumentException  e ) {
			throw new IllegalArgumentException("Le symbole que vous avez rentrer ne correspond à aucun atome.");
		}
		  catch (RuntimeException e) {
			throw new RuntimeException("Impossible d'accéder à la table Atome");
		}
		
		String chargeString = CharMatcher.anyOf(symboleRequest).removeFrom(symbole);
		if (chargeString.equalsIgnoreCase("+")) {
			charge = 1;
		}
		else if(chargeString.equalsIgnoreCase("-")) {
			charge = -1;
		} else if(chargeString.length() == 2) {
			String chargeSigne = "" + chargeString.charAt(1) + chargeString.charAt(0);
			charge = Integer.parseInt(chargeSigne);
		} else {
			charge = 0;
		}
		int protons = atome.getZ();
		int neutrons = a - atome.getZ();
		int electrons = atome.getZ()-charge;
		AtomeDto atomeDto = new AtomeDto(protons, neutrons, electrons);
		return atomeDto; 
	}

}
