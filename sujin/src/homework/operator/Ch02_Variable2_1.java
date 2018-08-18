
package homework.operator;

import java.util.Scanner;

/*1. ?��?��받�? ?��?�� ?��?�� '?��?��', '?��?��' '0'?�� 출력?��?�� 코드�?
?��?��?��?��?���? ?��?��?��?�� ?��?��?��?��?��
*/
public class Ch02_Variable2_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("?��?��?��dddddd?��?�� : ");
		int userInput = scan.nextInt();
		
		String result = "";
		
		if(userInput == 0) {
			result = "0";
		} else {
			if(userInput > 0) {
				result = "?��?��";
			} else {
				result = "?��?��";
			}
		}
		
//		String result = userInput == 0 ? "0" : (userInput > 0 ? "?��?��" : "?��?��");
		System.out.println(result);
	}
}
