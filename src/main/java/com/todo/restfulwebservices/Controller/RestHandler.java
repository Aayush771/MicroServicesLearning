package com.todo.restfulwebservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.restfulwebservices.Entity.HelloBean;

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
    /**
     * This function is used to get the localized message from message source. 
     * If the message key is not found, the default message will be returned.
     *
     * @return String The localized message.
     */
    @GetMapping("/hello-intr")
    public String getHelloIntrHandler(){
         // Get the current locale
         Locale locale = LocaleContextHolder.getLocale();
        // Use message source to get the localized message
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }


}
