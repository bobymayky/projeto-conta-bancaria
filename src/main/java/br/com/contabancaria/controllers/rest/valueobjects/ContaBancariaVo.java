package br.com.contabancaria.controllers.rest.valueobjects;

import java.math.BigDecimal;

public class ContaBancariaVo {
	
	
	
	 private Integer id;
	 private String nome;
	 private Integer numero;
	 private Integer agencia;
	 private boolean chequeEspecialLiberado;
	 private BigDecimal saldo;
	 private BigDecimal chequeEspecial;
	 
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
