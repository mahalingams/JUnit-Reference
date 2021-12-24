package com.JUnit;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.JUnit.MathUtil;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest {
	MathUtil mathUtil;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This run before all monthed.");
	}

	@BeforeEach
	void init() {
		mathUtil = new MathUtil();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up....");
	}

	@Nested
	class AddClass {
		@Test
		void testAdd() {
			// int expected = 2;
			// int actual = mathUtil.add(1, 1);
			// assertEquals(expected, actual, "The add method should add two numbers");
			assertAll(() -> assertEquals(-2, mathUtil.add(-1, -1)), () -> assertEquals(-4, mathUtil.add(-3, -1)),
					() -> assertEquals(-4, mathUtil.add(-3, -1)));
		}

		@Test
		void testAddPos() {
			// int expected = 2;
			// int actual = mathUtil.add(1, 1);
			// assertEquals(expected, actual, "The add method should add two numbers");
			assertAll(() -> assertEquals(2, mathUtil.add(1, 1)), () -> assertEquals(4, mathUtil.add(3, 1)),
					() -> assertEquals(7, mathUtil.add(3, 4)));
		}
	}

	@RepeatedTest(2)
	@DisplayName("Testing and Method")
	void divideTest() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0), "Divide by zero should thrown");
	}

	@Test
	void circleAreaTest() {
		boolean isUp = true;
		assumeTrue(isUp);
		assertEquals(314.1592653589793, mathUtil.circleArea(10), "Should return circle area");
	}

	@Test
	@Disabled
	@DisplayName("Test is not run")
	void testDisable() {
		System.out.println("Test is disabled");
	}
}
