package myUberTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberCalculs.Position;

class PositionTest {
	
	private Position p;

	@Test
	void testGetX() {
		p=new Position(1.0,2.3);
		assertTrue(p.getX()==1.0);
	}


	@Test
	void testGetY() {
		p=new Position(1.0,2.3);
		assertTrue(p.getY()==2.3);
	}

	@Test
	void testSetX() {
		final Position pos = new Position(1.0,2.3);
		pos.setX(3.1);
		assertTrue(pos.getX()==3.1);
	}

	@Test
	void testSetY() {
		final Position pos = new Position(1.0,2.3);
		pos.setY(7.8);
		assertTrue(pos.getY()==7.8);
	}

	@Test
	void testEqualsObject() {
		Position p1=new Position(1.0,2.3);
		Position p2=new Position(1.0,2.3);
		assertTrue(p1.equals(p2));
	}
	
	@Test
	void testCalculateLength() {
		Position p1=new Position(1.0,1.0);
		Position p2=new Position(2.0,2.0);
		assertTrue(calculateLength(p1,p2)==Math.sqrt(2));
	}


	private double calculateLength(Position p1, Position p2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
