public class Yatzee {

	protected int[] dice;

	public Yatzee(int die1, int die2, int die3, int die4, int die5) {
		dice = new int[5];
		dice[0] = die1;
		dice[1] = die2;
		dice[2] = die3;
		dice[3] = die4;
		dice[4] = die5;
	}

	public int chance() {
		int sum = 0;

		for (int i = 0; i < dice.length; i++) {
			sum += dice[i];
		}

		return sum;
	}

	public int yatzee() {
		int value = dice[0];

		for (int i = 1; i < dice.length; i++) {
			if (dice[i] != value) {
				return 0;
			}
		}

		return 50;
	}

	public int ones() {
		return sumWhereEquals(1);
	}

	public int twos() {
		return sumWhereEquals(2);
	}

	public int threes() {
		return sumWhereEquals(3);
	}

	public int fours() {
		return sumWhereEquals(4);
	}

	public int fives() {
		return sumWhereEquals(5);
	}

	public int sixes() {
		return sumWhereEquals(6);
	}

	public int one_pair() {
		return computeSumOfIdenticalValues(2);
	}

	public int two_pairs() {
		int[] counts = countDiceByValue();

		int n = 0;
		int sum = 0;

		for (int i = 6; i >= 1; i--)
			if (counts[i - 1] >= 2) {
				n++;
				sum += i;
			}

		if (n == 2)
			return sum * 2;
		else
			return 0;
	}

	public int three_of_a_kind() {

		return computeSumOfIdenticalValues(3);
	}

	public int four_of_a_kind() {
		
		return computeSumOfIdenticalValues(4);
	}
	public int smallStraight() {
		int[] counts = countDiceByValue();
		
		for (int i = 0; i <= 4; i++) {
			if (counts[i]==1)
				continue;
			else
				return 0;
		}
		
		return 15;
	}

	public int largeStraight() {
		int[] counts = countDiceByValue();
		
		for (int i = 1; i <= 5; i++) {
			if (counts[i]==1)
				continue;
			else
				return 0;
		}
		
		return 20;
	}

	public int fullHouse() {
		boolean pairDetected = false;
		int i;
		int _2_at = 0;
		boolean _3 = false;
		int _3_at = 0;

		int[] counts = countDiceByValue();

		for (i = 0; i != 6; i += 1)
			if (counts[i] == 2) {
				pairDetected = true;
				_2_at = i + 1;
			}

		for (i = 0; i != 6; i += 1)
			if (counts[i] == 3) {
				_3 = true;
				_3_at = i + 1;
			}

		if (pairDetected && _3)
			return _2_at * 2 + _3_at * 3;
		else
			return 0;
	}

	private int sumWhereEquals(int value) {
		int sum = 0;

		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == value)
				sum += value;
		}

		return sum;
	}

	private int computeSumOfIdenticalValues(int numberOfIdenticalValues) {
		int[] counts = countDiceByValue();
		
		for (int i = 6; i >= 1; i--)
			if (counts[i - 1] >= numberOfIdenticalValues)
				return i * numberOfIdenticalValues;

		return 0;
	}


	private int[] countDiceByValue() {
		int[] counts = new int[6];

		for (int i = 0; i < dice.length; i++) {
			counts[dice[i] - 1]++;
		}
		return counts;
	}
}
