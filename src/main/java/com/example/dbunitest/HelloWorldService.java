package com.example.dbunitest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private HelloWorldRepository helloWorldRepository;

    @Autowired
    public HelloWorldService(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    public String getString() {
        return helloWorldRepository.findById("1").get().getName();
    }
}
