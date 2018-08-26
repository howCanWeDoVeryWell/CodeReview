package chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loop {
    public static final int DISABLED_NUMBER_TWO = 2;
    public static final int DISABLED_NUMBER_THREE = 3;

    // 1 ~ 20 중에 2배수 3배수 제외하고 합
    public static void sumMultiple() {
        int endNumber = 20;
        int sum = 0;
        int[] number = new int[endNumber];
        int[] disabledNumber = {DISABLED_NUMBER_TWO, DISABLED_NUMBER_THREE};

        for (int i = 0; i < endNumber; i++) {
            number[i] = i + 1;
        }

        for (int i = 0, sizeI = number.length; i < sizeI; i++) {
            for (int j = 0, sizeJ = disabledNumber.length; j < sizeJ; j++) {
                if (number[i] % disabledNumber[j] == 0) {
                    number[i] = 0;
                }
            }
        }

        for (int i = 0, size = number.length; i < size; i++) {
            sum += number[i];
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

        for (int i = 0, blackDiceSize = blackDice.length; i < blackDiceSize; i++) {
            for (int j = 0, whiteDiceSize = whiteDice.length; j < whiteDiceSize; j++) {
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

    public static void main(String[] args) {
        calculateInfiniteSeries();
        getNumberOfCases();
        sumMultiple();
        sumOnetoTen();
    }
}
