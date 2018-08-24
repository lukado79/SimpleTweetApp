package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.entity.Comments;

@Transactional
public interface CommentsRepository extends JpaRepository<Comments, Long> {
	
	Comments save(Comments entity);
	
	void deleteById(long id);
	
	List<Comments> findAllOrderByCreatedDesc();

}
