package chapter04;

import chapter02.constants.Loop;
import common.Print;
import common.UserInput;

// 주어진 문자열이 숫자인지 판별하는 프로그램
public class StringParser {
    class ASCIICode {
        private static final int ZERO = 48;
        private static final int NINE = 57;
    }

    private void run() {
        String userInputValue = UserInput.getUserInputString();
        boolean isNumber = analyzeString(userInputValue.toCharArray());
        printResult(isNumber);
    }

    private boolean analyzeString(char [] characters) {
        boolean isNumber = false;
        for (char character : characters) {
            if (!isNumber(character)) {
                return false;
            } else {
                isNumber = true;
            }
        }
        return isNumber;
    }

    private boolean isNumber(char character) {
        return ASCIICode.ZERO <= character && ASCIICode.NINE >= character;
    }

    private void printResult(boolean isNumber) {
        if (isNumber) {
            Print.characters("숫자입니다.");
        } else {
            Print.characters("숫자가 아니에요.");
        }
    }

    public static void main(String[] args) {
        new StringParser().run();
    }
}
