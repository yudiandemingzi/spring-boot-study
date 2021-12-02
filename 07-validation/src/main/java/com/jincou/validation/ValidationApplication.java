package com.jincou.validation;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@EnableOpenApi
@SpringBootApplication
public class ValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationApplication.class, args);
	}


	@Bean
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
				.configure()
				// 快速失败模式
				.failFast(false)
				.buildValidatorFactory();
		return validatorFactory.getValidator();
	}


}
