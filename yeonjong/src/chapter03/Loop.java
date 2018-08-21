package chapter03;

public class Loop {


    // 1 ~ 20 중에 2배수 3배수 제외하고 합
    public static void sumMultiple() {

        int startNumber = 1;
        int endNumber = 20;
        int exceptionNumber1 = 2;
        int exceptionNumber2 = 3;
        int sum = 0;

        for(int i = startNumber; i < endNumber; i++) {
            if(!(i % exceptionNumber1 == 0 || i % exceptionNumber2 == 0)) {
                sum += i;
            }
        }

        System.out.println("---- sumMultiple result ----");
        System.out.println("sum" + sum);
    }

    // 1 + 2 + 3 + ... + 10
    public static void sum1to10() {

        int startNumber = 1;
        int endNumber = 10;
        int sum = 0;

        for (int i = startNumber; i <= endNumber; i ++) {
            sum = sum + i;
        }
        System.out.println("---- sum1to10 result ----");
        System.out.println("sum" + sum);
    }

    // 주사위 2개 던져 합이 6인 경우의 수
    public static void getNumberOfCases() {

        int [] blackDice = {1, 2, 3, 4, 5, 6};
        int [] whiteDice = {1, 2, 3, 4, 5, 6};
        int casesCount = 0;

        for (int i = 0; i < blackDice.length; i++) {
            for (int j = 0; j < whiteDice.length; j++) {
                if (blackDice[i] + whiteDice[j] == 6) {
                    casesCount++;
                }
            }
        }
        System.out.println("---- casesCount result ----");
        System.out.println("casesCount is " + casesCount);
    }


    // InfiniteSeries : 무한 급수
    // 1 + (-2) + 3 + ...
    public static void calculateInfiniteSeries() {

        int startNumber = 1;
        int currentNumber = 0;
        int MaxNumber = 100;

        int loopCount = 0;
        int shift = 1;


        while (currentNumber <= MaxNumber) {

            currentNumber += startNumber;
            startNumber++;
            loopCount++;
            shift *= -1;
        }

        System.out.println("---- infiniteSeries result ----");
        System.out.println("LoopCount is " + loopCount);
    }

    public static void main(String[] args) {
        calculateInfiniteSeries();
        getNumberOfCases();
        sumMultiple();
        sum1to10();
    }
}
