package com.mysample.arabicromancalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	public Object[] parse(String input) throws Exception {
		Pattern multiplicationPattern = Pattern.//
				compile("(?<roman>\\b(?:VI{0,3}|I(?:[XV]|I{0,2}))|[X]\\b)|(?<operator>\\b[-+\\/*]\\b)|(?<arabic>\\b10|[1-9]\\b)",
						Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher multiplicationMather = multiplicationPattern.matcher(input);
		int i = 0;
		Object[] res = new Object[4];
		while (multiplicationMather.find()) {
			if (i < 4) {
				switch (i) {
				case 0:
				case 2:
					String operand = multiplicationMather.group("arabic");
					if (operand == null) {
						operand = multiplicationMather.group("roman");
						if (res[0] != null && !(Boolean) res[0])
							throw new Exception("используются одновременно разные системы счисления");
						else
							res[0] = true;
					} else if (res[0] != null && (Boolean) res[0])
						throw new Exception("используются одновременно разные системы счисления");
					else
						res[0] = false;

					if (operand == null)
						throw new Exception("строка не является математической операцией");
					else
						res[i + 1] = operand;
					break;
				case 1:
					String operator = multiplicationMather.group("operator");
					if (operator == null)
						throw new Exception("строка не является математической операцией");
					else
						res[i + 1] = operator;
				default:
					break;
				}
			} else
				throw new Exception(
						"формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
			i++;
		}
		if (i < 3)
			throw new Exception("строка не является математической операцией");
		return res;
	}
}
