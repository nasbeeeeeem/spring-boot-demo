package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.dto.Sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/hello")

public class HelloControler {
  @GetMapping
  public Sample hello() {
    Sample sample = new Sample();
    sample.setId(100);
    sample.setName("hoge");

    return sample;
  }
  
}
