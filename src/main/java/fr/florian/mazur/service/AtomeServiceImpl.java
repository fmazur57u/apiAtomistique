package fr.florian.mazur.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.common.base.CharMatcher;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.entity.Atome;
import fr.florian.mazur.repository.AtomeRepository;
import fr.florian.mazur.utils.ApiAtomistiqueException;
import fr.florian.mazur.utils.EnumClassificationPeriodique;

@Service
public class AtomeServiceImpl implements AtomeService {

	private AtomeRepository atomeRepository;
	
	public AtomeServiceImpl(AtomeRepository atomeRepository) {
		this.atomeRepository = atomeRepository;
	}



	@Override
	public AtomeDto obtenirInfosBasiqueAtomeEtIons(String symbole, int a) throws ApiAtomistiqueException {
		Atome atome;
		String symboleRequest = CharMatcher.anyOf("123456789+-").removeFrom(symbole);
		int charge;
		try {
			verifySymboleAndA(symboleRequest, a);
			atome = atomeRepository.findBySymbole(symboleRequest);
			charge = calculeCharge(symbole, symboleRequest);
			verifyCharge(atome, charge);
		} catch (ApiAtomistiqueException  e ) {
			throw new ApiAtomistiqueException(e.getMessage());
		} catch (IllegalArgumentException  e ) {
			throw new IllegalArgumentException("Le symbole que vous avez rentrer ne correspond à aucun atome.");
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
	
	private void verifySymboleAndA(String symboleRequest, int a) throws ApiAtomistiqueException {
		if(EnumClassificationPeriodique.valueOf(symboleRequest).getValeur().stream().noneMatch(numA -> numA == a)) {
			throw new ApiAtomistiqueException("Le nombre de masse a sélectionnée ne correspond à aucun Isotopes de l'atome entrer.");
		}
	}
	
	private void verifyCharge(Atome atome, int charge) throws ApiAtomistiqueException {
		if (charge !=0 ) {
			boolean existeCharge = Arrays.asList(atome.getDegresOxydation().split(",")).stream().map(Integer::parseInt).noneMatch(ch -> ch == charge);
			if(existeCharge) {
				throw new ApiAtomistiqueException("La charge sélectionnée n'éxiste pas pour cette atome.");
			}
		}
	}
	
	private int calculeCharge(String symbole, String symboleRequest) {
		int charge;
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
		return charge;
	}
}
