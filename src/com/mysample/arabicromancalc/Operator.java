package com.mysample.arabicromancalc;

public enum Operator {
	Addition, Subtraction, Multiplication, Division;

	public static Operator valueOfSwitch(String value) {
		switch (value) {
		case "+":
			return Addition;
		case "-":
			return Subtraction;
		case "*":
			return Multiplication;
		case "/":
			return Division;
		}
		return null;
	}

}
