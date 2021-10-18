package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import Petri.Petrinet;
import Petri.Place;

public class PetrinetTest {
	@BeforeAll
	static void setup() {
		System.out.println("BeforeAll");
		Petrinet petrinet = new Petrinet(null, null, null);
		
	}

	@BeforeEach
	void setupThis() {
		System.out.println("BeforeEach");
	}


	@Test
	@Order(1)

	public void testgetName() {
		Place p = new Place("michou",2);
		
		Assertions.assertEquals("michou", p.getName());
		Assertions.assertEquals(2, p.getTokens());	
		

	}
	
	@Test
	@Order(2)
	public void testgetTokens() {
		Place p = new Place("michou",2);
		Assertions.assertEquals(2, p.getTokens());	
		

	}
	
	@Test
	@Order(4)
	public void testremoveTokens() {
		Place p = new Place("michou",10);
		p.removeTokens(5);
		Assertions.assertEquals(5, p.getTokens());			
		p.removeTokens(23);
		Assertions.assertEquals(0, p.getTokens());			

	}
	
	@Test
	@Order(3)
	public void constructor() {
		Place p0 = new Place();
		Assertions.assertEquals(0, p0.getTokens());	
		Assertions.assertEquals("P_1", p0.getName());	
		
		Place p1 = new Place(null, 0);
		Assertions.assertEquals("PLACE", p1.getName());
		
		Place p = new Place("michou",-5);
		Assertions.assertEquals(-5, p.getTokens());		
		p.removeTokens(3);
		Assertions.assertEquals(0, p.getTokens());	

		
		Place p2 = new Place("michou",0);
		p2.addTokens(5);
		Assertions.assertEquals(5, p2.getTokens());	
	}

}
