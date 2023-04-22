package cogent.infotech.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
