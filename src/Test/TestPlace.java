package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import Petri.Place;

public class TestPlace {
	@BeforeAll
	static void setup() {
		System.out.println("BeforeAll");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("BeforeEach");
	}


	@Test
	@Order(1)

	public void testgetName() {
		Place p = new Place(2);
		
		Assertions.assertEquals(2, p.get_nb_jetons());


	}
}