package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.repository.TweetRepository;


@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;

}
