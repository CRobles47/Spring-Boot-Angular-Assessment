package cogent.infotech.user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.user.entity.User;
import cogent.infotech.user.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "false")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userRepo.findAll();
	}
	
	@PostMapping("/users")
	public User createUser(@Validated @RequestBody User user) {
		return this.userRepo.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value="id") Integer id){
		Optional<User> u = this.userRepo.findById(id);
		return u.get();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		this.userRepo.deleteById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user) {
		return this.userRepo.save(user);
	}
	
}
