package com.example.microdemo.Filtreing;

import com.example.microdemo.Entity.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
public class FilteringController {
private MappingJacksonValue getJacksonFilter(MappingJacksonValue mappingJacksonValue){
    PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;
}
@GetMapping("filteredBean")
    public MappingJacksonValue getFilteredBean(){
     SomeBean someBean = new SomeBean("Value1","Value2","Value3");

        return  getJacksonFilter(new MappingJacksonValue(someBean));
    }
    @GetMapping("filteredBeanList")
    public MappingJacksonValue getFilteredBeanList(){
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("Value1","Value2","Value3"),new SomeBean("Value4","Value5","Value6"));

        return  getJacksonFilter(new MappingJacksonValue(someBeanList));
    }
}
