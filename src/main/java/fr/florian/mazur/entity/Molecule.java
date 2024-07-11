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
	private Double masseMolaire;
	
	@Column(name = "MOMENT_DIPOLAIRE")
	private Double momentDipolaire;
	
	public Molecule() {

	}

	public Molecule(String formuleBrute, Double masseMolaire, Double momentDipolaire) {
		this.formuleBrute = formuleBrute;
		this.masseMolaire = masseMolaire;
		this.momentDipolaire = momentDipolaire;
	}

	public Double getMomentDipolaire() {
		return momentDipolaire;
	}

	public void setMomentDipolaire(Double momentDipolaire) {
		this.momentDipolaire = momentDipolaire;
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

	public Double getMasseMolaire() {
		return masseMolaire;
	}

	public void setMasseMolaire(Double masseMolaire) {
		this.masseMolaire = masseMolaire;
	}

	@Override
	public String toString() {
		return "Molecule [idMolecule=" + idMolecule + ", formuleBrute=" + formuleBrute + ", masseMolaire="
				+ masseMolaire + ", momentDipolaire=" + momentDipolaire + "]";
	}
	
}
