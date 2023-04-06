package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BMICalculatorTest {

	@Test
	void should_ReturnTrue_When_DietRecommended() {
		
		//arrange
		double weight = 89;
		double height = 1.72;
		
		//act
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		//assert
		assertTrue(recommended);
	}
	
	@Test
	void should_ReturnFalse_When_DietNotRecommended() {
		
		//arrange
		double weight = 50;
		double height = 1.92;
		
		//act
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		//assert
		assertFalse(recommended);
	}
	
	@Test
	void should_ThrowArithmeticException_When_HeightZero() {
		
		//arrange
		double weight = 50;
		double height = 0.0;
		
		//act
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		
		//assert
		assertThrows(ArithmeticException.class, executable);
	}
	
	void should_ThrowArithmeticException_When_Height() {
		
		//arrange
		double weight = 50;
		double height = 0.0;
		
		//act
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		
		//assert
		assertThrows(ArithmeticException.class, executable);
	}
	
	@Test
	void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
		
		//arrange
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80, 60.0));
		coders.add(new Coder(1.82, 98.0));
		coders.add(new Coder(1.82, 64.7));
		
		//act
		Coder corderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		
		//assert
		assertAll(
		() ->	assertEquals(1.82, corderWorstBMI.getHeight()),
		() ->	assertEquals(98.0, corderWorstBMI.getWeight())			
		);
	}
	@Test
	void should_ReturnNullWorstBMI_When_CoderListEmpty() {
		
		//arrange
		List<Coder> coders = new ArrayList<>();

		
		//act
		Coder corderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		
		//assert
		assertNull(corderWorstBMI);
	}
	

}
