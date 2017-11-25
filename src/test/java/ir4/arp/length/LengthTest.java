package ir4.arp.length;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class LengthTest {
	
	@Test(expected = RuntimeException.class)
	public void should_return_exception_when_given_negative2() {
		new Length(-2);
	}

	@Test
	public void should_return_length_when_given_10() {
		Length lengthA = new Length(10);

		assertEquals(10, lengthA.getvalue());

	}

	@Test
	public void should_return_length_when_given_9() {
		Length lengthA = new Length(9);

		assertEquals(9, lengthA.getvalue());
	}

	@Test
	public void should_return_true_when_given_9_9() {
		Length lengthA = new Length(9);
		Length lengthB = new Length(9);

		assertEquals(lengthA, lengthB);

	}

	@Test
	public void should_return_false_when_given_9cm_10cm() {
		Length lengthA = new Length(9, "cm");
		Length lengthB = new Length(10, "cm");
		assertEquals(-1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_0_when_given_9cm_9cm() {
		Length lengthA = new Length(9, "cm");
		Length lengthB = new Length(9, "cm");
		assertEquals(0, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_0_when_given_10m_10m() {
		Length lengthA = new Length(10, "m");
		Length lengthB = new Length(10, "m");
		assertEquals(0, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_negative_1_when_given_9cm_10cm() {
		Length lengthA = new Length(9, "cm");
		Length lengthB = new Length(10, "cm");
		assertEquals(-1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_negative_1_when_given_10m_9m() {
		Length lengthA = new Length(10, "m");
		Length lengthB = new Length(9, "m");
		assertEquals(1, lengthA.compare(lengthB));
	}

	// @Test(expected = RuntimeException.class)
	// public void should_return_exception__when_given_9cm_9m(){
	// Length lengthA = new Length(9, "cm");
	// Length lengthB = new Length(9, "m");
	// lengthA.compare(lengthB);
	// }

	@Test
	public void should_return_0_when_given_9m_900cm() {
		Length lengthA = new Length(9, "m");
		Length lengthB = new Length(900, "cm");
		assertEquals(0, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_1_when_given_9m_10cm() {
		Length lengthA = new Length(9, "m");
		Length lengthB = new Length(10, "cm");
		assertEquals(1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_negative_when_given_10cm_9m() {
		Length lengthA = new Length(10, "cm");
		Length lengthB = new Length(9, "m");
		assertEquals(-1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_0_when_given_9m_9000mm() {
		Length lengthA = new Length(9, "m");
		Length lengthB = new Length(9000, "mm");
		assertEquals(0, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_negative_when_given_10mm_9m() {
		Length lengthA = new Length(10, "mm");
		Length lengthB = new Length(9, "m");
		assertEquals(-1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_1_when_given_9m_10mm() {
		Length lengthA = new Length(9, "m");
		Length lengthB = new Length(10, "mm");
		assertEquals(1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_0_when_given_9cm_90mm() {
		Length lengthA = new Length(9, "cm");
		Length lengthB = new Length(90, "mm");
		assertEquals(0, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_1_when_given_9cm_10mm() {
		Length lengthA = new Length(9, "cm");
		Length lengthB = new Length(10, "mm");
		assertEquals(1, lengthA.compare(lengthB));
	}

	@Test
	public void should_return_negative_1_when_given_10mm_9cm() {
		Length lengthA = new Length(10, "mm");
		Length lengthB = new Length(9, "cm");
		assertEquals(-1, lengthA.compare(lengthB));
	}

	@Test(expected = RuntimeException.class)
	public void should_return_exception_when_given_9km_9km() {
		Length lengthA = new Length(9, "km");
		Length lengthB = new Length(9, "km");
		lengthA.compare(lengthB);
	}

	@Test(expected = RuntimeException.class)
	public void should_return_exception_when_given_negative2m() {
		new Length(-2, "m");
	}
}
