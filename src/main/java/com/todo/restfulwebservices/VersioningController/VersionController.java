package com.todo.restfulwebservices.VersioningController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.restfulwebservices.Entity.Name;
import com.todo.restfulwebservices.Entity.PersonV1;
import com.todo.restfulwebservices.Entity.PersonV2;

@RestController
public class VersionController {
    @GetMapping("/v1/person")
    public PersonV1 getVersionOfPersonV1(){
        return  new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getVersionOfPersonV2(){
        return  new PersonV2(new Name("Bob","Charlie"));
    }
    @GetMapping(path = "/person",params = "version=1")
    public PersonV1 getFistVersionOfPersonByRequestParameter(){
        return  new PersonV1("Bob Charlie");
    }
    @GetMapping(path="/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonByRequestParameter(){
        return  new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFistVersionOfPersonByRequestHeaders(){
        return  new PersonV1("Bob Charlie");
    }
    @GetMapping(path="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonByRequestHeaders(){
        return  new PersonV2(new Name("Bob","Charlie"));
    }

}
