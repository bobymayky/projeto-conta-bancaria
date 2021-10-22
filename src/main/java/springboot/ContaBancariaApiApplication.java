package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "springboot.*", "br.com.contabancaria.*", "br.*" })
@EntityScan(basePackages = { "br.com.contabancaria.*" })
@EnableJpaRepositories("br.com.contabancaria.model.repositories")
@EnableCaching
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContaBancariaApiApplication  {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ContaBancariaApiApplication.class, args);
	}

}