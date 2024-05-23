package com.todo.restfulwebservices.HelloWorld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String returnHelloWorld(){
        return "Hello from springBoot Application";
    }

    @GetMapping("/hello-bean")
    public HelloWorldBean returnHelloWorldBean(){
        return new HelloWorldBean("Hello from springBoot Application");
    }

    @GetMapping("/hello-variable/{nameString}")
    public HelloWorldBean returnHelloWorldVariable(@PathVariable String nameString){
        return new HelloWorldBean(String.format("Hello %s",nameString));
    }
    
}
