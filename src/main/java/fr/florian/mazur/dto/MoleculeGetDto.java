package fr.florian.mazur.dto;

public class MoleculeGetDto {
	
	private String formuleBrute;
	
	private double masseMolaire;
	
	private double momentDipolaire;

		
	public MoleculeGetDto() {

	}
	
	public MoleculeGetDto(String formuleBrute, double masseMolaire, double momentDipolaire) {
		this.formuleBrute = formuleBrute;
		this.masseMolaire = masseMolaire;
		this.momentDipolaire = momentDipolaire;
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

	public double getMomentDipolaire() {
		return momentDipolaire;
	}

	public void setMomentDipolaire(double momentDipolaire) {
		this.momentDipolaire = momentDipolaire;
	}

	@Override
	public String toString() {
		return "MoleculeGetDto [formuleBrute=" + formuleBrute + ", masseMolaire=" + masseMolaire + ", momentDipolaire="
				+ momentDipolaire + "]";
	}
	
	

}
