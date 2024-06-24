package com.example.webpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  // model에 add attribute로 data를 넣어주고 hello.html에서 해당 data 사용
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data","spring!!");
    return "hello";
  }

  // mvc 형태
  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }

  // api 형태인데 response가 string
  // reponsebody annotation이 있어야 view resolver가 작동하지 않음
  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name") String name) {
    return "hello " + name;
  }

  // api 형태인데 response가 json
  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
  }

  static class Hello {
    private String name;
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
  }
}
