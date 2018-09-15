package chapter04;

import common.Print;
import common.UserInput;

// (0), 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
// 전달받은 번재의 항을 구한다
// 재귀를 사용한다.

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
