package fr.florian.mazur.service;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.dto.IsotopeDto;
import fr.florian.mazur.utils.ApiAtomistiqueException;

public interface AtomeService {

	public AtomeDto obtenirInfosBasiqueAtomeEtIons(String symbole, int a) throws ApiAtomistiqueException;
	
	public IsotopeDto obtenirInfosBasiqueIsotopes(int z, int a) throws ApiAtomistiqueException;
}
