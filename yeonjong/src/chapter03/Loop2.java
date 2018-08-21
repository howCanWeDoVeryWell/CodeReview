package chapter03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loop2 {

    // Equation  : 방정식
    // 2x + 4y = 10 경우의 수
    public static void calculateEquation() {

        int x = 2;
        int y = 4;
        int maxNumber = 10;
        int count = 0;

        for (int i = 0; i < maxNumber; i ++) {
            for (int j = 0; j < maxNumber; j++) {
                if (i * x + j * y == maxNumber) {
                    count++;
                }
            }
        }
        System.out.println("---- equation result ----");
        System.out.println("count " + count);
    }

    // 입력 받은 수 각각 더하기
    public static void sumEach() {

        try {
            System.out.println("숫자를 입력하세요.");
            Scanner scanAnswer = new Scanner(System.in);
            int userInputNumber = scanAnswer.nextInt();
            int sum = 0;

            while (userInputNumber > 0) {
                sum += userInputNumber % 10;
                userInputNumber = userInputNumber / 10;
            }
            System.out.println("---- sumEach result ----");
            System.out.println("sum " + sum);

        } catch (InputMismatchException exception) {
            sumEach();
        }
    }

    public static void fibonacci() {

    }

    public static void discrimination() {

    }


    public static void main(String[] args) {
        calculateEquation();
        sumEach();
        //fibonacci();
        //discrimination();

    }


}
