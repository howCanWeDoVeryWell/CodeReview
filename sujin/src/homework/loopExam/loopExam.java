package src.homework.loopExam;

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
