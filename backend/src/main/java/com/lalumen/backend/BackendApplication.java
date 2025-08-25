package com.lalumen.backend;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lalumen.backend.entity.Account;
import com.lalumen.backend.entity.Category;
import com.lalumen.backend.entity.Work;
import com.lalumen.backend.repository.AccountRepository;
import com.lalumen.backend.repository.CategoryRepository;
import com.lalumen.backend.repository.WorkRepository;
import com.lalumen.backend.service.CategoryService;
import com.lalumen.backend.service.WorkService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	AccountRepository accRepo;

	@Autowired
	WorkRepository workRepo;

	@Autowired
	WorkService workService;

	@Autowired
	CategoryRepository catRepo;

	@Autowired
	CategoryService catService;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String ... args) {
		accRepo.save(new Account("Benedict", "JAmboliath"));
		accRepo.save(new Account("Cactus", "Bomboclaat"));
		accRepo.save(new Account("Shrimp", "HelloKalibutan"));

		workRepo.save(new Work(new Date(2025,07,28), new Time(8,16,27), "Sample Title", "Sample Description", 4.5f, new Date(2025,07,28), false, new Date(2025,07,28)));
		workService.setAccount(1, 2);

		workRepo.save(new Work(new Date(2023,01,12), new Time(4,4,4), "Sample SADASD", "asdasdas Description", 9.5f, new Date(2025,12,28), false, new Date(2025,1,28)));
		workService.setAccount(2, 2);

		catRepo.save(new Category("Science"));
		catRepo.save(new Category("Math"));
		catRepo.save(new Category("DSA"));
		catRepo.save(new Category("DAA"));

		catService.addAccount(1, 1);
		catService.addAccount(2, 2);
		catService.addAccount(3, 1);
		catService.addAccount(4, 2);

		workService.addWorkCategory(1, 1);
		workService.addWorkCategory(1, 2);
		workService.addWorkCategory(1, 3);
		workService.addWorkCategory(1, 4);

		workService.addWorkCategory(2, 3);
		workService.addWorkCategory(2, 4);
	}
}
