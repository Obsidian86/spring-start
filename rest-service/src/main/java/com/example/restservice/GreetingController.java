package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.utils.Utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Included, %s!, %s";
  private final AtomicLong counter = new AtomicLong();
  private static Utils utils = new Utils();

	@GetMapping("/")
	public List<Base> base() {
    List<Base> returnContent = new ArrayList<>();
    for(int i=0; i<10; i++){
      String content = String.format("%s", i + 1);
      returnContent.add(new Base(counter.incrementAndGet(), content, "blue"));
    }
    int delIndex = -1;
    String toDelete = "2";
    for(int i=0; i< returnContent.size(); i++){
      Boolean sameChar = utils.compareStrings(returnContent.get(i).getContent(), toDelete);
      if(sameChar) delIndex = i; 
    }
    if(delIndex > -1) returnContent.remove(delIndex); 
		return returnContent;
  }

	@GetMapping("/include")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "_x") String name) {
    String content = String.format(template, name, "asd");
		return new Greeting(counter.incrementAndGet(), content);
  }
  
	@PostMapping("/")
	public Greeting postGreeting(@RequestBody Greeting inGreet) {
		return new Greeting(counter.incrementAndGet(), inGreet.getContent());
  }
  
}