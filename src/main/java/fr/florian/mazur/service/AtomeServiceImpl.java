package fr.florian.mazur.service;

import java.util.Arrays;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.google.common.base.CharMatcher;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.dto.IsotopeDto;
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
		} catch (DataAccessException e) {
			throw new DataAccessException("Impossible d'accéder à la table Atome") {};
		}

		int protons = atome.getZ();
		int neutrons = a - atome.getZ();
		int electrons = atome.getZ()-charge;
		return new AtomeDto(protons, neutrons, electrons); 
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

	private void verifyZAndSymbole(Atome atome, int a) throws ApiAtomistiqueException {
		if (atome == null) {
			throw new ApiAtomistiqueException("Le numéros atomique Z entrer ne correspond à aucun atome de la classification périodique des éléments.");
		} else {
			if(EnumClassificationPeriodique.valueOf(atome.getSymbole()).getValeur().stream().noneMatch(numA -> numA == a)) {
				throw new ApiAtomistiqueException("Le nombre de masse A sélectionnée ne correspond à aucun Isotopes de l'atome récupérer de la base de donnée Atome.");
			}
		}
	}

	@Override
	public IsotopeDto obtenirInfosBasiqueIsotopes(int z, int a) throws ApiAtomistiqueException {
		Atome atome;
		try {
			atome = atomeRepository.findByZ(z);
			verifyZAndSymbole(atome, a);			
		} catch (ApiAtomistiqueException  e ) {
			throw new ApiAtomistiqueException(e.getMessage());
		} catch (DataAccessException e) {
			throw new DataAccessException("Impossible d'accéder à la table Atome") {};
		}
		String symbole = atome.getSymbole();
		int protons = atome.getZ();
		int neutrons = a - atome.getZ();
		int electrons = atome.getZ();
		return new IsotopeDto("X est un isotope de " + symbole + ".", "X possède " + neutrons + " neutrons par atome.", "X possède " + electrons + " électrons par atome.", "X possède " + protons + " protons par atome.");
	}
}
