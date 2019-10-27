public class Queen extends Piece {

private char p = 'Q';
private Rook dummyRook;
private Bishop dummyBishop;
private boolean white;
public Queen (int i, int j, boolean w){
	this.setX(i);
	this.setY(j);
	dummyRook = new Rook(i,j,w);
	dummyBishop = new Bishop(i,j,w);
	this.setW(w);
	}
	
public boolean canMove(int x, int y){
	//the first if statement checks if its moving like a rook or knight

	boolean dummy1Move=this.dummyRook.canMove(x,y);
	boolean dummy2Move=this.dummyBishop.canMove(x,y);
	//System.out.println(dummyRook.getX()+","+dummyRook.getY());
	//System.out.println(dummyBishop.getX()+","+dummyBishop.getY());
	int n =0;
	if (x==this.getX()||y==this.getY()){
	if (dummy1Move==true){
		n+=1;
		}
	}
	else if (dummy2Move==true){
		getRookBishop();
			n+=1;
			}
		
	if (n>=1){
		if (Board.chessBoard.get(x).get(y)!= null){
		if (Board.chessBoard.get(x).get(y).getP()!='K'){
		dummyRook.setX(x);
		dummyRook.setY(y);
		dummyBishop.setX(x);
		dummyBishop.setY(y);
		}}
		else if (Board.chessBoard.get(x).get(y)==null){
		dummyRook.setX(x);
		dummyRook.setY(y);
		dummyBishop.setX(x);
		dummyBishop.setY(y);
			}
		getRookBishop();
		return true;
		}
	else return false;
}
	public char getP(){
	return p;
	}
	
	public void getRookBishop(){
		System.out.println("Queen Test");
		System.out.println(dummyRook.getX()+" Rook "+dummyRook.getY());
		System.out.println(dummyBishop.getX()+" Bishop "+ dummyBishop.getY());
		}
}
