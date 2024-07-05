package fr.florian.mazur.dto;

public class MoleculeDto {
	
	private String formuleBrute;
	
	private String smiles;

	public MoleculeDto() {

	}

	public MoleculeDto(String formuleBrute, String smiles) {
		this.formuleBrute = formuleBrute;
		this.smiles = smiles;
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

	@Override
	public String toString() {
		return "MoleculeDto [formuleBrute=" + formuleBrute + ", smiles=" + smiles + "]";
	}

	
	
	

}
