package br.com.contabancaria.controllers.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import br.com.contabancaria.controllers.rest.valueobjects.ContaBancariaVo;
import br.com.contabancaria.controllers.rest.valueobjects.DetalheContaBancariaVo;
import br.com.contabancaria.converter.DozerConverter;
import br.com.contabancaria.exception.MensagemAvisoUsuarioException;
import br.com.contabancaria.exception.ResourceNotFoundException;
import br.com.contabancaria.model.entities.ContaBancaria;
import br.com.contabancaria.model.repositories.IContaBancariaJpaRepository;



@Service
public class ContaBancariaService {
	
	@Autowired
	IContaBancariaJpaRepository contaBancariaJpaRepository;
	
	public ContaBancariaVo create(ContaBancariaVo contaBancariaVo){
		ContaBancaria contaBancaria = DozerConverter.parseObject(contaBancariaVo, ContaBancaria.class);
		contaBancaria.setNumero(gerarNumeroConta(contaBancariaVo.getAgencia()));
		contaBancariaVo = DozerConverter.parseObject(  contaBancariaJpaRepository.save(contaBancaria), ContaBancariaVo.class);
		return contaBancariaVo;
		
	}
	
	public void delete(Long id) {
		ContaBancaria contaBancaria = contaBancariaJpaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe conta bancária cadastrada, para ser removida"));
		contaBancariaJpaRepository.delete(contaBancaria);
	}
	
	
	public ContaBancariaVo update(ContaBancariaVo contaBancariaVo) {
		ContaBancaria contaBancaria = contaBancariaJpaRepository.findById(contaBancariaVo.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não existe conta bancária cadastrada, para ser alterada"));
		 
		 contaBancaria.setNome(contaBancariaVo.getNome());
		 contaBancaria.setChequeEspecialLiberado(contaBancariaVo.isChequeEspecialLiberado());
		 contaBancaria.setSaldo(contaBancariaVo.getSaldo());
		 contaBancaria.setChequeEspecial(contaBancariaVo.getChequeEspecial());
		 contaBancaria.setTaxa(contaBancariaVo.getTaxa());
		 contaBancariaVo = DozerConverter.parseObject(contaBancariaJpaRepository.save(contaBancaria), ContaBancariaVo.class);
		 return contaBancariaVo;
	}
	
	
	
	protected  Integer gerarNumeroConta(Integer agencia) {
		if(agencia != null) {
			Integer numeroConta = contaBancariaJpaRepository.buscarUltimoNumeroContaPorAgencia(agencia);
			numeroConta = numeroConta +1;
			Boolean existeNumeroContaAgencia = contaBancariaJpaRepository.existeContaPorAgencia(agencia, numeroConta);
			if(existeNumeroContaAgencia != null && existeNumeroContaAgencia) {
				gerarNumeroConta(agencia);
			}
			return numeroConta;
		} else {
			throw new MensagemAvisoUsuarioException("Por favor informe o numero da sua agência");
		}
		
	}
	
	
	public List<ContaBancariaVo> pesquisar( String nome, Integer agencia, boolean chequeEspecialLiberado ) {
		List<ContaBancariaVo> retorno = new ArrayList<ContaBancariaVo>();
		List<ContaBancaria> registros = contaBancariaJpaRepository.pesquisar(nome, agencia, chequeEspecialLiberado);
	    if(registros != null ) {
	    	for(ContaBancaria registro : registros) {
	    		retorno.add(convertContaBancariaVo(registro));
	    	}
	    }
		return retorno;
	}
	
	
	public DetalheContaBancariaVo buscarDetalhe( Integer agencia, Integer numero) {
		DetalheContaBancariaVo retorno = new DetalheContaBancariaVo();
		ContaBancaria registro = contaBancariaJpaRepository.buscarDetalhe(agencia, numero);
	    if(registro != null ) {
	    	retorno = new DetalheContaBancariaVo(registro.getNome(), registro.getAgencia(), registro.getNumero(), registro.getSaldo(), registro.isChequeEspecialLiberado(), registro.getChequeEspecial(), registro.getTaxa());
	    }
		return retorno;
	}
	
	
	private ContaBancariaVo convertContaBancariaVo(ContaBancaria entity) {
		return DozerConverter.parseObject(entity, ContaBancariaVo.class);
	}


}
