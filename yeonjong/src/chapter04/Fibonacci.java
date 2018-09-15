package chapter04;

import common.Print;
import common.UserInput;

public class Fibonacci {
    private static int FIRST_NUMBER = 0;
    private static int SECOND_NUMBER = 1;

    private void run() {
        int term = UserInput.getUserInteger();
        int result = getTermBy(FIRST_NUMBER, SECOND_NUMBER, term);
        Print.number(result);
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
