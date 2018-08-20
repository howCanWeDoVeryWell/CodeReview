package src.homework.operatorExam;
// 대문자를 소문자, 소문자를 대문자로 바꾸시오
import java.util.Scanner;

class LowerUpperConversionCalculator {
	
	void changeValueToLowerOrUpper(Scanner scanner) {
		char stringConvertToChar = 0;
		String changedTargetValue = "";
		
		while(true) {
			Boolean isThatNumber = true;
			String userInputNumber = scanner.nextLine();
			
			if(userInputNumber.length() == 0) {
				isThatNumber = false;
			} else {
				for(int i = 0; i < userInputNumber.length(); i++) {
					stringConvertToChar = userInputNumber.charAt(i);
					if(!(stringConvertToChar >= 65 && stringConvertToChar <= 90) && !(stringConvertToChar >= 97 && stringConvertToChar <= 122)) {
						if(userInputNumber.charAt(i) == 45)  {
							continue;
						} else {
							isThatNumber = false;
							break;
						}
					}
				}
			}
			
			if(!isThatNumber) {
				System.out.print("잘못 입력 하셨습니다. ..  다시 입력해주세요 : ");
			} else {
				for(int i = 0; i < userInputNumber.length(); i++) {
					stringConvertToChar = userInputNumber.charAt(i);
					if (stringConvertToChar >= 65 && stringConvertToChar <= 90) {
						changedTargetValue += String.valueOf(stringConvertToChar).toLowerCase();
					} else if (stringConvertToChar >= 97 && stringConvertToChar <= 122) {
						changedTargetValue += String.valueOf(stringConvertToChar).toUpperCase();
				    }
				}
				System.out.println("changedTargetValue : "  + changedTargetValue);
				return; 

			}
		}
	}
}

public class LowerUpperConversion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("값을 입력 하세요 ");
		
		LowerUpperConversionCalculator lowerUpperConversionCalculator = new LowerUpperConversionCalculator();
		lowerUpperConversionCalculator.changeValueToLowerOrUpper(scanner);
	}
}
