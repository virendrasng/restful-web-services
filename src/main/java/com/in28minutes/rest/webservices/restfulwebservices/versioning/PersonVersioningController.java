package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	/**
	 * Basic way of versioning using URI. This is called URI versioning
	 * 
	 * @return
	 */
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Virendra Singh");
	}

	/**
	 * Basic way of versioning using URI. This is called URI versioning
	 * 
	 * @return
	 */
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Virendra", "Singh"));
	}

	/**
	 * Versioning using Request parameter (Request parameter versioning). Call it as
	 * - http://localhost:8080/person/param?version=1
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Virendra Singh1");
	}

	/**
	 * Versioning using Request parameter (Request parameter versioning). Call it as
	 * - http://localhost:8080/person/param?version=2
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Virendra", "Singh2"));
	}

	/**
	 * Header versioning - Header parameter is used in the request header. Call it
	 * as - http://localhost:8080/person/header <BR/>
	 * From POSTMAN pass header(X-API-VERSION) value. <br/>
	 * Note that header name can be anything
	 * In this type of versioning caching is dificult
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Virendra Singh3");
	}

	/**
	 * Header versioning - Header parameter is used in the request header. <BR/>
	 * From POSTMAN pass header(X-API-VERSION) value. <BR/>
	 * Note that header name can be anything
	 * In this type of versioning caching is dificult
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Virendra", "Singh4"));
	}

	/**
	 * Versioning by using PRODUCES. This is also called Accept header versioning or
	 * Mime type versioning because application/json is mimetype. (a.k.a "Content
	 * negotiation" or "accept header") <BR/>
	 * Call it as - http://localhost:8080/person/produces and set header ACCEPT
	 * =application/vnd.company.app-v1+json <BR/>
	 * xml can also be mentioned inplace of json to get xml format
	 * In this type of versioning caching is dificult
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Virendra Singh5");
	}

	/**
	 * Versioning by using PRODUCES. This is also called Accept header versioning or
	 * Mime type versioning because application/json is mimetype. (a.k.a "Content
	 * negotiation" or "accept header") <BR/>
	 * Call it as - http://localhost:8080/person/produces and set header ACCEPT
	 * =application/vnd.company.app-v2+json <BR/>
	 * xml can also be mentioned inplace of json to get xml format
	 * In this type of versioning caching is dificult
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Virendra", "Singh6"));
	}
}
