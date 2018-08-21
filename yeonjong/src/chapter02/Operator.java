package chapter02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator {

    public static void ternary() {

        int userAnswer = scanUserAnswer();
        String result = userAnswer > 0 ? "양수" : userAnswer < 0 ? "음수" : "0";
        System.out.println(result);
    }

    public static void dumpHundreds() {

        int userAnswer = scanUserAnswer();
        float result = userAnswer / 100 * 100;
        System.out.println(result);
    }

    public static void changeUnits() {

        int userAnswer = scanUserAnswer();
        int result = userAnswer / 10 * 10 + 1;
        System.out.println(result);
    }

    public static void multiple() {

        int userAnswer = scanUserAnswer();
        int result = (userAnswer / 10 * 10 + 10) - userAnswer;
        System.out.println(result);
    }



    public static int scanUserAnswer() {

        int userAnswer = 0;
        System.out.println("숫자를 입력하세요.");
        Scanner answerScanner = new Scanner(System.in);

        try {
            return userAnswer = answerScanner.nextInt();
        } catch (InputMismatchException exception) {
            scanUserAnswer();
        }

        return userAnswer;

    }

    public static void selectedQuestion() {

        int selectedQuestion = 0;
        System.out.println("문제의 숫자를 선택하세요.");
        Scanner questionScanner = new Scanner(System.in);

        try {
            selectedQuestion = questionScanner.nextInt();

            switch (selectedQuestion) {

                case 1 :
                    ternary();
                    break;
                case 2 :
                    dumpHundreds();
                    break;
                case 3 :
                    changeUnits();
                    break;
                case 4 :
                    multiple();
                    break;
                case 5 :
                    System.out.println("FINISH..");
                    break;
                default :
                    selectedQuestion();

            }

        } catch (InputMismatchException exception) {
            selectedQuestion();
        }

    }


    public static void showQuestions() {

        System.out.println("1. 삼항연산자를 이용하여 음수, 양수, 0 출력하기");
        System.out.println("2. 백의자리 이하 버리기 ");
        System.out.println("3. 입력받은 수의 일의 자리를 1로 바꾸기");
        System.out.println("4. 입력받은 수보다 크면서 가장 가까운 10의 배수에서 입력받은 수 빼기");
        System.out.println("5. 종료");

        selectedQuestion();

    }

    public static void main(String[] args) {

        showQuestions();

    }
}
