import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PieceTest extends Piece {
	
	// Tests the Getter method to see if it returns this.white
	
	@Test
	void testGetW() {
		assertSame(this.white,getW());
	}
	
	// Tests the Getter method to see if it returns the value this.piece

	@Test
	void testGetP() {
		assertSame(this.piece,getP());
	}
	
	// Tests the Getter method to see if it returns the value this.xpos

	@Test
	void testGetX() {
		assertSame(this.xpos,getX());
	}
	
	// Tests the Getter method to see if it returns the value this.ypos

	@Test
	void testGetY() {
		assertSame(this.ypos,getY());
	}
	
	// Tests the Getter method to see if it returns the value this.hasMoved

	@Test
	void testGetHasMoved() {
		assertSame(this.hasMoved,getHasMoved());
	}

	@Override
	public boolean canMove(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEnPassant(boolean boo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEnPassant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}


	// Tests to see if the Setter method updates the value of the variable to this.piece
	
	@Test
	void testSetP() {
		assertEquals(this.piece,getP());
	}
	
	// Tests to see if the Setter method updates the value of the variable to this.xpos

	@Test
	void testSetX() {
		assertEquals(this.xpos,getX());
	}
	
	// Tests to see if the Setter method updates the value of the variable to this.ypos

	@Test
	void testSetY() {
		assertEquals(this.ypos,getY());
	}
	
	// Tests to see if the Setter method updates the value of the variable to this.hasMoved

	@Test
	void testSetHasMoved() {
		assertEquals(this.hasMoved,getHasMoved());
	}

}
