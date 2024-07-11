package fr.florian.mazur.service;

import java.util.List;

import org.openscience.cdk.exception.InvalidSmilesException;

import fr.florian.mazur.dto.MoleculeGetDto;
import fr.florian.mazur.dto.MoleculeSaveDto;
import fr.florian.mazur.utils.ApiAtomistiqueException;

public interface MoleculeService {
	
	public void saveMolecule(MoleculeSaveDto moleculeDto) throws InvalidSmilesException;
	
	public MoleculeGetDto getMoleculeByID(int id);
	
	public List<MoleculeGetDto> getAllMolecules();
	
	public void updateMolecule(MoleculeSaveDto moleculeDto) throws InvalidSmilesException, ApiAtomistiqueException ;
	
	public void deleteMolecule(int id);
}
