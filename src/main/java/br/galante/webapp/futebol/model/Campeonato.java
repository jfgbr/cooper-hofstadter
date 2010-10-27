package br.galante.webapp.futebol.model;

// Generated 27/10/2010 11:46:42 by Hibernate Tools 3.4.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Campeonato generated by hbm2java
 */
@Entity
@Table(name = "campeonato", catalog = "futebol")
public class Campeonato implements java.io.Serializable {

	private Integer idCampeonato;
	private String nome;
	private Integer qtdGrupos;
	private Set<Participante> participantes = new HashSet<Participante>(0);

	public Campeonato() {
	}

	public Campeonato(String nome) {
		this.nome = nome;
	}

	public Campeonato(String nome, Integer qtdGrupos,
			Set<Participante> participantes) {
		this.nome = nome;
		this.qtdGrupos = qtdGrupos;
		this.participantes = participantes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCampeonato", unique = true, nullable = false)
	public Integer getIdCampeonato() {
		return this.idCampeonato;
	}

	public void setIdCampeonato(Integer idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	@Column(name = "nome", nullable = false, length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "qtdGrupos")
	public Integer getQtdGrupos() {
		return this.qtdGrupos;
	}

	public void setQtdGrupos(Integer qtdGrupos) {
		this.qtdGrupos = qtdGrupos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "campeonato")
	public Set<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

}