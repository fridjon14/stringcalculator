package is.ru.stringcalculator;

/*public void Delim{		
	String delim = ",";
}*/
public class Calculator {



	public static int add(String text){

		String delimiter = ",";
		if(text.startsWith("//[")){
			text = text.replaceFirst("\\[","/(");
			text = text.replaceAll("\\]\\[",")|(");
			text = text.replaceAll("\\]", ")/");
			delimiter = text.substring(2,text.indexOf("\n"));
			text = text.substring(text.indexOf("\n")+1);
			System.out.print(delimiter+"\n");
			System.out.print(text);
		}
		else if(text.startsWith("//")){
			delimiter = text.substring(2,text.indexOf("\n"));
			text = text.substring(text.indexOf("\n")+1);
		}

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(delimiter) || text.contains("\n")){
			return sum(splitNumbers(text, delimiter));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiter){
	    return numbers.split("\\Q" + delimiter + "\\E" + "|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	int num = toInt(number);
        	if (num < 0){
        		System.out.print("Negatives not allowed: " + number);
        	}
        	else if(num > 1000){

        	}
        	else{
		    	total += toInt(number);
		    }
		}
		return total;
    }

}