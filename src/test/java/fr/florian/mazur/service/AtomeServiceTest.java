package fr.florian.mazur.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.florian.mazur.dto.AtomeDto;
import fr.florian.mazur.entity.Atome;
import fr.florian.mazur.repository.AtomeRepository;

@SpringBootTest
class AtomeServiceTest {

	@Autowired
	AtomeServiceImpl atomeService;
	
	@MockBean
	AtomeRepository atomeRepository;
	
	@Test
	void testObtenirInfosBasiqueAtomeEtIonsException() {
		when(atomeRepository.findBySymbole(anyString())).thenThrow(RuntimeException.class);
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
			atomeService.obtenirInfosBasiqueAtomeEtIons("H", 2, 0);
		});
		assertEquals("Impossible d'accéder à la table Atome", runtimeException.getMessage());
	}
	
	@Test
	void testObtenirInfosBasiqueAtome() {
		Atome atome = new Atome(1);
		AtomeDto atomeDto = new AtomeDto(1, 1, 1);		
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons("H", 2, 0).toString());
	}
	
	@Test
	void testObtenirInfosBasiqueCationsCharge1() {
		Atome atome = new Atome(1);
		AtomeDto atomeDto = new AtomeDto(1, 1, 0);		
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons("H+", 2, 1).toString());
	}
	
	@Test
	void testObtenirInfosBasiqueAnionCharge1() {
		Atome atome = new Atome(1);
		AtomeDto atomeDto = new AtomeDto(1, 1, 2);		
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons("H-", 2, -1).toString());
	}
	
	
	@Test
	void testObtenirInfosBasiqueIonChargePlusElevéQue1() {
		Atome atome = new Atome(26);
		AtomeDto atomeDto = new AtomeDto(26, 30, 24);		
		when(atomeRepository.findBySymbole(anyString())).thenReturn(atome);
		assertEquals(atomeDto.toString(), atomeService.obtenirInfosBasiqueAtomeEtIons("Fe2+", 56, 2).toString());
	}
}
