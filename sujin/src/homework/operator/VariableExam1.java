package homework.operator;
// 문자를 한글자 입력받아 숫자일 때만 true를 리턴하는 코드를 작성하시오
import java.util.Scanner;

class NumberReturnCalculator {

	void checkOnlyOneWord(Scanner scanner) {
		while(true) {
			Boolean isThatWords = true;
			String userInputWord = scanner.nextLine();

			if(userInputWord.length() != 1) {
				isThatWords = false;
			} else {
				CommonCalculatingExpression commonCalculatingExpression = new CommonCalculatingExpression();
				isThatWords = commonCalculatingExpression.doCalculate(userInputWord, isThatWords);
			}

			if(!isThatWords) {
				System.out.print("숫자나 한글자가 아닙니다. 다시 입력해주세요 : ");
			} else {
				System.out.println("숫자 입니다 : true");
				return;
			}
		}
	}
}

public class VariableExam1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("한글자를 입력하세요 : ");

		NumberReturnCalculator numberReturnCalculator = new NumberReturnCalculator();
		numberReturnCalculator.checkOnlyOneWord(scanner);
	}
}
