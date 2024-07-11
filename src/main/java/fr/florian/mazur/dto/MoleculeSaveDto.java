package fr.florian.mazur.dto;

public class MoleculeSaveDto {
	
	private Integer id;
	
	private String formuleBrute;
	
	private String smiles;
	
	private double momentDipolaire;

	public MoleculeSaveDto() {

	}

	public MoleculeSaveDto(String formuleBrute, String smiles, double momentDipolaire) {
		this.formuleBrute = formuleBrute;
		this.smiles = smiles;
		this.momentDipolaire = momentDipolaire;
	}
	
	

	public MoleculeSaveDto(Integer id, String formuleBrute, String smiles, double momentDipolaire) {
		this.id = id;
		this.formuleBrute = formuleBrute;
		this.smiles = smiles;
		this.momentDipolaire = momentDipolaire;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormuleBrute() {
		return formuleBrute;
	}

	public void setFormuleBrute(String formuleBrute) {
		this.formuleBrute = formuleBrute;
	}

	public String getSmiles() {
		return smiles;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}

	public double getMomentDipolaire() {
		return momentDipolaire;
	}

	public void setMomentDipolaire(double momentDipolaire) {
		this.momentDipolaire = momentDipolaire;
	}

	@Override
	public String toString() {
		return "MoleculeSaveDto [id=" + id + ", formuleBrute=" + formuleBrute + ", smiles=" + smiles
				+ ", momentDipolaire=" + momentDipolaire + "]";
	}

	
	
	
}
