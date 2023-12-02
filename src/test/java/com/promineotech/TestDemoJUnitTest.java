package com.promineotech;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import  java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.promineoTech.TestDemo;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	@Test
	void assertThatNumberIsSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	@Test //Checks if a name is returned correctly
	void checkIfThisIsTheFullName() {
		assertThat(testDemo.fullName("Thomas", "Maier")).isEqualTo("Thomas Maier");
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addInt(4, 5)).isEqualTo(9);
		assertThat(testDemo.addInt(9, 13)).isEqualTo(22);
		assertThat(testDemo.addInt(8, 39)).isEqualTo(47);
		
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTheseTwoNumbersWereAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addInt(a, b)).isEqualTo(expected);
			
		}else {
			assertThatThrownBy(()-> testDemo.addInt(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
		arguments(2, 4, 6, false),
		arguments(3, 0, 3, true),
		arguments(-1, 112, 110, true),
		arguments(3, 11, 14, false)
		);
	}

}
