package fr.florian.mazur.dto;

public class MasseAtomiqueDto {

	private String masseAtomique;

	public MasseAtomiqueDto() {

	}

	public MasseAtomiqueDto(String masseAtomique) {
		this.masseAtomique = masseAtomique;
	}

	public String getMasseAtomique() {
		return masseAtomique;
	}

	public void setMasseAtomique(String masseAtomique) {
		this.masseAtomique = masseAtomique;
	}

	@Override
	public String toString() {
		return "MasseAtomiqueDto [masseAtomique=" + masseAtomique + "]";
	}
	
	
}
