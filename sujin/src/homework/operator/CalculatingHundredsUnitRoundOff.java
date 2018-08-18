package homework.operator;

import java.util.Scanner;

/*
 * 4. ?��?��받�? ?��?�� ?��?��?��리�?? 1�? 바꾸?�� 코드�? ?��?��?��?��?��
 * 777?��?��?�� 771출력
 */
public class Ch02_Variable2_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?��?��?��?��?�� : ");
		int userInput = scan.nextInt();
		
		int changingNum = (userInput / 10) * 10 + 1;
		System.out.println(changingNum);
		
	}
}
