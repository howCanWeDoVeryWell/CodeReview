package chapter04;

import chapter02.constants.Loop;
import common.Print;
import common.UserInput;

// 주어진 문자열이 숫자인지 판별하는 프로그램
public class StringParser {
    public void run() {
        String userInputValue = UserInput.getUserInputString();
        boolean isNumber = isNumbers(userInputValue);
        if (isNumber) {
            Print.characters("숫자입니다.");
        } else {
            Print.characters("숫자가 아니에요.");
        }
    }

    private boolean isNumbers(String userInputValue) {
        try {
            Integer.parseInt(userInputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new StringParser().run();
    }
}
