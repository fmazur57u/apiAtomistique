package fr.florian.mazur.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "atome")
public class Atome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int atomeId;
	
	@Column(name = "numero")
	private int z;
	
	@Column(name = "symbole")
	private String symbole;
	
	public Atome() {
		
	}

	public Atome(int z) {
		super();
		this.z = z;
	}

	public Atome(int z, String symbole) {
		this.z = z;
		this.symbole = symbole;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public int getZ() {
		return z;
	}
	

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Atome [atomeId=" + atomeId + ", z=" + z + ", symbole=" + symbole + "]";
	}

	
}
