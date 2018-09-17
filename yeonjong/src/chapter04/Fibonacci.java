package chapter04;

import common.Print;
import common.UserInput;

public class Fibonacci {
    private static final int FIRST_NUMBER = 0;
    private static final int SECOND_NUMBER = 1;

    private void run() {
        Print.characters("몇 번째 항의 값을 알고싶나요?");
        int term = UserInput.getUserInteger();
        int result = getTermBy(FIRST_NUMBER, SECOND_NUMBER, term);
        Print.characters(String.valueOf(result));
    }

    public int getTermBy(int firstNumber, int secondNumber, int loop) {
        --loop;
        int result = firstNumber + secondNumber;
        if (loop <= 1) {
            return result;
        } else {
            return getTermBy(secondNumber, result, loop);
        }
    }

    public static void main(String[] args) {
        new Fibonacci().run();
    }
}
