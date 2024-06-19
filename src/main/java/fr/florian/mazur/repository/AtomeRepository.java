package fr.florian.mazur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.florian.mazur.entity.Atome;

public interface AtomeRepository extends JpaRepository<Atome, Integer> {

	public Atome findBySymbole(String symbole);
}
