package com.melashvili.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitTestingApplicationTests {

	Calculator testing = new Calculator();

	@Test
	void itShouldAddNumbers() {
		int one = 20;
		int two = 25;
		int added = testing.addNumbers(one, two);
		System.out.println(added);
	}

	static class Calculator{
		int addNumbers(int a, int b){
			return a + b;
		}
	}

}
