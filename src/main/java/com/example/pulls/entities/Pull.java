package com.example.pulls.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
@Entity
public class Pull {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPull;
	@NotNull
	@Size (min = 4,max = 15)
	private String marquePull;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixPull;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateFabrication;
	private String Matiere;

	public Pull() {
		super();
	}
	
	public Pull(String marquePull, Double prixPull, Date dateFabrication, String Matiere) {
		super();
		this.marquePull = marquePull;
		this.prixPull = prixPull;
		this.dateFabrication = dateFabrication;
		this.Matiere = Matiere;
	}
	
	public Long getIdPull() {
		return idPull;
	}
	public void setIdPull(Long idPull) {
		this.idPull = idPull;
	}
	public String getMarquePull() {
		return marquePull;
	}
	public void setMarquePull(String marquePull) {
		this.marquePull = marquePull;
	}
	public Double getPrixPull() {
		return prixPull;
	}
	public void setPrixPull(Double prixPull) {
		this.prixPull = prixPull;
	}
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getDateFabrication() {
		return dateFabrication;
	}
	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	public String getMatiere() {
		return Matiere;
	}
	public void setMatiere(String matiere) {
		Matiere = matiere;
	}
	
	@ManyToOne
	private Categorie categorie;


}