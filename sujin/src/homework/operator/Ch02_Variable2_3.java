package homework.operator;

import java.util.Scanner;

/*
 * 4. ?? ₯λ°μ? ?? ?Ό??λ¦¬λ?? 1λ‘? λ°κΎΈ? μ½λλ₯? ??±???€
 * 777?? ₯? 771μΆλ ₯
 */
public class Ch02_Variable2_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?? ₯???€ : ");
		int userInput = scan.nextInt();
		
		int changingNum = (userInput / 10) * 10 + 1;
		System.out.println(changingNum);
		
	}
}
