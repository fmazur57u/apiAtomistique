package fr.florian.mazur.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.dto.IsotopeDto;
import fr.florian.mazur.entity.Atome;
import fr.florian.mazur.repository.AtomeRepository;
import fr.florian.mazur.utils.ApiAtomistiqueException;

@SpringBootTest
class AtomeServiceTest {

	@Autowired
	AtomeServiceImpl atomeService;
	
	@MockBean
	AtomeRepository atomeRepository;
	
	@Test
	void testObtenirInfosBasiqueAtomeEtIonsExceptionSymbole() {
		String symbole = "toto";
		int a = 0;
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a);
		});
		String message = "Le symbole que vous avez rentrer ne correspond à aucun atome.";
		assertEquals(message, illegalArgumentException.getMessage());
	}
	
	@Test
	void testObtenirInfosBasiqueAtomeEtIonsExceptionIsotope() {
		String symbole = "H";
		int a = 4;
		ApiAtomistiqueException apiAtomistiqueException = assertThrows(ApiAtomistiqueException.class, () -> {
			atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a);
		});
		String message = "Le nombre de masse a sélectionnée ne correspond à aucun Isotopes de l'atome entrer.";
		assertEquals(message, apiAtomistiqueException.getMessage());
	}
	
	@Test
	void testObtenirInfosBasiqueAtomeEtIonsExceptionCharge() {
		String symbole = "H3+";
		int a = 2;
		Atome atome = new Atome(1, "H", "-1,1");
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		ApiAtomistiqueException apiAtomistiqueException = assertThrows(ApiAtomistiqueException.class, () -> {
			atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a);
		});
		String message = "La charge sélectionnée n'éxiste pas pour cette atome.";
		assertEquals(message, apiAtomistiqueException.getMessage());
	}
	
	@Test
	void testObtenirInfosBasiqueAtomeEtIonsExceptionAppelBase() {
		String symbole = "H";
		int a = 2;
		when(atomeRepository.findBySymbole(anyString())).thenThrow(new DataAccessException("..."){ });
		DataAccessException dataAccessException = assertThrows(DataAccessException.class, () -> {
			atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a);
		});
		String message = "Impossible d'accéder à la table Atome";
		assertEquals(message, dataAccessException.getMessage());
	}
	
	
	@Test
	void testObtenirInfosBasiqueAtome() throws ApiAtomistiqueException {
		String symbole = "H";
		int a = 2;
		Atome atome = new Atome(1, "H", "-1,1");
		AtomeDto atomeDto = new AtomeDto(1, 1, 1);
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a).toString());
	}
	
	@Test
	void testObtenirInfosBasiqueAnionUnMoins() throws ApiAtomistiqueException {
		String symbole = "H-";
		int a = 2;
		Atome atome = new Atome(1, "H", "-1,1");
		AtomeDto atomeDto = new AtomeDto(1, 1, 2);
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a).toString());
	}
	
	@Test
	void testObtenirInfosBasiqueCationUnPlus() throws ApiAtomistiqueException {
		String symbole = "H+";
		int a = 2;
		Atome atome = new Atome(1, "H", "-1,1");
		AtomeDto atomeDto = new AtomeDto(1, 1, 0);
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a).toString());
	}
	
	@Test
	void testObtenirInfosBasiqueIons() throws ApiAtomistiqueException {
		String symbole = "Fe2+";
		int a = 56;
		Atome atome = new Atome(26, "Fe", "2,3,4,6");
		AtomeDto atomeDto = new AtomeDto(26, 30, 24);
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons(symbole, a).toString());
	}
	
	@Test
	void testObtenirInfosBasiqueIsotopeDataAccessException() {
		int z = 1;
		int a = 2;
		when(atomeRepository.findByZ(anyInt())).thenThrow(new DataAccessException("..."){ });
		DataAccessException dataAccessException = assertThrows(DataAccessException.class, () -> {
			atomeService.obtenirInfosBasiqueIsotopes(z, a);
		});
		String message = "Impossible d'accéder à la table Atome";
		assertEquals(message, dataAccessException.getMessage());
	}
	
	@Test
	void testObtenirInfosBasiqueIsotopeZException() {
		int z = 1446467;
		int a = 2;
		when(atomeRepository.findByZ(anyInt())).thenReturn(null);
		ApiAtomistiqueException apiAtomistiqueException = assertThrows(ApiAtomistiqueException.class, () -> {
			atomeService.obtenirInfosBasiqueIsotopes(z, a);
		});
		String message = "Le numéros atomique Z entrer ne correspond à aucun atome de la classification périodique des éléments.";
		assertEquals(message, apiAtomistiqueException.getMessage());
	}
	
	@Test
	void testObtenirInfosBasiqueIsotopeAException() {
		int z = 1;
		int a = 4;
		Atome atome = new Atome(1, "H");
		when(atomeRepository.findByZ(anyInt())).thenReturn(atome);
		ApiAtomistiqueException apiAtomistiqueException = assertThrows(ApiAtomistiqueException.class, () -> {
			atomeService.obtenirInfosBasiqueIsotopes(z, a);
		});
		String message = "Le nombre de masse A sélectionnée ne correspond à aucun Isotopes de l'atome récupérer de la base de donnée Atome.";
		assertEquals(message, apiAtomistiqueException.getMessage());
	}
	
	
	@Test
	void testObtenirInfosBasiqueIsotope() throws ApiAtomistiqueException {
		int z = 6;
		int a = 14;
		Atome atome = new Atome(6, "C");
		when(atomeRepository.findByZ(anyInt())).thenReturn(atome);
		IsotopeDto isotopeDto = new IsotopeDto("X est un isotope de C.", "X possède 8 neutrons par atome.", "X possède 6 électrons par atome.", "X possède 6 protons par atome.");
		assertEquals(isotopeDto.toString(), atomeService.obtenirInfosBasiqueIsotopes(z, a).toString());
	}
	
	
}
