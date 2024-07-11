package fr.florian.mazur.service;

import java.util.ArrayList;
import java.util.List;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import fr.florian.mazur.dto.MoleculeGetDto;
import fr.florian.mazur.dto.MoleculeSaveDto;
import fr.florian.mazur.entity.Molecule;
import fr.florian.mazur.repository.MoleculeRepository;
import fr.florian.mazur.utils.ApiAtomistiqueException;

@Service
public class MoleculeServiceImpl implements MoleculeService {

	private MoleculeRepository repository;

	public MoleculeServiceImpl(MoleculeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveMolecule(MoleculeSaveDto moleculeDto) throws InvalidSmilesException {
		Molecule molecule = new Molecule();
		molecule.setFormuleBrute(moleculeDto.getFormuleBrute());
		SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
		IAtomContainer mol = null;
		try {
			mol = sp.parseSmiles(moleculeDto.getSmiles());
			molecule.setMasseMolaire(AtomContainerManipulator.getMass(mol));
			molecule.setMomentDipolaire(moleculeDto.getMomentDipolaire());
			repository.save(molecule);
		} catch (InvalidSmilesException e) {
			throw new InvalidSmilesException("Le Smile entrer n'est pas compatible.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			throw new RuntimeException("Il y a eu un probléme lors de la sauvegarde de la molécule.");
		}
	}

	@Override
	public List<MoleculeGetDto> getAllMolecules() {
		List<Molecule> molecules = new ArrayList<>();
		List<MoleculeGetDto> moleculesDto = new ArrayList<>();
		try {
			molecules = repository.findAll();
		} catch (DataAccessException e) {
			throw new DataAccessException("Impossible d'accéder à la table Molecule") {
			};
		}
		molecules.forEach(mol -> {
			MoleculeGetDto moleculeDto = new MoleculeGetDto();
			moleculeDto.setFormuleBrute(mol.getFormuleBrute());
			moleculeDto.setMasseMolaire(mol.getMasseMolaire());
			moleculeDto.setMomentDipolaire(mol.getMomentDipolaire());
			moleculesDto.add(moleculeDto);
		});
		return moleculesDto;
	}

	@Override
	public void updateMolecule(MoleculeSaveDto moleculeDto) throws InvalidSmilesException, ApiAtomistiqueException {
		try {
			verifyId(moleculeDto);
			Molecule molecule = new Molecule();
			molecule.setFormuleBrute(moleculeDto.getFormuleBrute());
			SmilesParser sp = new SmilesParser(DefaultChemObjectBuilder.getInstance());
			IAtomContainer mol = null;
			mol = sp.parseSmiles(moleculeDto.getSmiles());
			molecule.setMasseMolaire(AtomContainerManipulator.getMass(mol));
			molecule.setMomentDipolaire(moleculeDto.getMomentDipolaire());
			molecule.setIdMolecule(moleculeDto.getId());
			repository.save(molecule);
		} catch (ApiAtomistiqueException e) {
			throw e;
		} catch (InvalidSmilesException e) {
			throw new InvalidSmilesException("Le Smile entrer n'est pas compatible.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			throw new RuntimeException("Il y a eu un probléme lors de la sauvegarde de la molécule.");
		}
	}

	private void verifyId(MoleculeSaveDto moleculeDto) throws ApiAtomistiqueException {
		if (moleculeDto.getId() == null) {
			throw new ApiAtomistiqueException("L'id ne doit pas être null");
		}
	}

	@Override
	public void deleteMolecule(int id) {
		repository.deleteById(id);
	}

	@Override
	public MoleculeGetDto getMoleculeByID(int id) {
		MoleculeGetDto moleculeDto = new MoleculeGetDto();
		Molecule molecule = null;
		this.repository.findById(id).ifPresent(
			mol -> {
				moleculeDto.setFormuleBrute(mol.getFormuleBrute());
				moleculeDto.setMasseMolaire(mol.getMasseMolaire());
				moleculeDto.setMomentDipolaire(mol.getMomentDipolaire());
			}
		);
		return moleculeDto;
	}

}
