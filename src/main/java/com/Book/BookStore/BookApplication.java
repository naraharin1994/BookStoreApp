package com.Book.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
		
		/*
		 * Flux.just("Alpha","Beta","gamma","delta","epsilon").
		 * map(s->s.concat(" rays")).subscribe(System.out::println);
		 * 
		 * //Flatmap Flux.just("Alpha","Beta","gamma","delta","epsilon").
		 * flatMap(s->Flux.fromArray(s.split(""))).subscribe(System.out::println);
		 * 
		 * //scan Flux.just("Alpha","Beta","gamma","delta","epsilon").
		 * scan((accumulator,next) -> accumulator + next)
		 * .subscribe(s->System.out.println("Received" + s));
		 * 
		 * //reduce Flux.just("Alpha","Beta","gamma","delta","epsilon").
		 * reduce((Total,next) -> Total + next)
		 * .subscribe(s->System.out.println("Received reduce " + s));
		 */
	}

}
