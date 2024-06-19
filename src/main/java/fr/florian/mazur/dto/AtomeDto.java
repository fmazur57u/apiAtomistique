package fr.florian.mazur.dto;


public class AtomeDto {
	
	private int proton;
	
	private int neutrons;
	
	private int electron;

	public AtomeDto(int proton, int neutrons, int electron) {
		this.proton = proton;
		this.neutrons = neutrons;
		this.electron = electron;
	}

	public int getProton() {
		return proton;
	}

	public void setProton(int proton) {
		this.proton = proton;
	}

	public int getNeutrons() {
		return neutrons;
	}

	public void setNeutrons(int neutrons) {
		this.neutrons = neutrons;
	}

	public int getElectron() {
		return electron;
	}

	public void setElectron(int electron) {
		this.electron = electron;
	}

	@Override
	public String toString() {
		return "AtomeDto [proton=" + proton + ", neutrons=" + neutrons + ", electron=" + electron + "]";
	}
	
	
	
}
