
package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleClient", url = "https://jsonplaceholder.typicode.com")
public interface SimpleFeignClient {
    @GetMapping("/posts/{id}")
    Post getPostById(@PathVariable("id") Long id);
}
