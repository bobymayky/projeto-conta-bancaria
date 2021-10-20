package br.com.contabancaria.controllers.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.contabancaria.controllers.rest.valueobjects.ContaBancariaVo;
import springboot.ContaBancariaApiApplication;


@SpringBootTest(classes = ContaBancariaApiApplication.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ContaBancariaServiceTest {
	
	@Autowired
	private ContaBancariaService contaBancariaService;
	
	public ContaBancariaService getContaBancariaService() {
		return contaBancariaService;
	}
	
	@Test
	public void incluirContaBancaria(){
		ContaBancariaVo contaBancariaVo = new ContaBancariaVo();
		contaBancariaVo.setNome("Boby Mayky Ribeiro da Costa");
		contaBancariaVo.setNumero(55533);
		contaBancariaVo.setAgencia(2233);
		contaBancariaVo.setChequeEspecialLiberado(false);
		contaBancariaVo.setSaldo(BigDecimal.valueOf(22.00));
		contaBancariaVo.setChequeEspecial(BigDecimal.valueOf(100.00));
		contaBancariaVo.setTaxa(BigDecimal.valueOf(22.99));
		getContaBancariaService().incluirContaBancaria(contaBancariaVo);
	}

}
