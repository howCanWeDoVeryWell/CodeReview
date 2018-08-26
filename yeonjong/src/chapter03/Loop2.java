package chapter03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loop2 {
    public static final int MAX_NUMBER = 10;
    public static final int EQUATION_X = 2;
    public static final int EQUATION_Y = 4;
    public static final int DIVISION_NUMBER = 10;

    // Equation  : 방정식
    // 2x + 4y = 10 경우의 수
    public void calculateEquation() {
        int count = 0;

        for (int i = 0; i < MAX_NUMBER; i ++) {
            for (int j = 0; j < MAX_NUMBER; j++) {
                if (i * EQUATION_X + j * EQUATION_Y == MAX_NUMBER) {
                    count++;
                }
            }
        }
        System.out.println("---- equation result ----");
        System.out.println("count " + count);
    }

    // 입력 받은 수 각각 더하기
    public void sumEach(int userInputNumber) {
        int sum = 0;
        while (userInputNumber > 0) {
            sum += userInputNumber % DIVISION_NUMBER;
            userInputNumber = userInputNumber / DIVISION_NUMBER;
        }
        System.out.println("---- sumEach result ----");
        System.out.println("sum " + sum);
    }

    public void getUserInputValue() throws InputMismatchException {
        System.out.println("숫자를 입력하세요.");
        Scanner scanAnswer = new Scanner(System.in);
        sumEach(scanAnswer.nextInt());
    }

    public static void main(String[] args) {
        Loop2 loop2 = new Loop2();
        loop2.calculateEquation();
        try {
            loop2.getUserInputValue();
        } catch (InputMismatchException exception) {
            System.out.println("숫자가 아니네요..");
        }
    }
}