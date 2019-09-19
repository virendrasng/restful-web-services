package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exceptions.UserCreationException;
import com.in28minutes.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@Autowired
	private ResourceBundleMessageSource messageSource;

	/**
	 * @RequestMapping(method = RequestMethod.GET, path = "/users") - Its short form
	 *                        is @GetMapping("/users")
	 */
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.getAllUsers();
	}

	/**
	 * retrieveUser(@RequestHeader(name="Accept-Language", required = false) Locale
	 * locale) { Easier way to pass locale is LocaleContextHolder.getLocale() as
	 * done in the below demo.
	 */
	@GetMapping(produces = "application/json", path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) {
		final User user = service.findOne(id);
		// Demo of i18n also
		final String i18nLink = messageSource.getMessage("demo.message.all.users.link", null,
				LocaleContextHolder.getLocale());
		if (user == null) {
			throw new UserNotFoundException("id - " + id + " does not exist");
		}

		// HATEOAS Demo
		final Resource<User> resource = new Resource<User>(user);
		final ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel(i18nLink));

		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody final User user) throws UserCreationException {
		ResponseEntity<Object> respEnt = null;
		final Integer id = user.getId();
		if (id == null) {
			final User createdUser = service.save(user);
			// In Postman this URL will be displayed in header tab of POSTMAN
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(createdUser.getId()).toUri();
			respEnt = ResponseEntity.created(location).build();
		} else {
			throw new UserCreationException("Please don't provide id while creating user");
		}

		return respEnt;
	}

	/**
	 * If method don't return anything, it means status 200.
	 * 
	 * @param id
	 */
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable final Integer id) {
		final boolean result = service.deleteUser(id);

		if (!result) {
			throw new UserNotFoundException("User could not be deleted, either user with id - " + id
					+ " not found or some other error occured");
		}
	}

	@GetMapping(produces = "application/json", path = "/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable Integer id) {
		final User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id + " does not exist");
		}

		return user.getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPosts(@PathVariable final Integer id, @RequestBody final Post post) throws UserCreationException {
		ResponseEntity<Object> respEnt = null;
		
		Post updatedPost = service.updatePost(id, post);
		// The below location will be displayed in the header section in postman
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedPost.getId()).toUri();
		respEnt = ResponseEntity.created(location).build();

		return respEnt;
	}
}
