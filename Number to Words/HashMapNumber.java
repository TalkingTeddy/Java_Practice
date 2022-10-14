import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapNumber {
	
	static Map<Integer, String> numbers_converter = new HashMap<Integer, String>();
	static Map<Integer, String> numbers_place = new HashMap<Integer, String>();
	static Map<Integer, String> numbers_tens = new HashMap<Integer, String>();
	
	
	public static String convert(int num) {

//check if void has any effect on null		
			if (num < 20) {
				String number = numbers_converter.get(num);
				System.out.println(number);
			}
			if (num == 20) {
				String number = numbers_tens.get(2);
				System.out.print(number);
			}
			if (num > 20 && num < 100) {
				int a = num / 10;
				int b = num % 10;
				String numberA = numbers_tens.get(a);
				String numberB = numbers_converter.get(b);
				System.out.print(numberA + " " + numberB);
			}
			if (num == 100) {
				String number = numbers_place.get(3);
				System.out.println(number);
			}
			if (num > 100 && num < 1000) {
				int a = num / 100;
				String numberA = numbers_converter.get(a);
				System.out.print(numberA + " hundred ");
				return convert(num % 100);
			}
			if (num == 1000) {
				String number = numbers_place.get(4);
				System.out.println("One " + number);
			}
			if (num > 1000 & num < 10000) {
				int a = num / 1000;
				String numberA = numbers_converter.get(a);
				System.out.print(numberA + " thousand ");
				return convert(num % 1000);
			}
			
			if (num == 10000) {
				String a = numbers_converter.get(10);
				String number = numbers_place.get(4);
				System.out.println(a + " " + number);
			}
			
			if (num > 10000 && num < 100000) {
					
				if ((num / 1000) > 10 && (num / 1000) < 20) {
					int a = num / 1000;
					String numberA = numbers_converter.get(a);
					System.out.print(numberA + " thousand ");
					return convert(num % 1000);
				} else {
					int a = num / 10000;
					String numberA = numbers_tens.get(a);	
					System.out.print(numberA + " ");
					return convert(num % 10000);
				}
				
			}
			if(num == 100000) {
				String a = numbers_place.get(3);
				String number = numbers_place.get(4);
				System.out.print(a + " " + number);
			}
			
			if(num > 100000 && num < 1000000) {
				int a = num / 100000;
				String numberA = numbers_converter.get(a);
				System.out.print(numberA + " hundred ");
				return convert(num % 100000);
			}
			
			if (num == 1000000) {
				String a = numbers_place.get(7);
				System.out.print("One " + a);
			}
			if (num > 1000000 && num < 1000000000) {
				int a = num / 1000000;
				System.out.print(convert(a) + " Million ");
				return convert(num % 1000000);
			}
		return null;

	}
	
	
	
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the Number to be converted to word");
		 int num = sc.nextInt();
		
		numbers_converter.put(0,"zero");
		numbers_converter.put(1,"One");
	    numbers_converter.put(2,"Two");
	    numbers_converter.put(3,"Three");
	    numbers_converter.put(4,"Four");
	    numbers_converter.put(5,"Five");
	    numbers_converter.put(6,"Six");
	    numbers_converter.put(7,"Seven");
	    numbers_converter.put(8,"Eight");
	    numbers_converter.put(9,"Nine");
	    numbers_converter.put(10,"Ten");
	    numbers_converter.put(11,"Eleven");
	    numbers_converter.put(12,"Twelve");
	    numbers_converter.put(13,"Thirteen");
	    numbers_converter.put(14,"Fourteen");
	    numbers_converter.put(15,"Fifteen");
	    numbers_converter.put(16,"Sixteen");
	    numbers_converter.put(17,"Seventeen");
	    numbers_converter.put(18,"Eighteen");
	    numbers_converter.put(19,"Nineteen");
	    
	    numbers_place.put(3,"Hundred");
	    numbers_place.put(4,"Thousand");
	    numbers_place.put(7,"Million");
	    numbers_place.put(11,"Billion");

	    numbers_tens.put(2,"Twenty");
	    numbers_tens.put(3,"Thirty");
	    numbers_tens.put(4,"Forty");
	    numbers_tens.put(5,"Fifty");
	    numbers_tens.put(6,"Sixty");
	    numbers_tens.put(7,"Seventy");
	    numbers_tens.put(8,"Eighty");
	    numbers_tens.put(9,"Ninty");
		
	    
	    convert(num);
		sc.close();
	}
	
}
