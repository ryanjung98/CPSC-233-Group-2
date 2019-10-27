public class Pawn extends Piece {

private char p = 'P';
private boolean move;
private boolean hasMoved;
private boolean isW;
private boolean white;
//private int xpos;
//private int ypos;
public Pawn (int i, int j, boolean w){
	this.setX(i);
	this.setY(j);
	this.setW(w);
	//isW=Game.isW;
	}
//it is important for this class to knowif we are white or black because pawns cant move backwards!	
public boolean canMove(int x, int y){
isW=Game.isW;

	if (this.getY()==1||this.getY()==6){
		this.hasMoved =false;
		}
	else this.hasMoved=true;
//this.hasMoved = Board.turn;
//for black moves
//System.out.println(isW);
int n=0;
		if ((this.getW()==true)&&this.hasMoved==false){
			//
			if ((y==this.getY()-1 && x==this.getX() )|| (y==this.getY()-2 && x==this.getX())){
				n+=1;
				}
				
			else if (y==this.getY()-1&&x==this.getX()+1){
				if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
				
				}	
				}
			else if (y==this.getY()-1&&x==this.getX()-1){
				if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
				
				}	
				}
				
				
				}
		else if (this.getW()==true && this.hasMoved==true){
			if (y==this.getY()-1 && x==this.getX()){
				n+=1;
			}
			else if (y==this.getY()-1&&(x==(this.getX()+1))){

				if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
				}}
			else if (y==this.getY()-1&&(x==(this.getX()-1))){
					if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
					}}
			}
	
		
		
		if ((this.getW()==false)&&this.hasMoved==false){
			if ((y==this.getY()+1 && x==this.getX() )|| (y==this.getY()+2 && x==this.getX())){
				n+=1;
				}
			else if (y==this.getY()+1&&x==this.getX()+1){
				if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
				
				}	
				}
			else if (y==this.getY()+1&&x==this.getX()-1){	
					if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
				
				}	
			}}
			
			
		else if (this.getW() == false && this.hasMoved==true){
			if (y==this.getY()+1 && x==this.getX()){
				n+=1;
			}
			else if (y==this.getY()+1 && x==(this.getX()+1)){
//checks to see if the pawn can move diagonal
				if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					n+=1;
				}
			}
			else if (y==this.getY()+1&&x==(this.getX()-1)){
				if (Board.chessBoard.get(x).get(y)!=null&&Board.chessBoard.get(x).get(y).getW()!=this.getW()){
					//System.out.println("hi");
					n+=1;}
				}
		}
	
if (n>0){
	return true;
	}
else return false;
	
}	
	
public char getP(){
	return p;
	}
}
