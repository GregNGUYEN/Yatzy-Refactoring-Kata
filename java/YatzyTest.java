import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

	@Test
	public void chance_scores_the_sum_of_all_dice() {
		assertEquals(15, new Yatzee(2, 3, 4, 5, 1).chance());
		assertEquals(16, new Yatzee(3, 3, 4, 5, 1).chance());
	}

	@Test
	public void yatzy_scores_50() {
		assertEquals(50, new Yatzee(4, 4, 4, 4, 4).yatzee());
		assertEquals(50, new Yatzee(6, 6, 6, 6, 6).yatzee());
		assertEquals(0, new Yatzee(6, 6, 6, 6, 3).yatzee());
	}

	@Test
	public void ones_scores_sum_of_all_dice_equal_to_one() {
		assertEquals(1, new Yatzee(1, 2, 3, 4, 5).ones());
		assertEquals(2, new Yatzee(1, 2, 1, 4, 5).ones());
		assertEquals(4, new Yatzee(1, 2, 1, 1, 1).ones());
		assertEquals(0, new Yatzee(6, 2, 2, 4, 5).ones());
	}

	@Test
	public void twos_scores_sum_of_all_dice_equal_to_two() {
		assertEquals(4, new Yatzee(1, 2, 3, 2, 6).twos());
		assertEquals(10, new Yatzee(2, 2, 2, 2, 2).twos());
		assertEquals(0, new Yatzee(6, 6, 6, 6, 3).twos());
	}

	@Test
	public void threes_scores_sum_of_all_dice_equal_to_three() {
		assertEquals(6, new Yatzee(1, 2, 3, 2, 3).threes());
		assertEquals(12, new Yatzee(2, 3, 3, 3, 3).threes());
		assertEquals(0, new Yatzee(1, 2, 4, 5, 6).threes());
	}

	@Test
	public void fours_scores_sum_of_all_dice_equal_to_four() {
		assertEquals(12, new Yatzee(4, 4, 4, 5, 5).fours());
		assertEquals(8, new Yatzee(4, 4, 5, 5, 5).fours());
		assertEquals(4, new Yatzee(4, 5, 5, 5, 5).fours());
		assertEquals(0, new Yatzee(1, 5, 5, 5, 5).fours());
	}

	@Test
	public void fives_scores_sum_of_all_dice_equal_to_five() {
		assertEquals(10, new Yatzee(4, 4, 4, 5, 5).fives());
		assertEquals(15, new Yatzee(4, 4, 5, 5, 5).fives());
		assertEquals(20, new Yatzee(4, 5, 5, 5, 5).fives());
		assertEquals(0, new Yatzee(4, 2, 6, 1, 3).fives());
	}

	@Test
	public void sixes_scores_sum_of_all_dice_equal_to_six() {
		assertEquals(6, new Yatzee(4, 4, 6, 5, 5).sixes());
		assertEquals(18, new Yatzee(6, 5, 6, 6, 5).sixes());
		assertEquals(0, new Yatzee(4, 4, 4, 5, 5).sixes());
	}

	@Test
	public void one_pair_scores_the_sum_of_the_pair_of_dice() {
		assertEquals(6, new Yatzee(3, 4, 3, 5, 6).one_pair());
		assertEquals(10, new Yatzee(5, 3, 3, 3, 5).one_pair());
		assertEquals(12, new Yatzee(5, 3, 6, 6, 5).one_pair());
		assertEquals(0, new Yatzee(1, 3, 2, 6, 5).one_pair());
	}

	@Test
	public void two_pairs_scores_the_sum_of_the_two_pairs_of_dice() {
		assertEquals(16, new Yatzee(3, 3, 5, 4, 5).two_pairs());
		assertEquals(16, new Yatzee(3, 3, 5, 5, 5).two_pairs());
		assertEquals(10, new Yatzee(3, 3, 2, 2, 5).two_pairs());
		assertEquals(0, new Yatzee(3, 3, 5, 1, 6).two_pairs());
	}

	@Test
	public void three_of_a_kind_scores_the_sum_of_the_three_dice() {
		assertEquals(9, new Yatzee(3, 3, 3, 4, 5).three_of_a_kind());
		assertEquals(15, new Yatzee(5, 3, 5, 4, 5).three_of_a_kind());
		assertEquals(9, new Yatzee(3, 3, 3, 3, 5).three_of_a_kind());
		assertEquals(0, new Yatzee(3, 1, 2, 3, 2).three_of_a_kind());
	}

	@Test
	public void four_of_a_kind_scores_the_sum_of_the_four_dice() {
		assertEquals(12, new Yatzee(3, 3, 3, 3, 5).four_of_a_kind());
		assertEquals(20, new Yatzee(5, 5, 5, 4, 5).four_of_a_kind());
		assertEquals(12, new Yatzee(3, 3, 3, 3, 3).four_of_a_kind());
		assertEquals(0, new Yatzee(1, 2, 3, 3, 3).four_of_a_kind());
	}

	@Test
	public void smallStraight_scores_fifteen() {
		assertEquals(15, new Yatzee(1, 2, 3, 4, 5).smallStraight());
		assertEquals(15, new Yatzee(2, 3, 4, 5, 1).smallStraight());
		assertEquals(0, new Yatzee(1, 2, 2, 4, 5).smallStraight());
		assertEquals(0, new Yatzee(1, 2, 3, 5, 6).smallStraight());
	}

	@Test
	public void largeStraight_scores_twenty() {
		assertEquals(20, new Yatzee(6, 2, 3, 4, 5).largeStraight());
		assertEquals(20, new Yatzee(2, 3, 4, 5, 6).largeStraight());
		assertEquals(0, new Yatzee(1, 2, 2, 4, 5).largeStraight());
		assertEquals(0, new Yatzee(1, 2, 3, 4, 5).largeStraight());
	}

	@Test
	public void fullHouse_scores_the_sum_of_dice() {
		assertEquals(18, new Yatzee(6, 2, 2, 2, 6).fullHouse());
		assertEquals(12, new Yatzee(3, 2, 2, 2, 3).fullHouse());
		assertEquals(0, new Yatzee(2, 3, 4, 5, 6).fullHouse());
	}
}
