package homework.operator;

import java.util.Scanner;

/*
 * 2. λ¬Έμλ₯? ?κΈ?? ?? ₯λ°μ ?«??Ό?λ§? 
 * trueλ₯? λ¦¬ν΄?? μ½λλ₯? ??±???€
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
					System.out.println("?«??Ή");
				} else {
					System.out.println("?«???");
				}
			}
        } catch (RuntimeException e) {
            System.err.println("?κΈ?? ?? ₯? ?΄?Ό?¨");
        }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?? ₯???€ : ");
		String userInput = scan.nextLine();
		
		Ch03_Variable3_2 chVariable3 = new Ch03_Variable3_2();
		chVariable3.regularExpressionCheck(userInput);
	}
}
