package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All description of the user")
//@JsonIgnoreProperties(value= {"birthDate", "id"}) - This also works
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Min 2 characters")
	@ApiModelProperty(notes = "Atleast 2 characters in the name")
	private String name;

	@Past(message = "Date of birth must be in past")
	@ApiModelProperty(notes = "Birth date must be in the past")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	/**
	 * @JsonIgnore - will not allow to display this field on UI. This works even if
	 *             response is in the form of XML.
	 */
	@JsonIgnore
	private String notToDisplay;

	public User() {
	}

	public User(Integer id, String name, Date birthDate, String notToDisplay) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.notToDisplay = notToDisplay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNotToDisplay() {
		return notToDisplay;
	}

	public void setNotToDisplay(String notToDisplay) {
		this.notToDisplay = notToDisplay;
	}

	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", notToDisplay=" + notToDisplay
				+ "]";
	}

}
