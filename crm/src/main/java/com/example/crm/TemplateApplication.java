package com.example.crm;

import com.example.crm.service.TemplateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {
	@Resource
	TemplateService templateService;

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}
	@Override
	public void run(String...arg) throws Exception {
		templateService.init();
	}
}
