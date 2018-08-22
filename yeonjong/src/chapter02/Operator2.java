package chapter02;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator2 {

    public static final String QUESTION_ONE = "1";
    public static final String QUESTION_TWO = "2";
    public static final String QUESTION_THREE = "3";
    public static final String QUESTION_FOUR = "4";

    public static final int ASCII_ONE = 48;
    public static final int ASCII_NINE = 57;

    //1. 화씨를 섭씨로 반환하기
    // Fahrenheit : 화씨
    // Celsius : 섭씨
    public int convertFahrenheitToCelsius(int celsius, int fahrenheit) {
        return celsius = 5 / 9 * (fahrenheit - 32);
    }

    // 2. 숫자일때만 TRUE 반환하기
    public boolean checkNumber(int userInput) {
        boolean isNumber = false;
        if (userInput >= ASCII_ONE && userInput <= ASCII_NINE) {
            isNumber = true;
        }
        return isNumber;
    }

    // 3. 대문자는 소문자로, 소문자는 대문자로 반환하기
    public static void convertAlphabetic(String userInput) {


        Scanner scanAnswer = new Scanner(System.in);
        char[] userAnswer = scanAnswer.nextLine().toCharArray();

        for (int i = 0; i < userAnswer.length; i++) {

            if (userAnswer[i] >= 65 && userAnswer[i] <= 90) {
                userAnswer[i] = (char) Character.toString(userAnswer[i]).toLowerCase().charAt(0);
            }
            if (userAnswer[i] >= 97 && userAnswer[i] <= 122) {
                userAnswer[i] = (char) Character.toString(userAnswer[i]).toUpperCase().charAt(0);
            }
        }
        for (int i = 0; i < userAnswer.length; i++) {
            System.out.print(userAnswer[i]);
        }

    }

    public int getUserCharacter(String message) {
        System.out.println(message);
        int userCharacter;
        try {
            return System.in.read();
        } catch (IOException exception) {
            return 0;
        }
    }

    public String getUserInput(String message) {
        System.out.println(message);
        Scanner answerScanner = new Scanner(System.in);
        return answerScanner.nextLine();
    }

    public int getUserInputNumber(String message) throws InputMismatchException {
        System.out.println(message);
        Scanner answerScanner = new Scanner(System.in);
        return answerScanner.nextInt();
    }



    public void solveProblem(String questionNumber) {

        switch (questionNumber) {
            case QUESTION_ONE :
                int celsius = getUserInputNumber("섭씨를 입력하세요.");
                int fahrenheit = getUserInputNumber("화씨를 입력하세요.");
                System.out.println(convertFahrenheitToCelsius(celsius, fahrenheit));
                break;
            case QUESTION_TWO :
                System.out.println(checkNumber(getUserCharacter("아무키나 입력하세요.")));
                break;
            case QUESTION_THREE :

                break;
            case QUESTION_FOUR :
                System.out.println("FINISH..");
                break;
            default :
                System.out.println("없는 문제입니다.");
                break;
        }
    }

    public void showMenu() {
        System.out.println("1. 화씨를 섭씨로 반환하기 ");
        System.out.println("2. 숫자일때만 TRUE 반환하기");
        System.out.println("3. 대문자는 소문자로, 소문자는 대문자로 반환하기");
        System.out.println("4. 종료");

        System.out.println("문제의 숫자를 선택하세요.");
        Scanner questionScanner = new Scanner(System.in);
        String questionNumber = questionScanner.nextLine();
        solveProblem(questionNumber);

    }


    public static void main(String[] args) {

        Operator2 operator = new Operator2();

        operator.showMenu();

    }



}
