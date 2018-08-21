package homework.loop;
// 1 + (1 + 2) + (1 + 2 + 3) + ... 의 결과를 구하시오.
class loopCalculator {
	void doCalculator() {
		int totolSum = 0;
		for(int i = 1; i <= 10; i++) {
			totolSum += i;
			for(int j = 1; j < i; j ++) {
				totolSum += j;
			}
		}
		System.out.println(totolSum);
	}
}

public class loopExam {
	public static void main(String[] args) {
		loopCalculator loopCalculator = new loopCalculator();
		loopCalculator.doCalculator();
	}
}
