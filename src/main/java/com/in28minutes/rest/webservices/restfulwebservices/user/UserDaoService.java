package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	/*private static List<User> users = new ArrayList<User>();
	private static int usersCount = 3; 
	
	static {
		users.add(new User(1, "Adam", new Date(), "1. Not to display this field. Add @JsonIgnore on it in User bean"));
		users.add(new User(2, "Eve", new Date(), "2. Not to display this field. Add @JsonIgnore on it in User bean"));
		users.add(new User(3, "Jack", new Date(), "3. Not to display this field. Add @JsonIgnore on it in User bean"));
	}*/
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User save(final User user) {
		return userRepository.save(user);
	}
	
	public User findOne(final int id) {
		final Optional<User> user = userRepository.findById(id);
		User userToRet = null;
		if(user.isPresent()) {
			userToRet = user.get();
		}
		
		return userToRet;
	}
	
	public boolean deleteUser(final int id) {
		boolean toRet = false;
		final Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
			toRet = true;
		}
		
		return toRet;
	}

	public Post updatePost(final Integer id, final Post post) {
		final User user = findOne(id);
		post.setUser(user); // This is to set user id in POST table
		return postRepository.save(post);	
	}


}
