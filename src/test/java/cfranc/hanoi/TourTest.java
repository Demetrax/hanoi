package cfranc.hanoi;

import static org.junit.Assert.*;

import org.junit.Test;

public class TourTest {
	private Tour t = new Tour(2);
	private Disque petit = new Disque(1);
	private Disque moyen = new Disque(2);
	private Disque grand = new Disque(3);


	@Test
	public void empiler_TourVide_Vraie() {
		boolean expected = true;
		boolean actual = t.empiler(moyen);
		assertEquals(expected,actual);
	}

	@Test
	public void empiler_MoyenSurTourAvecGrand_Vraie() {
		boolean expected = true;
		t.empiler(grand);
		boolean actual = t.empiler(moyen);
		assertEquals(expected,actual);
	}

	@Test
	public void empiler_MoyenSurTourAvecSmall_Faux() {
		boolean expected = false;
		t.empiler(moyen);
		boolean actual = t.empiler(grand);
		assertEquals(expected,actual);
	}

	@Test
	public void empiler_TourComplete_Faux() {
		boolean expected = false;
		t.empiler(grand);
		t.empiler(moyen);
		boolean actual = t.empiler(petit);
		assertEquals(expected,actual);
	}

	@Test
	public void sommet_MoyenGrand_Moyen() {
		Disque expected = moyen;
		t.empiler(grand);
		t.empiler(moyen);
		Disque actual = t.sommet();
		assertEquals(expected,actual);
	}
}
