package com.lalumen.backend;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.*;
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
import com.lalumen.backend.service.AccountService;
import com.lalumen.backend.service.CategoryService;
import com.lalumen.backend.service.WorkService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    private final AccountService accountService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    BackendApplication(AccountService accountService) {
        this.accountService = accountService;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String ... args) {

		accountService.tempRegisterAccount("Benedict", "Benedict123");
		accountService.tempRegisterAccount("Cactus", "Cactus123");
		accountService.tempRegisterAccount("Shrimp", "Shrimp123");

		workRepo.save(new Work(LocalDate.of(2025,07,28), LocalTime.of(12,32,27), Duration.ofHours(8).plusMinutes(16), "Added frontend services, and backend account verification", "I fix the representation error regarding the DTO's. [Frontend] I added the API end point services on separate TS files and have created drafts on how they operate-- I added all interfaces that correspond to the entities/DTO. [Backend] I mainly added account verification by adding a new endpoint, I also properly incorporated the hashing of raw passwords, and also checking if they match their hash counterparts. Basically I have the basic structure of the login.", 4.5f, LocalDate.of(2025,07,28), false, LocalDate.of(2025,07,28)));
		workService.setAccount(1, 2);

		workRepo.save(new Work(LocalDate.of(2023,01,12), LocalTime.of(13,56,4), Duration.ofHours(4).plusMinutes(4), "Defining the sequence diagram", "I just added the component files (tsx). Today I mainly did the sequence diagram of the project, I did it for the sake of defining the operations properly instead of mentally visualizing it, The sequence diagram is however not finished yet, as it has yet to incorporate JWT in the logic flow. I'm in the process of building and incorporating useContext to the components from fetched data.", 9.5f, LocalDate.of(2025,12,28), false, LocalDate.of(2025,1,28)));
		workService.setAccount(2, 2);

		workRepo.save(new Work(LocalDate.of(2025,07,28), LocalTime.of(23,00,27), Duration.ofHours(28).plusMinutes(16), "Title 2 Acc 1", "Sample Description 2", 4.6f, LocalDate.of(2025,07,28), true, LocalDate.of(2025,07,28)));
		workService.setAccount(3, 3);

		workRepo.save(new Work(LocalDate.of(2018,01,12), LocalTime.of(1,00,2), Duration.ofHours(6).plusMinutes(4), "Sample Bomboclaat", "asdasdas Description", 6.7f, LocalDate.of(2023,12,28), false, LocalDate.of(2025,1,28)));
		workService.setAccount(4, 3);

		workRepo.save(new Work(LocalDate.of(2022,01,15), LocalTime.of(2,44,1), Duration.ofHours(1).plusMinutes(44), "Finally incorporating contexts to my components", "Though I started somewhat late, I think I had a pretty decent session, although I did find myself wanting to get distracted here and there; opening tiktok or any social media platform. Also today I was hella confused with using contexts along with the useState hook and then other stupid interface usages. I hated the complexity, but I'll be honest I actually am loving typescript, it just feels so defined-- makes me feel like using java with the interfaces and stuff-- I am rediscovering my love for React as I progress", 1.5f, LocalDate.of(2025,12,28), true, LocalDate.of(2025,1,28)));
		workService.setAccount(5, 2);

		catRepo.save(new Category("Science", "Red"));
		catRepo.save(new Category("Math", "Blue"));
		catRepo.save(new Category("DSA", "Green"));
		catRepo.save(new Category("DAA", "Pink"));

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


		// logger.info("Benedict (u): "  + accountService.isUsernameCorrect("Benedicts"));
		
	}
}
