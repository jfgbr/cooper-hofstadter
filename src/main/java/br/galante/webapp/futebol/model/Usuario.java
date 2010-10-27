package br.galante.webapp.futebol.model;

// Generated 27/10/2010 11:46:42 by Hibernate Tools 3.4.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "futebol")
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private Time time;
	private String nome;
	private String sobrenome;
	private String apelido;
	private String email;
	private String senha;
	private String psn;
	private Date dataNascimento;
	private Set<Participante> participantes = new HashSet<Participante>(0);

	public Usuario() {
	}

	public Usuario(Time time, String nome, String sobrenome, String apelido,
			String email, String senha, Date dataNascimento) {
		this.time = time;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(Time time, String nome, String sobrenome, String apelido,
			String email, String senha, String psn, Date dataNascimento,
			Set<Participante> participantes) {
		this.time = time;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
		this.psn = psn;
		this.dataNascimento = dataNascimento;
		this.participantes = participantes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTimeCoracao", nullable = false)
	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Column(name = "nome", nullable = false, length = 50)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "sobrenome", nullable = false, length = 200)
	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name = "apelido", nullable = false, length = 45)
	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Column(name = "email", nullable = false, length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "senha", nullable = false, length = 10)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "psn", length = 100)
	public String getPsn() {
		return this.psn;
	}

	public void setPsn(String psn) {
		this.psn = psn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataNascimento", nullable = false, length = 19)
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

}
