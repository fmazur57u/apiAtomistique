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
	
	@Column(name ="etat_oxydation")
	private String degresOxydation;
	
	@Column(name="masse_atomique")
	private String masseAtomique;
	
	@Column(name="configuration_electronique")
	private String configurationElectronique;
	
	@Column(name="info_periode")
	private String periode;
	
	@Column(name="info_groupe")
	private String groupe;
	
	@Column(name="electronegativite")
	private String electronegativite;
	
	public Atome() {
		
	}

	
	
	public Atome(int z, String symbole, String degresOxydation, String masseAtomique, String configurationElectronique,
			String periode, String groupe, String electronegativite) {
		this.z = z;
		this.symbole = symbole;
		this.degresOxydation = degresOxydation;
		this.masseAtomique = masseAtomique;
		this.configurationElectronique = configurationElectronique;
		this.periode = periode;
		this.groupe = groupe;
		this.electronegativite = electronegativite;
	}



	public Atome(int z, String symbole, String degresOxydation, String masseAtomique, String configurationElectronique,
			String periode, String groupe) {
		this.z = z;
		this.symbole = symbole;
		this.degresOxydation = degresOxydation;
		this.masseAtomique = masseAtomique;
		this.configurationElectronique = configurationElectronique;
		this.periode = periode;
		this.groupe = groupe;
	}



	public Atome(int z, String symbole) {
		this.z = z;
		this.symbole = symbole;
	}

	public Atome(int z, String symbole, String degresOxydation) {
		this.z = z;
		this.symbole = symbole;
		this.degresOxydation = degresOxydation;
	}



	public int getAtomeId() {
		return atomeId;
	}



	public void setAtomeId(int atomeId) {
		this.atomeId = atomeId;
	}



	public int getZ() {
		return z;
	}



	public void setZ(int z) {
		this.z = z;
	}



	public String getSymbole() {
		return symbole;
	}



	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}



	public String getDegresOxydation() {
		return degresOxydation;
	}



	public void setDegresOxydation(String degresOxydation) {
		this.degresOxydation = degresOxydation;
	}



	public String getMasseAtomique() {
		return masseAtomique;
	}



	public void setMasseAtomique(String masseAtomique) {
		this.masseAtomique = masseAtomique;
	}



	public String getConfigurationElectronique() {
		return configurationElectronique;
	}



	public void setConfigurationElectronique(String configurationElectronique) {
		this.configurationElectronique = configurationElectronique;
	}



	public String getPeriode() {
		return periode;
	}



	public void setPeriode(String periode) {
		this.periode = periode;
	}



	public String getGroupe() {
		return groupe;
	}



	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}



	public String getElectronegativite() {
		return electronegativite;
	}



	public void setElectronegativite(String electronegativite) {
		this.electronegativite = electronegativite;
	}



	@Override
	public String toString() {
		return "Atome [atomeId=" + atomeId + ", z=" + z + ", symbole=" + symbole + ", degresOxydation="
				+ degresOxydation + ", masseAtomique=" + masseAtomique + ", configurationElectronique="
				+ configurationElectronique + ", periode=" + periode + ", groupe=" + groupe + ", electronegativite="
				+ electronegativite + "]";
	}

	
	
	
}
