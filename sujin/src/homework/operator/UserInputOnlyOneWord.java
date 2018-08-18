package homework.operator;

import java.util.Scanner;

/*
 * 2. 문자�? ?���??�� ?��?��받아 ?��?��?��?���? 
 * true�? 리턴?��?�� 코드�? ?��?��?��?��?��
 */
public class Ch03_Variable3_2 {
	public void regularExpressionCheck(String userInput) {
		try {
			if ("".equals(userInput))  {
				throw new RuntimeException();
			} else {
				Boolean checkPatten = false;
				checkPatten = userInput.matches("^[0-9]*$");
			
				if (checkPatten) {
					System.out.println("?��?��?��");
				} else {
					System.out.println("?��?��?��?��");
				}
			}
        } catch (RuntimeException e) {
            System.err.println("?���??�� ?��?��?�� ?��?��?��");
        }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?��?��?��?��?�� : ");
		String userInput = scan.nextLine();
		
		Ch03_Variable3_2 chVariable3 = new Ch03_Variable3_2();
		chVariable3.regularExpressionCheck(userInput);
	}
}C
