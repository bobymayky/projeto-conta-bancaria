package br.com.contabancaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabancaria.model.entities.ContaBancaria;

@Repository
public interface IContaBancariaJpaRepository extends JpaRepository<ContaBancaria, Long>{
	

}