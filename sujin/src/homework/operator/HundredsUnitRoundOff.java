package homework.operator;
// 입력받은 수의 백의 자리 이하를 버리는 코드를 작성 하시오(ex> 456 입력시 400)
import java.util.Scanner;

class HundredsUnitRoundOffCalculator {

	void doCalculateChangingNumberOneUnitToOne(Scanner scanner) {
		while(true) {
			Boolean isThatHundredsNumber = true;
			String userInputNumber = scanner.nextLine();

			if(userInputNumber.length() != 3) {
				isThatHundredsNumber = false;
			} else {
				CommonCalculatingExpression commonCalculatingExpression = new CommonCalculatingExpression();
				isThatHundredsNumber = commonCalculatingExpression.doCalculate(userInputNumber, isThatHundredsNumber);
			}

			if(!isThatHundredsNumber) {
				System.out.print("숫자가 세자리 수가 아니거나 공백입니다. 다시 입력해주세요 : ");
			} else {
				int stringConvertToInt = Integer.parseInt(userInputNumber);
				int changedNumber = stringConvertToInt / 100 * 100;

				System.out.println("백의 자리가 모두 0로 변한 숫자 : " + changedNumber);
				return;
			}
		}
	}
}

public class HundredsUnitRoundOff {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("100의 자리 이상을 입력하면 백의 자리 이후 숫자를 0으로 만들 것이다.");
		System.out.print("100 이상의 숫자를 입력하세요 : ");

		HundredsUnitRoundOffCalculator hundredsUnitRoundOffCalculator = new HundredsUnitRoundOffCalculator();
		hundredsUnitRoundOffCalculator.doCalculateChangingNumberOneUnitToOne(scanner);
	}
}
