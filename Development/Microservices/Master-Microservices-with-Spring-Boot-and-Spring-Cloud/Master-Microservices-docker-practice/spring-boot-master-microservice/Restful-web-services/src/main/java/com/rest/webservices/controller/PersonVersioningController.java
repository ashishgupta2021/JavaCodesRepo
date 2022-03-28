package com.rest.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.model.Name;
import com.rest.webservices.model.PersonV1;
import com.rest.webservices.model.PersonV2;

@RestController
public class PersonVersioningController {

	/* URI Versioning */

	// http://localhost:8080/v1/person
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Ashish Kumar");
	}

	// http://localhost:8080/v2/person
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Ashish", "Kumar"));
	}
	
	/* Request Parameter Versioning */


	// http://localhost:8080/person/param?version=1
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Ashish Kumar");
	}

	// http://localhost:8080/person/param?version=2
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Ashish", "Kumar"));
	}

	/* Header Versioning */

	
	// http://localhost:8080/person/header and pass header as key to X-API-VERSION and value to 1 in
	// postman
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Ashish Kumar");
	}

	// http://localhost:8080/person/header and pass header as key to X-API-VERSION and value to 2 in
	// postman
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Ashish", "Kumar"));
	}

	/* Accept Header Versioning */
	
	// http://localhost:8080/person/produces and pass in header as key to 'Accept' and value to 'application/vnd.company.app-v1+json' in
	// postman
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Ashish Kumar");
	}

	// http://localhost:8080/person/produces and pass in header as key to 'Accept' and value to 'application/vnd.company.app-v2+json' in
	// postman
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Ashish", "Kumar"));
	}
}
