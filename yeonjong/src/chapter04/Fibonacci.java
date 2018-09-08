package chapter04;

//  0, 1, 1, 2, 3, 5, 8, 13, 21, 34
// 피보나치 수열의 10번째 항은 무엇일까요? 34
// * 피보나치 수열이란 첫번째 항의 값이 0이고 두 번째 항의 값이 1일 때 이후의 항들은 이전의 두 항을 더한 값으로 만들어지는 수열을 말한다.
// * 수열을 이루는 구성원을 수열의 항(term)이라고 한다.

public class Fibonacci {
    private void getTenTerm() {
        int firstTerm = 0;
        int secondTerm = 1;
        int sum = 0;
        int loop = 8;

        for (int i = 0; i < loop; i++) {
            sum = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = sum;
        }
        System.out.println("[tenTerm]" + sum);
    }

    public static void main(String[] args) {
        new Fibonacci().getTenTerm();
    }
}
