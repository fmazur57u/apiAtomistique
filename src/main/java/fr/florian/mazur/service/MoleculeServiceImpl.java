package fr.florian.mazur.service;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import fr.florian.mazur.dto.MoleculeDto;
import fr.florian.mazur.entity.Molecule;
import fr.florian.mazur.repository.MoleculeRepository;

@Service
public class MoleculeServiceImpl implements MoleculeService{
	
	private MoleculeRepository repository;
	
	

	public MoleculeServiceImpl(MoleculeRepository repository) {
		this.repository = repository;
	}



	@Override
	public void saveMolecule(MoleculeDto moleculeDto) throws InvalidSmilesException {
		Molecule molecule = new Molecule();	
		molecule.setFormuleBrute(moleculeDto.getFormuleBrute());
		SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
		IAtomContainer mol = null;
		try {
			mol = sp.parseSmiles(moleculeDto.getSmiles());
			molecule.setMasseMolaire(AtomContainerManipulator.getMass(mol));
			repository.save(molecule);
		} catch (InvalidSmilesException e) {
			throw new InvalidSmilesException("Le Smile entrer n'est pas compatible.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			throw new RuntimeException("Il y a eu un problémée lors de la sauvegarde de la molécule.");
		}
	}

}
