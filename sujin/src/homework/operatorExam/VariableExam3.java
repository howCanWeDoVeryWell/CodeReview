package src.homework.operatorExam;

import java.util.Scanner;

class ComplexCalculationResult {
	private final static int DEFAULT_DIVIDING_NUMBER = 10;
	private final static int DEFAULT_MULTIPLY_NUMBER = 10;
	private final static int DEFAULT_PLUS_NUMBER = 10;
	
	void CalculateComplexSolving(Scanner scanner) {
		
		while(true) {
			Boolean isThatHundredsNumber = true;
			String userInputNumber = scanner.nextLine();
			
			CommonCalculatingExpression commonCalculatingExpression = new CommonCalculatingExpression();
			isThatHundredsNumber = commonCalculatingExpression.doCalculate(userInputNumber, isThatHundredsNumber);
			
			if(!isThatHundredsNumber) {
				System.out.print("잘못 입력 하셨습니다. 다시 입력해주세요 : ");
			} else {
				int stringConvertToInt = Integer.parseInt(userInputNumber);
				int closingNumberFromTargetNumber = stringConvertToInt / DEFAULT_DIVIDING_NUMBER * DEFAULT_MULTIPLY_NUMBER + DEFAULT_PLUS_NUMBER;
				
				int closingNumberFromTargetNumberMinusUserInputNumber = closingNumberFromTargetNumber - stringConvertToInt;
				System.out.println("10의 배수에서 입력받은 수를 뺀 수는 : " + closingNumberFromTargetNumberMinusUserInputNumber);
				return;
			}
		}
	}
}

public class VariableExam3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("10의 배수에서 입력받은 수를 뺀 수를 구할 것이다 ");
		System.out.print("값을 입력 하세요 ");
		
		ComplexCalculationResult complexCalculationResult = new ComplexCalculationResult();
		complexCalculationResult.CalculateComplexSolving(scanner);
		
	}

}
