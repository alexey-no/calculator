package com.mysample.arabicromancalc;
import java.util.Scanner;

public class Application {

	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		Parser parser = new Parser();
		try {
			Object[] params = parser.parse(s);
			Calculator calc = new Calculator();
			String result = calc.execute((Boolean)params[0], (String)params[1], (String)params[2], (String)params[3]);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
