package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.entity.Tweet;
@Repository
@Transactional
public interface TweetRepository extends JpaRepository<Tweet, Long> {
	
	List<Tweet> findAllByUserId(long id);
	
	@Query("SELECT a FROM Tweet a WHERE a.title LIKE :title% ORDER BY a.created DESC")
	List<Tweet> findAllWhereTweetLikeOrderByCreated(@Param("title") String title);
	
	Tweet save(Tweet entity);
	
	List<Tweet> findAll();
	
	void deleteById(long id);
	
	List<Tweet> findAllById(long id);
	
	Tweet findById(long id);
}
