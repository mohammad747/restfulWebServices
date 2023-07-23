package com.hashemi.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Mohammad Hashemi");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Mohammad", "Hashemi"));
    }

    @GetMapping(value = "/person", params = {"version=1"})
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Mohammad Hashemi");
    }

    @GetMapping(value = "/person", params = {"version=2"})
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Mohammad", "Hashemi"));
    }

    @GetMapping(value = "/person/header", headers = {"X-API-VERSION=1"})
    public PersonV1 getFirstVersionOfPersonHeaders() {
        return new PersonV1("Mohammad Hashemi");
    }

    @GetMapping(value = "/person/header", headers = {"X-API-VERSION=2"})
    public PersonV2 getSecondVersionOfPersonHeaders() {
        return new PersonV2(new Name("Mohammad", "Hashemi"));
    }
}
