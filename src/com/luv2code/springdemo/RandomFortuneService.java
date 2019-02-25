package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${fortunes.array}")
	private String[] fortunes;
	
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		return fortunes[myRandom.nextInt(fortunes.length)];
	}
	
	@PostConstruct
	private void postConstructLoadedFortunes() {
		System.out.println(">> Loading fortunes...");
		for (int i = 0; i < fortunes.length; i++ ) {
			System.out.println(fortunes[i]);
		}
	}

}
