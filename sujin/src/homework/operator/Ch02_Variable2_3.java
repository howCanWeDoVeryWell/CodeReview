package homework.operator;

import java.util.Scanner;

/*
 * 4. ?…? ¥ë°›ì? ?ˆ˜?˜ ?¼?˜?ë¦¬ë?? 1ë¡? ë°”ê¾¸?Š” ì½”ë“œë¥? ?‘?„±?•˜?‹œ?˜¤
 * 777?…? ¥?‹œ 771ì¶œë ¥
 */
public class Ch02_Variable2_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?…? ¥?•˜?‹œ?˜¤ : ");
		int userInput = scan.nextInt();
		
		int changingNum = (userInput / 10) * 10 + 1;
		System.out.println(changingNum);
		
	}
}
