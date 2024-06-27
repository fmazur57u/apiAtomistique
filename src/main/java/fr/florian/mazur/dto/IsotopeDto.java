package fr.florian.mazur.dto;

public class IsotopeDto {

	private String phraseSymbole;
	
	private String phraseNeutrons;
	
	private String phraseElectrons;
	
	private String phraseProtons;

	public IsotopeDto() {

	}

	public IsotopeDto(String phraseSymbole, String phraseNeutrons, String phraseElectrons, String phraseProtons) {
		this.phraseSymbole = phraseSymbole;
		this.phraseNeutrons = phraseNeutrons;
		this.phraseElectrons = phraseElectrons;
		this.phraseProtons = phraseProtons;
	}

	public String getPhraseSymbole() {
		return phraseSymbole;
	}

	public void setPhraseSymbole(String phraseSymbole) {
		this.phraseSymbole = phraseSymbole;
	}

	public String getPhraseNeutrons() {
		return phraseNeutrons;
	}

	public void setPhraseNeutrons(String phraseNeutrons) {
		this.phraseNeutrons = phraseNeutrons;
	}

	public String getPhraseElectrons() {
		return phraseElectrons;
	}

	public void setPhraseElectrons(String phraseElectrons) {
		this.phraseElectrons = phraseElectrons;
	}

	public String getPhraseProtons() {
		return phraseProtons;
	}

	public void setPhraseProtons(String phraseProtons) {
		this.phraseProtons = phraseProtons;
	}

	@Override
	public String toString() {
		return "IsotopeDto [phraseSymbole=" + phraseSymbole + ", phraseNeutrons=" + phraseNeutrons
				+ ", phraseElectrons=" + phraseElectrons + ", phraseProtons=" + phraseProtons + "]";
	}
	
	
}
