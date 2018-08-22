package homework.loop;
// 1 + (-2) + 3 + (-4) .... 이렇게 더하였을 때 몇 까지 더해야 총합이 100이상 나오는지 구하시오.
public class LoopSumTotalExam {
	public static void sum() {
		int sum = 0;
		int index = 0;

		while (sum < 100) {
			index++;
			if (index % 2 == 0) {
				sum -= index;
			} else {
				sum += index;
			}


		}

		System.out.println(index + " 까지 더해야 총합이 100 나온다.");
		System.out.println("sum : " + sum);
	}

	public static void main(String[] args) {
		sum();
	}
}
