package fr.florian.mazur.service;

import fr.florian.mazur.dto.AtomeDto;

public interface AtomeService {

	public AtomeDto obtenirInfosBasiqueAtomeEtIons(String symbole, int a, int charge);
}
