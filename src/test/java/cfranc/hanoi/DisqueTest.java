package cfranc.hanoi;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisqueTest {

	private Disque petit = new Disque(1);
	private Disque grand = new Disque(3);

	@Test
	public void compareTo_SmallTall_Negative() {
		int expected = -1;
		int actual = petit.compareTo(grand);

		assertEquals(expected,actual);
	}

	@Test
	public void compareTo_TallSmall_Positive() {
		int expected = 1;
		int actual = grand.compareTo(petit);

		assertEquals(expected,actual);
	}

	@Test
	public void compareTo_SmallSmall_Zero() {
		int expected = 0;
		Disque petit2 = new Disque(1);
		int actual = petit.compareTo(petit2);

		assertEquals(expected,actual);
	}

}
