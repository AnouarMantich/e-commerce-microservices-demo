package org.example.customerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.p1}")
    private String x;
    @Value("${global.params.p2}")
    private String y;

    @GetMapping("/config")
    public List<String> configTest(){
     return List.of(x,y);
    }
}
