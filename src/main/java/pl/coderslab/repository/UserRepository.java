package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();

	void deleteById(long id);

	User save(User entity);

	User findOne(long id);

	User findByUsername(String username);
}
