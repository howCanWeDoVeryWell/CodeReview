package homework.operator;

import java.util.Scanner;

/*
 * 2. ë¬¸ìë¥? ?•œê¸?? ?…? ¥ë°›ì•„ ?ˆ«??¼?•Œë§? 
 * trueë¥? ë¦¬í„´?•˜?Š” ì½”ë“œë¥? ?‘?„±?•˜?‹œ?˜¤
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
					System.out.println("?ˆ«??‹¹");
				} else {
					System.out.println("?ˆ«??•„?‹˜");
				}
			}
        } catch (RuntimeException e) {
            System.err.println("?•œê¸?? ?…? ¥?„ ?•´?•¼?•¨");
        }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?…? ¥?•˜?‹œ?˜¤ : ");
		String userInput = scan.nextLine();
		
		Ch03_Variable3_2 chVariable3 = new Ch03_Variable3_2();
		chVariable3.regularExpressionCheck(userInput);
	}
}
