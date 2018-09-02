package chapter03;

import java.util.Arrays;
import java.util.List;

public class Loop {
    public static final int DISABLED_NUMBER_TWO = 2;
    public static final int DISABLED_NUMBER_THREE = 3;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 20;

    // 1 ~ 20 중에 2배수 3배수 제외하고 합
    public static void sumMultiple() {
        int START_NUMBER = 1;
        int END_NUMBER = 20;
        int sum = 0;
        List<Integer> DISABLED_LIST = Arrays.asList(DISABLED_NUMBER_TWO, DISABLED_NUMBER_THREE);

        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            int sumValue = i;
            for (Integer disabledNumber : DISABLED_LIST) {
                if (i % disabledNumber != 0) {
                    sumValue = 0;
                }
            }
            sum += sumValue;
        }
        System.out.println("---- sumMultiple result ----");
        System.out.println("sum" + sum);
    }

    // 1 + 2 + 3 + ... + 10
    public static void sumOnetoTen() {
        int startNumber = 1;
        int endNumber = 10;
        int sum = 0;

        for (int i = startNumber; i <= endNumber; i ++) {
            sum += i;
        }
        System.out.println("---- sum1to10 result ----");
        System.out.println("sum" + sum);
    }

    // 주사위 2개 던져 합이 6인 경우의 수
    public static void getNumberOfCases() {
        int [] blackDice = {1, 2, 3, 4, 5, 6};
        int [] whiteDice = {1, 2, 3, 4, 5, 6};
        int casesCount = 0;
        int conditionNumber = 6;

        for (int i = 0, blackDiceLength = blackDice.length; i < blackDiceLength; i++) {
            for (int j = 0, whiteDiceLength = whiteDice.length; j < whiteDiceLength; j++) {
                if (blackDice[i] + whiteDice[j] == conditionNumber) {
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
        int maxNumber = 100;
        int loopCount = 0;
        int shift = 1;

        while (currentNumber <= maxNumber) {
            currentNumber = startNumber * shift;
            startNumber++;
            loopCount++;
            shift *= -1;
        }
        System.out.println("---- infiniteSeries result ----");
        System.out.println("LoopCount is " + loopCount);
    }

    public static void main(String [] args) {
        calculateInfiniteSeries();
        getNumberOfCases();
        sumMultiple();
        sumOnetoTen();
    }
}
