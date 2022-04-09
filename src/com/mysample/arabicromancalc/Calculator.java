package com.mysample.arabicromancalc;

public class Calculator {

	public String execute(Boolean isRoman, String operand1, String operator, String operand2) throws Exception {
		if (isRoman) {
			operand1 = convertRomanToArabic(operand1);
			operand2 = convertRomanToArabic(operand2);
		}
		int res = 0;
		int op1 = Integer.parseInt(operand1);
		int op2 = Integer.parseInt(operand2);
		switch (Operator.valueOfSwitch(operator)) {
		case Addition:
			res = op1 + op2;
			break;
		case Subtraction:
			res = op1 - op2;
			break;
		case Division:
			res = op1 / op2;
			break;
		case Multiplication:
			res = op1 * op2;
			break;
		}

		if (isRoman)
			return convertArabicToRoman(res);
		return Integer.toString(res);
	}

	private String convertArabicToRoman(int input) throws Exception {
		if (input < 1)
			throw new Exception("в римской системе нет отрицательных чисел и нуля");
		String s = "";
		while (input >= 100) {
			s += "C";
			input -= 100;
		}
		while (input >= 90) {
			s += "XC";
			input -= 90;
		}
		while (input >= 50) {
			s += "L";
			input -= 50;
		}
		while (input >= 40) {
			s += "XL";
			input -= 40;
		}
		while (input >= 10) {
			s += "X";
			input -= 10;
		}
		while (input >= 9) {
			s += "IX";
			input -= 9;
		}
		while (input >= 5) {
			s += "V";
			input -= 5;
		}
		while (input >= 4) {
			s += "IV";
			input -= 4;
		}
		while (input >= 1) {
			s += "I";
			input -= 1;
		}
		return s;
	}

	private String convertRomanToArabic(String s) {
		int nums[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.toUpperCase().charAt(i)) {
			case 'X':
				nums[i] = 10;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'I':
				nums[i] = 1;
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				sum -= nums[i];
			else
				sum += nums[i];
		}
		return Integer.toString(sum + nums[nums.length - 1]);
	}

}
