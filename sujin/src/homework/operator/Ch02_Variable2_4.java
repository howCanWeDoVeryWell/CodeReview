package homework.operator;

import java.util.Scanner;

/*
 * 4. ?? ₯λ°μ? ?λ³΄λ€ ?¬λ©΄μ ?? ₯λ°μ? ?? κ°??₯ κ°?κΉμ΄
 * 10? λ°°μ?? ?? ₯λ°μ? ?λ₯? λΊ? ?λ₯? κ΅¬ν? μ½λλ₯? ??±???€
 */
public class Ch02_Variable2_4 {
	private final static int DEFAULT_DIVIDING_NUMBER = 10;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?? ₯???€ : ");
		int userInput = scan.nextInt();
		
		int compareNum = userInput / DEFAULT_DIVIDING_NUMBER * 10 + 10;
		int result = compareNum - userInput;
		
		System.out.println(result);
		
	}
}
