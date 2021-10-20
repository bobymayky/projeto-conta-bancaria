package br.com.contabancaria.controllers.services;


import javax.persistence.PersistenceException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contabancaria.controllers.rest.valueobjects.ContaBancariaVo;
import br.com.contabancaria.model.entities.ContaBancaria;
import br.com.contabancaria.model.repositories.IContaBancariaJpaRepository;


@Service
public class ContaBancariaService {
	
	@Autowired
	IContaBancariaJpaRepository contaBancariaJpaRepository;
	

	
	public void incluirContaBancaria(ContaBancariaVo contaBancariaVo){
		try {
		    ContaBancaria contaBancaria = new ContaBancaria();
		    contaBancaria.setNome(contaBancariaVo.getNome());
		    contaBancaria.setNumero(contaBancariaVo.getNumero());
		    contaBancaria.setAgencia(contaBancariaVo.getAgencia());
		    contaBancaria.setChequeEspecialLiberado(contaBancariaVo.isChequeEspecialLiberado());
		    contaBancaria.setSaldo(contaBancariaVo.getSaldo());
		    contaBancaria.setChequeEspecial(contaBancariaVo.getChequeEspecial());
		    contaBancaria.setTaxa(contaBancariaVo.getTaxa());
		    contaBancariaJpaRepository.save(contaBancaria);
		} catch (PersistenceException e) {
			throw new ServiceException("Ocorreu um erro e não foi possivel cria sua conta.");
		}
	}

}
