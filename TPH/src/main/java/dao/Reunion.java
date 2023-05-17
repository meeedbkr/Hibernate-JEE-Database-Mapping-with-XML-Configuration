package dao;

import java.util.Date;

public class Reunion {
	private Long idReunion;
	private String titre;
	private Date dateReunion;

	public Reunion() {
	}

	public Reunion(String titre, Date dateReunion) {
		this.titre = titre;
		this.dateReunion = dateReunion;
	}
// Getters et Setters

	public Long getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(Long idReunion) {
		this.idReunion = idReunion;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}

}