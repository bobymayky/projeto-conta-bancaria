package br.com.contabancaria.model.repositories;

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
}