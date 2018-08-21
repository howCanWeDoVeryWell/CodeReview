package homework.operator;
// 입력받은 수에 따라 양수, 음수, 0을 출력하는 코드를 삼항연산자를 이용하여 작성하시오
import java.util.Scanner;

class TernaryOperatorCalculator {

	void doCalculate(Scanner scanner) {
		while(true) {
			Boolean isThatNumber = true;
			String userInputNumber = scanner.nextLine();

			if(userInputNumber.length() == 0) {
				isThatNumber = false;
			} else {
				CommonCalculatingExpression commonCalculatingExpression = new CommonCalculatingExpression();
				isThatNumber = commonCalculatingExpression.doCalculate(userInputNumber, isThatNumber);
			}

			if(!isThatNumber) {
				System.out.print("잘못 입력 하셨습니다. 다시 입력해주세요 : ");
			} else {
				int userInputNumberConverting = Integer.parseInt(userInputNumber);
				String userInputNumberSetting = userInputNumberConverting == 0 ?
						"0" : userInputNumberConverting > 0 ?
						"양수" :
						"음수";
				System.out.println(userInputNumberConverting + "은 " + userInputNumberSetting + " 입니다.");
				return;
			}
		}
	}
}

public class TernaryOperator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력 하세요 : ");

		TernaryOperatorCalculator ternaryOperatorCalculator = new TernaryOperatorCalculator();
		ternaryOperatorCalculator.doCalculate(scanner);
	}
}
