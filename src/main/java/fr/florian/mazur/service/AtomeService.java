package fr.florian.mazur.service;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.utils.ApiAtomistiqueException;

public interface AtomeService {

	public AtomeDto obtenirInfosBasiqueAtomeEtIons(String symbole, int a) throws ApiAtomistiqueException;
}
