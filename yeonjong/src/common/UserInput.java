package common;

import chapter02.constants.Loop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    public static int getUserInteger() {
        int count = 0;
        while (count++ < Loop.MAX_COUNT) {
            try {
                System.out.println("숫자를 입력하세요.");
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아니에요.");
            }
        }
        return 0;
    }

    public static String getUserInputString() {
        System.out.println("아무키나 입력하세요.");
        return new Scanner(System.in).nextLine();
    }


}
