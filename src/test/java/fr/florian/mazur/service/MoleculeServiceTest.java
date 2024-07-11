package fr.florian.mazur.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;

import fr.florian.mazur.dto.MoleculeGetDto;
import fr.florian.mazur.dto.MoleculeSaveDto;
import fr.florian.mazur.entity.Molecule;
import fr.florian.mazur.repository.MoleculeRepository;

@SpringBootTest
class MoleculeServiceTest {

	@Autowired
	private MoleculeServiceImpl service;
	
	@MockBean
	private MoleculeRepository repository;
	
	@Test
	void testSaveMoleculesInvalidSmilesException() {
		MoleculeSaveDto moleculeDto = new MoleculeSaveDto("toto", "toto", 0);
		InvalidSmilesException invalidSmilesException = assertThrows(InvalidSmilesException.class, () -> {
			service.saveMolecule(moleculeDto);
		});
		String message = "Le Smile entrer n'est pas compatible.";
		assertEquals(message, invalidSmilesException.getMessage());
	}
	
	@Test
	void testSaveMoleculesRuntimeException() {
		MoleculeSaveDto moleculeDto = new MoleculeSaveDto("CH4", "C", 0);
		when(repository.save(any(Molecule.class))).thenThrow(IllegalArgumentException.class);
		RuntimeException illegalArgumentException = assertThrows(RuntimeException.class, () -> {
			service.saveMolecule(moleculeDto);
		});
		String message = "Il y a eu un probléme lors de la sauvegarde de la molécule.";
		assertEquals(message, illegalArgumentException.getMessage());
	}
	
	@Test
	void testGetAllDataAccesException() {
		when(repository.findAll()).thenThrow(new DataAccessException("...") {});
		DataAccessException dataAccessException = assertThrows(DataAccessException.class, () -> {
			service.getAllMolecules();
		});
		String message = "Impossible d'accéder à la table Molecule";
		assertEquals(message, dataAccessException.getMessage());
	}
	
	@Test
	void testGetAll() {
		List<Molecule> molecule = new ArrayList<>();
		List<MoleculeGetDto> moleculeDtos = new ArrayList<>();
		when(repository.findAll()).thenReturn(molecule);
		assertEquals(moleculeDtos, service.getAllMolecules());
	}
	
}
