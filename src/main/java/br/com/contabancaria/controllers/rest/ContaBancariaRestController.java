package br.com.contabancaria.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.contabancaria.controllers.rest.valueobjects.ContaBancariaVo;
import br.com.contabancaria.controllers.rest.valueobjects.DetalheContaBancariaVo;
import br.com.contabancaria.controllers.services.ContaBancariaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ContaBancariaRestController", description = "REST API  Conta Bancária", tags = { "ContaBancariaRestController" })
@RestController
@RequestMapping("/api/contabancaria")
public class ContaBancariaRestController {

	@Autowired
	private ContaBancariaService contaBancariaService;

	public ContaBancariaService getContaBancariaService() {
		return contaBancariaService;
	}

	@ApiOperation("Registrar Conta Bancária.")
	@RequestMapping(method = RequestMethod.POST)
	public ContaBancariaVo create(@RequestBody ContaBancariaVo contaBancariaVo){
		ContaBancariaVo contaBancariaRetorno = getContaBancariaService().create(contaBancariaVo);
		return contaBancariaRetorno;
	}
	
    @ApiOperation(value = "Atualizar Conta Bancária")
    @RequestMapping(method = RequestMethod.PUT)
    public ContaBancariaVo update(@RequestBody ContaBancariaVo contaBancariaVo){
    	ContaBancariaVo contaBancariaRetorno = getContaBancariaService().update(contaBancariaVo);
		return contaBancariaRetorno;
    }

    @ApiOperation(value = "Remover Conta Bancária por Id")
    @RequestMapping(value = "/{id}",  method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
    	getContaBancariaService().delete(id);
        return ResponseEntity.ok().build();
    }
    
    
    @ApiOperation(value = "Pesquisar contas bancárias" ) 
    @RequestMapping(value = "/pesquisar", method = RequestMethod.GET)
    public @ResponseBody List<ContaBancariaVo> pesquisar(
    		@RequestParam(value = "nome") String nome,
            @RequestParam(value = "agencia", defaultValue = "0000") int agencia,
            @RequestParam(value = "chequeEspecialLiberado", defaultValue = "false") boolean chequeEspecialLiberado){
    	return getContaBancariaService().pesquisar(nome, agencia, chequeEspecialLiberado);
    }
    
    
    @ApiOperation(value = "Detalhe Conta Bancária" ) 
    @RequestMapping(value = "/detalhe", method = RequestMethod.GET)
    public @ResponseBody DetalheContaBancariaVo buscarDetalhe(
    	    @RequestParam(value = "agencia", defaultValue = "0000") int agencia,
    		@RequestParam(value = "numero" , defaultValue = "000000") int numero
        ) {
    	return getContaBancariaService().buscarDetalhe(agencia, numero);
    }
        
    
}
