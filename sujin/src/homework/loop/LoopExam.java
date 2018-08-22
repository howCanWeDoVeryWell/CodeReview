package homework.loop;
// 1 + (1 + 2) + (1 + 2 + 3) + ... 의 결과를 구하시오.

public class LoopExam {
	static void calculateInfiniteSeries() {
		int totalSum = 0;
		for (int i = 1; i <= 10; i++) {
			totalSum += i;
			for (int j = 1; j < i; j ++) {
				totalSum += j;
			}
		}
		System.out.println(totalSum);
	}

	public static void main(String[] args) {
		calculateInfiniteSeries();
	}
}
