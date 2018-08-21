package chapter02;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator2 {

    public static void fahrenheitToCelsius() {

        try {
            System.out.println("섭씨를 입력하세요.");
            Scanner userAnswer = new Scanner(System.in);
            int celsius = userAnswer.nextInt();

            System.out.println("화씨를 입력하세요.");
            int fahrenheit = userAnswer.nextInt();

            int result = celsius = 5 / 9 * (fahrenheit - 32);

            System.out.println(result);

        } catch (InputMismatchException exception) {
            System.out.println("숫자를 입력하세요.");
            fahrenheitToCelsius();
        }
    }


    public static void checkNumber() {


        System.out.println("아무키나 입력하세요. ");
        boolean isNumber = false;
        try {
            int ascii = System.in.read();
            if (ascii >= 48 && ascii <= 57) {
                isNumber = true;
            }
        } catch (IOException exception) {
            checkNumber();
        }

        System.out.println(isNumber);

    }

    public static void convertAlphabetic() {

        System.out.println("단어 또는 문장을 입력하세요.");

        Scanner scanAnswer = new Scanner(System.in);
        char[] userAnswer = scanAnswer.nextLine().toCharArray();

        for (int i = 0; i < userAnswer.length; i++) {

            if (userAnswer[i] >= 65 && userAnswer[i] <= 90) {
                userAnswer[i] = (char) Character.toString(userAnswer[i]).toLowerCase().charAt(0);
                //System.out.println("convert toLower" + userAnswer[i]);
                continue;
            }
            if (userAnswer[i] >= 97 && userAnswer[i] <= 122) {
                userAnswer[i] = (char) Character.toString(userAnswer[i]).toUpperCase().charAt(0);
                //System.out.println("convert toUpper" + userAnswer[i]);
                continue;
            }
        }
        for (int i = 0; i < userAnswer.length; i++) {
            System.out.print(userAnswer[i]);
        }

    }

    public static void selectedQuestion() {
        System.out.println("문제를 선택하세요.");

        Scanner scanQuestion = new Scanner(System.in);

        int userQuestion = scanQuestion.nextInt();

        try {
            switch (userQuestion) {
                case 1 :
                    fahrenheitToCelsius();
                    break;
                case 2 :
                    checkNumber();
                    break;
                case 3 :
                    convertAlphabetic();
                    break;
                case 4 :
                    System.out.println("FINISH...");
                    break;
                default :
                    selectedQuestion();
                    break;
            }
        } catch (InputMismatchException exception) {
            System.out.println("메뉴번호를 입력하세요.");
            selectedQuestion();
        }

    }


    public static void main(String[] args) {

        System.out.println("1. 화씨를 섭씨로 반환하기 ");
        System.out.println("2. 숫자일때만 TRUE 반환하기");
        System.out.println("3. 대문자는 소문자로, 소문자는 대문자로 반환하기");
        System.out.println("4. 종료");

        selectedQuestion();
    }



}
