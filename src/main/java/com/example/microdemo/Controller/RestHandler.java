package com.example.microdemo.Controller;

import com.example.microdemo.Entity.HelloBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHandler {

    @GetMapping("/Hello")
    public String getHelloHandler(){
         return "Hello MicroServices !";
    }

    @GetMapping("/Hello-bean")
    public HelloBean getHelloBeanHandler(){
        return new HelloBean("Hello MicroServices !");
    }

    @GetMapping("/Hello/{name}")
    public HelloBean getHelloVariableHandler(@PathVariable String name){
        return new HelloBean(String.format("Hello MicroServices! %s",name));
    }

  //  @PostMapping("user");
    //@GetMapping("users")
}
