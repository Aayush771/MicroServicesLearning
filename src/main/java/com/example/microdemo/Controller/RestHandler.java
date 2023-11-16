package com.example.microdemo.Controller;

import com.example.microdemo.Entity.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class RestHandler {
    @Autowired
     private MessageSource messageSource;

    @GetMapping("/hello")
    public String getHelloHandler(){
         return "Hello MicroServices !";
    }

    @GetMapping("/hello-bean")
    public HelloBean getHelloBeanHandler(){
        return new HelloBean("Hello MicroServices !");
    }

    @GetMapping("/hello/{name}")
    public HelloBean getHelloVariableHandler(@PathVariable String name){
        return new HelloBean(String.format("Hello MicroServices! %s",name));
    }
    @GetMapping("/hello-intr")
    public String getHelloIntrHandler(){
         Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
  //  @PostMapping("user");
    //@GetMapping("users")
}
