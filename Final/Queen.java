public class Queen extends Piece {

private char p = 'Q';
private Rook dummyRook;
private Bishop dummyBishop;
private int value=9;
private boolean white;
public Queen (int i, int j, boolean w){
	this.setX(i);
	this.setY(j);
	dummyRook = new Rook(i,j,w);
	dummyBishop = new Bishop(i,j,w);
	this.setW(w);
	}
	
public Queen (int i, int j,boolean w, boolean h){
	super(i,j,w,h);
	dummyRook = new Rook(i,j,w,h);
	dummyBishop = new Bishop(i,j,w,h);
}
public int getValue(){
	return this.value;
	}
	
public boolean canMove(int x, int y){
	//the first if statement checks if its moving like a rook or bishop

	//boolean dummy1Move=this.dummyRook.canMove(x,y);
	//boolean dummy2Move=this.dummyBishop.canMove(x,y);
	//System.out.println(dummyRook.getX()+","+dummyRook.getY());
	//System.out.println(dummyBishop.getX()+","+dummyBishop.getY());
	int n =0;
	if (x==this.getX()||y==this.getY()){
	int k =0;
	if (x==this.getX()){
		k=Math.abs(this.getY()-y);
		if (y>this.getY()){
			for (int i=this.getY()+1; i<y;i++){
				//if (Board.chessBoard.get(x).get(i)!=null){
				//	return false;
				//	}
				if (Board.idiot.get(x).get(i)==null){
					n+=1;
				}
				
			}
			
		}
		
		else if (y<this.getY()){
				for (int i=this.getY()-1; i>y;i--){
					//if (Board.chessBoard.get(x).get(i)!=null){
					//	return false;
					//	}
					if (Board.idiot.get(x).get(i)==null){
						n+=1;
						}
					
					}
		}
	}
			
	else if (y==this.getY()){
		k=Math.abs(this.getX()-x);
		if (x>this.getX()){
		for (int i=this.getX()+1;i<x;i++){
			//if (Board.chessBoard.get(i).get(y)!=null){
			//	return false;
			//	}
			if (Board.idiot.get(i).get(y)==null){
				n+=1;
				}
			}
		
		}
		else if (x<this.getX()){
			for (int i=this.getX()-1;i>x;i--){
			//if (Board.chessBoard.get(i).get(y)!=null){
			//	return false;
			//	}
			if (Board.idiot.get(i).get(y)==null){
				n+=1;
				}
			}
			
			}
	}
	if (Board.idiot.get(x).get(y)==null){
					n+=1;
				}
	else if (Board.idiot.get(x).get(y)!=null){
		if (Board.idiot.get(x).get(y).getW()!=this.getW()){
						n+=1;
		}
	}
	//else {return false;}
	if (n==k){
		return true;
		}
	else return false;
	}
	
	
	else {
	int extra=1;
	if (x>this.getX()){
		
		if (y>this.getY()&&(y-this.getY()==x-this.getX())){
			
			for (int i=this.getX();i<x-1;i++){
				//if (Board.chessBoard.get(i).get(i)!=null){
				//	return false;
				//	}
				//System.out.println(Board.chessBoard.get(x-extra).get(y+extra).getP());
				if (Board.idiot.get(this.getX()+extra).get(this.getY()+extra)==null){
					n+=1;
					
					}
					extra+=1;
				}
				
			}
		else if (y< this.getY() &&(this.getY()-y==x-this.getX())){
			for (int i=this.getX(); i<x-1;i++){
				//if (Board.chessBoard.get(i).get(i)!=null){
				//	return false;
				//	}
				
				if (Board.idiot.get(this.getX()+extra).get(this.getY()-extra)==null){
					n+=1;
					//System.out.println("hi");
					}
				extra+=1;
				}
				
			}
		}
	else if (x<this.getX()){
			if (y>this.getY()&&(y-this.getY()==this.getX()-x)){
			for (int i= x;i<this.getX()-1;i++){
				//if (Board.chessBoard.get(i).get(i)!=null){
				//	return false;
				//	}
				//System.out.println("hi");
				if (Board.idiot.get(this.getX()-extra).get(this.getY()+extra)==null){
					n+=1;
					}
				extra+=1;
				}
				
			}
		else if (y< this.getY() &&(this.getY()-y==this.getX()-x)){
			//System.out.println(Board.chessBoard.get(x).get(y));
			for (int i=x; i<this.getX()-1;i++){
				//if (Board.chessBoard.get(i).get(i)!=null){
				//	return false;
				//	}
				 if (Board.idiot.get(this.getX()-extra).get(this.getY()-extra)==null){
					n+=1;

					}
					
					extra+=1;
				}
			}
		
		}
		if (n>=0){
		if (Board.idiot.get(x).get(y)!=null){
					//System.out.println("hi");
				if (Board.idiot.get(x).get(y).getW()!=this.getW()){
						n+=1;
						}
					}
		else if (Board.idiot.get(x).get(y)==null){
			n+=1;
			}}
		//System.out.println(n);
	if (Math.abs(this.getX()-x)==Math.abs(this.getY()-y)){
		if (n==Math.abs(this.getX()-x)){return true;}
		else return false;
		}
	else return false;
	}
			}
		
	

	public char getP(){
	return p;
	}
	
	public void setEnPassant(boolean boo){
	}
	public boolean getEnPassant(){
		return false;
	}
}
