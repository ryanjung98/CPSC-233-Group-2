/*
 * The PieceTest Class is used to test the functionality of the Piece class
*/



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PieceTest {
	
	
	/*
 * The Test method testCanMove checks to see where Any piece move, and if its allowed to move there 
*/

	
	
	@Test
	void testCanMove() {
		//assertSame(this.white,getW());
		Bishop whiteBishop1 = new Bishop(2, 3, true);
		Bishop whiteBishop2 = new Bishop(3, 4, true);
		
		assertEquals(whiteBishop1.canMove(3, 4), false);
		
	}
	
	@Test
	void testCanMoveKing()
	{
		
	King k1 = new King(3,4, false);
	
	assertEquals(k1.getW(), false);
		
		
		
	}
	
	/*
 * The testGetW checks to see if the white pieces are placed correctly on the board
*/

	
	@Test
	void testGetW()
	{
		Bishop blackBishop1 = new Bishop(2,3, false);
		assertEquals(blackBishop1.getW(),false);
	}
	
	@Test
	void testGetWRook() {
		
		Rook r1 = new Rook(0, 0, false);
		assertEquals(r1.getW(), false);
		
	}
	
	@Test 
	void testGetWRook2() {
		Rook r2 = new Rook(8, 0, true);
		assertEquals(r2.getW(), true);
		}
	
	@Test
	void testGetWPawn() {
		Pawn p1 = new Pawn(7,0, true);
		
		assertEquals(p1.getW(), true);
		
		
	}
	
	/*
 * The testGetP checks to see if the pieces are placed in their right space
*/

	
	
	@Test
	void testGetP() {
		Pawn p2 = new Pawn(0, 0, true);
		
		assertEquals(p2.getP(), 'P');
	}
	
	
	@Test 
	void testGetPK() {
		Knight k1 = new Knight(1, 1, true);
		
		assertEquals(k1.getP(), 'N');
	}
	
	@Test
	void testGetPP() {
		Pawn pp1 = new Pawn(2,2, true);
		
		assertEquals(pp1.getP(), 'P');
	}
	
	
	@Test
	void testGetPB1() {
		Bishop b1 = new Bishop(2,3, true);
		
		assertEquals(b1.getP(), 'B');
	}


	
	
	
	


}
