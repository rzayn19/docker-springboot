package com.rahul.test.docker_spring_boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList; // Unused import
import java.util.List; // Unused import

@SpringBootTest
class DockerSpringBootApplicationTests {

	private static final int MAGIC_NUMBER = 42; // Magic number example

	@Test
	void contextLoads() {
		// Unused variable
		String unusedVariable = "I am not used";

		// Long method with multiple statements
		doSomethingLong();
	}

	void doSomethingLong() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Doing something... " + i);
		}

		List<String> list = new ArrayList<>();
		list.add("Duplicate code");
		list.add("Duplicate code");

		try {
			// Do something that could throw an exception
		} catch (Exception e) {
			// Empty catch block
		}

		// Duplicate code block
		String duplicateString = "This is duplicate";
		String anotherDuplicateString = "This is duplicate";
	}
}
