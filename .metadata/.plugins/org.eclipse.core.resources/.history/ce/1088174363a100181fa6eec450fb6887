package homework.operatorExam;

import java.util.Scanner;

class ChangingNumberOneUnitToOneReresult {
	
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
				int changedNumber = stringConvertToInt / 10 * 10 + 1;
				
				System.out.println("일의 자리수 가 1로 변한 숫자 : " + changedNumber);
				return;
			}
		}
	}
}

public class ChangingNumberOneUnitToOne {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("100이상의 숫자를 입력하세요 : ");
		
		ChangingNumberOneUnitToOneReresult changingNumberOneUnitToOneReresult = new ChangingNumberOneUnitToOneReresult();
		changingNumberOneUnitToOneReresult.doCalculateChangingNumberOneUnitToOne(scanner);
	}
}
