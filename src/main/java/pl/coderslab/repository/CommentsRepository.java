package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.entity.Comments;
@Repository
@Transactional
public interface CommentsRepository extends JpaRepository<Comments, Long> {

	Comments save(Comments entity);

	void deleteById(long id);

	@Query("SELECT a FROM Comments a ORDER BY a.created DESC")
	List<Comments> findOrderByCreated();
	
	Comments findById(long id);
	

}
