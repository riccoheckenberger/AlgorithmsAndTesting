package de.hska.iwi.ads.solution.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardboxTest {

	Cardbox<Integer> c1 = new Cardbox<Integer>(1, null);
	Cardbox<Integer> c2 = new Cardbox<Integer>(2, null);
	
	@Test
	void volume() {
		assertEquals(1, c2.compareTo(c1), 0.00000001); //c2 than c1
		assertEquals(-1, c1.compareTo(c2), 0.00000001);//c1 smaller than c2
		assertEquals(0, c1.compareTo(c1), 0.00000001); //c1 euqally big as c1
	}

}
