package chapter04;

import common.UserInput;

// 주어진 문자열이 숫자인지 판별하는 프로그램
public class Discrimination {
    class ASCIICode {
        private static final int ZERO = 48;
        private static final int NINE = 57;
    }

    private void run() {
        String userInputValue = UserInput.getUserInputString();
        boolean isNumber = isNumber(userInputValue);
        printResult(isNumber);
    }

    private boolean isNumber(String userInputValue) {
        char [] characters = userInputValue.toCharArray();
        for (char character : characters) {
            if (!(ASCIICode.ZERO <= character && ASCIICode.NINE >= character)) {
                return false;
            }
        }
        return true;
    }

    private void printResult(boolean isNumber) {
        if (isNumber) {
            System.out.println("숫자입니다.");
        } else {
            System.out.println("숫자가 아니에요.");
        }
    }

    public static void main(String[] args) {
        new Discrimination().run();
    }
}
