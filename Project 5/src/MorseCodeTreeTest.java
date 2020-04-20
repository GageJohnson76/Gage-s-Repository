import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest {
	MorseCodeTree tree = new MorseCodeTree();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	void testFetch() {
		
		String  code = ".--";
		assertEquals("w", tree.fetch(code));
	}
	
	@Test
	void testToArrayList() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("h");
		testList.add("s");
		testList.add("v");
		testList.add("i");
		testList.add("f");
		testList.add("u");
		testList.add("e");
		testList.add("l");
		testList.add("r");
		testList.add("a");
		testList.add("p");
		testList.add("w");
		testList.add("j");
		testList.add("");
		testList.add("b");
		testList.add("x");
		testList.add("n");
		testList.add("c");
		testList.add("k");
		testList.add("y");
		testList.add("t");
		testList.add("z");
		testList.add("g");
		testList.add("q");
		testList.add("m");
		testList.add("o");
		assertEquals(testList, tree.toArrayList());
	}
	

}
