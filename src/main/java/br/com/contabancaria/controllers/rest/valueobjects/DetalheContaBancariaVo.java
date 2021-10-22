package br.com.contabancaria.controllers.rest.valueobjects;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetalheContaBancariaVo {
	
	 private String nome;
	 private String conta;
	 private String saldo;
	 private String chequeEspecialLiberado;
	 private String valorChequeEspecial;
	 
	 
	 public DetalheContaBancariaVo(){
		 
	 }
	 
	 public DetalheContaBancariaVo(String nome, Integer agencia, Integer numero, BigDecimal saldo, boolean chequeEspecial, BigDecimal valorChequeEspecial, BigDecimal taxa ) {
		 this.nome = nome;
		 this.conta = contaAgencia(agencia, numero);
		 this.saldo = saldoReal(saldo);
		 this.chequeEspecialLiberado  = ((chequeEspecial) ?  "Liberado" :  "Não liberado" ); 
		 this.valorChequeEspecial = valorChequeEspecialDiaSequente(valorChequeEspecial, taxa);
		 
	 }
	 


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getChequeEspecialLiberado() {
		return chequeEspecialLiberado;
	}

	public void setChequeEspecialLiberado(String chequeEspecialLiberado) {
		this.chequeEspecialLiberado = chequeEspecialLiberado;
	}

	public String getValorChequeEspecial() {
		return valorChequeEspecial;
	}

	public void setValorChequeEspecial(String valorChequeEspecial) {
		this.valorChequeEspecial = valorChequeEspecial;
	}
	
	
	 public String contaAgencia(Integer agencia, Integer numero ) {
		 String retorno = agencia.toString();
		 String numeroFormatado = "";
		 Pattern pattern = Pattern.compile("(\\d{5})(\\d{1})");
		 Matcher matcher = pattern.matcher(numero.toString());
		 if(matcher.find()){
			 numeroFormatado = matcher.replaceAll("$1-$2");
		 } else {
			 numeroFormatado = numero.toString();
		 }
		 retorno = retorno +" / " + numeroFormatado;
		 return retorno;
	 }
	 
	 public String saldoReal(BigDecimal saldo ) {
		 if(saldo == null) {
			 saldo = BigDecimal.valueOf(0.0);
		 }
		 Locale meuLocal = new Locale( "pt", "BR" );
		 NumberFormat nf = NumberFormat.getCurrencyInstance(meuLocal); 
		 String saldoFormatado = nf.format (saldo);
		 return saldoFormatado;
	 }
	 
	 
	 public String valorChequeEspecialDiaSequente(BigDecimal valorChequeEspecial, BigDecimal taxa ) {
		 valorChequeEspecial = ((valorChequeEspecial != null) ?  valorChequeEspecial : BigDecimal.valueOf(0.0));
		 taxa = ((taxa != null) ?  taxa : BigDecimal.valueOf(0.0));
		 
		 if(taxa.intValue() > 0 ) {
			 BigDecimal valorAcrecimo = BigDecimal.valueOf(0.0);
			 valorAcrecimo = valorChequeEspecial.multiply(taxa).divide(BigDecimal.valueOf(100.00));
			 valorChequeEspecial =  valorChequeEspecial.add(valorAcrecimo);
		 }
		 
		 Locale meuLocal = new Locale( "pt", "BR" );
		 NumberFormat nf = NumberFormat.getCurrencyInstance(meuLocal); 
		 String chequeEspecialFormatado = nf.format (valorChequeEspecial);
		 return chequeEspecialFormatado;
	 }
}
