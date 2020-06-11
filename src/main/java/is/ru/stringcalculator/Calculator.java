package is.ru.stringcalculator;
public class Calculator {
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String numList[] = splitNumbers(text, ",|\n");
			return sum(numList);
		}
	}
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
		    total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
    }
}
