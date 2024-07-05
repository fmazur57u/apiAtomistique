package fr.florian.mazur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.florian.mazur.entity.Molecule;

public interface MoleculeRepository extends JpaRepository<Molecule, Integer> {

}
