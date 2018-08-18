package homework.operator;

import java.util.Scanner;

/*
 * ?��?��받�? ?��?�� 백의 ?���? ddddddddddd?��?���? 버리?�� 코드�? ?��?��?��?��?��
 * 456?��?��?�� 400출력
 */
public class Ch02_Variable2_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?��?��?��?��?�� : ");
		int userInput = scan.nextInt();
		
		int result = (userInput / 100) * 100;
		System.out.println(result);
	}
}
