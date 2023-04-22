package cogent.infotech.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cogent.infotech.user.entity.User;
import cogent.infotech.user.repository.UserRepository;

@SpringBootApplication
public class UserBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserBackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		this.userRepo.save(new User("Frank", 25, 80000));
		this.userRepo.save(new User("Diane", 21, 60000));
		this.userRepo.save(new User("Bill", 30, 90000));
	}
}