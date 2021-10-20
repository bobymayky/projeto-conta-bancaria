package br.com.contabancaria.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_conta_bancaria", schema = "pagseguro")
public class ContaBancaria {

     @Id
	 @Column(name = "id", nullable = false)
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
     
     
 	@Column(name = "nome")
 	private String nome;
 	
 	
	@Column(name = "numero")
 	private Integer numero;
	
	
	@Column(name = "agencia")
 	private Integer agencia;
	
	@Column(name = "cheque_especial_liberado")
 	private boolean chequeEspecialLiberado;
	
	@Column(name = "saldo")
 	private BigDecimal saldo;
	
	
	@Column(name = "cheque_especial")
 	private BigDecimal chequeEspecial;
	
	
	@Column(name = "taxa")
 	private BigDecimal taxa;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Integer getAgencia() {
		return agencia;
	}


	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}


	public boolean isChequeEspecialLiberado() {
		return chequeEspecialLiberado;
	}


	public void setChequeEspecialLiberado(boolean chequeEspecialLiberado) {
		this.chequeEspecialLiberado = chequeEspecialLiberado;
	}


	public BigDecimal getSaldo() {
		return saldo;
	}


	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	public BigDecimal getChequeEspecial() {
		return chequeEspecial;
	}


	public void setChequeEspecial(BigDecimal chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}


	public BigDecimal getTaxa() {
		return taxa;
	}


	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	
}