import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook  g1;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(3);
		g1.addScore(60);
		g1.addScore(20);
		g1.addScore(10);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
	}

	@Test
	void testSum() {
		assertEquals(90, g1.sum(), .0001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(10, g1.minimum(), .001);

	}
	
	@Test
	void addScoreTest() {
		assertTrue(g1.toString().equals("60.0 20.0 10.0 "));

	}

}
