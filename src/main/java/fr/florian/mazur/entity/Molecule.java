package fr.florian.mazur.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "molecules")
public class Molecule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idMolecule;
	
	@Column(name = "FORMULE_BRUTE")
	private String formuleBrute;
	
	@Column(name = "MASSE_MOLAIRE")
	private double masseMolaire;
	
	public Molecule() {

	}

	public Molecule(String formuleBrute, double masseMolaire) {
		this.formuleBrute = formuleBrute;
		this.masseMolaire = masseMolaire;
	}

	public int getIdMolecule() {
		return idMolecule;
	}

	public void setIdMolecule(int idMolecule) {
		this.idMolecule = idMolecule;
	}

	public String getFormuleBrute() {
		return formuleBrute;
	}

	public void setFormuleBrute(String formuleBrute) {
		this.formuleBrute = formuleBrute;
	}

	public double getMasseMolaire() {
		return masseMolaire;
	}

	public void setMasseMolaire(double masseMolaire) {
		this.masseMolaire = masseMolaire;
	}

	@Override
	public String toString() {
		return "Molecules [idMolecule=" + idMolecule + ", formuleBrute=" + formuleBrute + ", masseMolaire="
				+ masseMolaire + "]";
	}
	
	
}
