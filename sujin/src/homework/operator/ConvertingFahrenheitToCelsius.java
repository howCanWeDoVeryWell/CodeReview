package homework.operator;

import java.util.Scanner;

class ConvertingFahrenheitToCelsiusResult {
	void CalculateFahrenheitToCelsius(Scanner scanner) {
//		5.0 / 9 * (f - 32);
		while(true) {
			Boolean isThatHundredsNumber = false;
			String userInputNumber = scanner.nextLine();
			
			CommonCalculatingExpression commonCalculatingExpression = new CommonCalculatingExpression();
			isThatHundredsNumber = commonCalculatingExpression.doCalculate(userInputNumber, isThatHundredsNumber);
			
			if(isThatHundredsNumber) {
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");
			} else {
				double stringConvertToInt = Double.parseDouble(userInputNumber);
				double changedNumber = 5.0 / 9 * (stringConvertToInt - 32);
				
				System.out.println("섭씨에서 화씨로 변하는것은? " + changedNumber);
				return;
			}
		}
	}
}

public class ConvertingFahrenheitToCelsius {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("섭씨에서 화씨로 변환하는 코드를 만들어 볼 것이다.");
		System.out.print("값을 입력 하세요 ");
		
		ConvertingFahrenheitToCelsiusResult convertingFahrenheitToCelsiusResult = new ConvertingFahrenheitToCelsiusResult();
		convertingFahrenheitToCelsiusResult.CalculateFahrenheitToCelsius(scanner);
	}
}