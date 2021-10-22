package br.com.contabancaria.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.contabancaria.model.entities.ContaBancaria;

@Repository
public interface IContaBancariaJpaRepository extends JpaRepository<ContaBancaria, Long>{
	
	
	  @Query(value="SELECT c.numero FROM cadastro.tb_conta_bancaria c where c.agencia = :agencia ORDER BY c.agencia, c.numero DESC limit 1", nativeQuery = true) 
	 Integer buscarUltimoNumeroContaPorAgencia(@Param("agencia") Integer agencia);
	 
	 @Query(value="SELECT count(c)>0 FROM cadastro.tb_conta_bancaria c where c.agencia = :agencia and  c.numero = :numeroConta  GROUP BY c.agencia, c.numero ORDER BY c.numero, c.agencia DESC", nativeQuery = true) 
	 Boolean existeContaPorAgencia(@Param("agencia") Integer agencia, @Param("numeroConta") Integer numeroConta );
	 
	 @Query("SELECT c FROM ContaBancaria c WHERE c.nome LIKE %:nome% AND c.agencia = :agencia AND c.chequeEspecialLiberado = :chequeEspecialLiberado")
	 List<ContaBancaria> pesquisar(@Param("nome") String nome, @Param("agencia") Integer agencia, @Param("chequeEspecialLiberado") boolean chequeEspecialLiberado);
	 

	 @Query("SELECT c FROM ContaBancaria c WHERE c.agencia = :agencia AND c.numero = :numero")
	 ContaBancaria buscarDetalhe( @Param("agencia") Integer agencia, @Param("numero") Integer numero);
	 
	 
	 
	 
}