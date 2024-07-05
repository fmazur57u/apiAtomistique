package fr.florian.mazur.service;

import org.openscience.cdk.exception.InvalidSmilesException;

import fr.florian.mazur.dto.MoleculeDto;

public interface MoleculeService {
	
	public void saveMolecule(MoleculeDto moleculeDto) throws InvalidSmilesException;

}
