import java.util.ArrayList;
import java.util.*;
import java.lang.StringBuilder;
public class Board {
  private ArrayList<String> boardPrint= new ArrayList<String>();
  public static ArrayList <ArrayList <Piece>> chessBoard = new ArrayList<ArrayList<Piece>>();
  private boolean onBoard;
  public static int turn; 
  public boolean whichKing;
	
	
 //constructor that builds initial string and array chess boards 
 public Board(){
	
	 ArrayList<String> line= new ArrayList<String>();
   line.add("                                                    ");
   line.add("      A     B     C     D     E     F     G     H   ");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("7  #  R  #  N  #  B  #  Q  #  K  #  B  #  N  #  R  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("6  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("5  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("4  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("3  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("2  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("1  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("0  #  R  #  N  #  B  #  Q  #  K  #  B  #  N  #  R  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");

   for (String s : line){
	   boardPrint.add(s);
	   }
	   
//initializes chessBoard to have all spots filled with null

for (int i=0;i<8;i++){
	chessBoard.add(new ArrayList<Piece>());
	for (int j=0;j<8;j++){
		chessBoard.get(i).add(j,null);
		}
	}
	   //rooks
   chessBoard.get(0).set(0,new Rook (0,0,false));
   chessBoard.get(0).set(7,new Rook (0,7,true));
   chessBoard.get(7).set(0,new Rook (7,0,false));
   chessBoard.get(7).set(7,new Rook (7,7,true));
   
   //knights
     chessBoard.get(1).set(0,new Knight (1,0,false));
   chessBoard.get(1).set(7,new Knight(1,7,true));
   chessBoard.get(6).set(0,new Knight (6,0,false));
   chessBoard.get(6).set(7,new Knight(6,7,true));

   
   //Bishops
   chessBoard.get(2).set(0,new Bishop (2,0,false));
   chessBoard.get(2).set(7,new Bishop(2,7,true));
   chessBoard.get(5).set(0,new Bishop (5,0,false));
   chessBoard.get(5).set(7,new Bishop(5,7,true));
   
   
   //Queens
   chessBoard.get(3).set(0,new Queen(3,0,false));
    chessBoard.get(3).set(7,new Queen(3,7,true));
   
   //Kings
      chessBoard.get(4).set(0,new King(4,0,false));
    chessBoard.get(4).set(7,new King(4,7,true));
   
   //pawns
   
   for(int i=0; i<8;i++){
	   chessBoard.get(i).set(1,new Pawn(i,1,false));
	   chessBoard.get(i).set(6,new Pawn(i,6,true));
	   }
   
   }
   // loops through arraylist and prints board
   public void printBoard (){
	  // System.out.println("\033[H\033[2J");
	   for (String s : boardPrint){
	   System.out.println(s);}
	   }
	   
	//parameter is string which is in the format "A2,B2"
	public boolean scanBoard (String s){
		this.turn=Game.turn;
		boolean move;
		boolean check;
		int tester=0;
		int i = 0;
		int k = 0;
		int l = 0;
		int j = 0;
		//String [] spl = s.split(",",2);
		char x1 = s.charAt(0);
		char y1 = s.charAt(1);
		char x2 = s.charAt(3);
		char y2 = s.charAt(4);
		char piece;
		//chessBoard indicies of pieces 
		
		
		i=this.getXFromChar(x1);
		j=this.getXFromChar(x2);
		l=this.getYFromChar(y1);
		k=this.getYFromChar(y2);
		
		//converting string indicies to array indicies
		int Cx1=(i/6)-1;
		int Cx2=(j/6)-1;
		int Cy1=(l/4)-1;
		int Cy2=(k/4)-1;
		
		
		//doesnt matter whether we get the piece from the string board or the piece board because we will update after each turn 
		piece = this.getPiece(i,l);
		
	
		if ((Cx1<0||Cx1>7)||(Cx2<0||Cx2>7)||(Cy1<0||Cy1>7)||(Cy2<0||Cy2>7)){
			move=false;
			
			//tester+=1;
			}
			
		else{
		move=getPieceMove(Cx1,Cy1,Cx2,Cy2);
		
		System.out.println(Cx1+","+Cy1+","+Cx2+","+Cy2);
		}
		//System.out.println(move);
		if (move==true){
			
			check=isCheck(isGoingToBeInCheck(Cx1,Cy1,Cx2,Cy2));
			System.out.println(check+","+chessBoard.get(Cx1).get(Cy1).getW()+","+this.whichKing);
			//System.out.println("hi");
			if (check==true&& this.whichKing==chessBoard.get(Cx1).get(Cy1).getW()){
				System.out.println("offboard");
				move=false;
				}
			else if (check==false||(check==true&&this.whichKing!=chessBoard.get(Cx1).get(Cy1).getW())){
			chessBoard.get(Cx1).get(Cy1).setX(Cx2);
			chessBoard.get(Cx1).get(Cy1).setY(Cy2);
			chessBoard.get(Cx2).set(Cy2,chessBoard.get(Cx1).get(Cy1));
			chessBoard.get(Cx1).set(Cy1,null);}
			this.updateBoardFromArray();
			}
		//System.out.println(move);
		
		return move;
	}
		
//this method returns true if piece p in x1,y1 can move to x2,y2, and false if not.	
public boolean getPieceMove(int x1, int y1, int x2, int y2){
	boolean move;
	
		move = chessBoard.get(x1).get(y1).canMove(x2,y2);
		//ASystem.out.println(chessBoard.get(x1).get(y1).getX()+","+chessBoard.get(x1).get(y1).getY());
		//System.out.println(chessBoard.get(x1).get(y1).getP());
		return move;
		}
	
// this method will update the board printed to the console from the piece array 	
public void updateBoardFromArray(){
	char piece;
	String line;
	String temp;
	for (int i=0; i<chessBoard.size();i++){
		for (int j=0; j<chessBoard.get(i).size();j++){
			if (chessBoard.get(i).get(j)== null){
				line = boardPrint.get(4*(j+1));
				temp = line.substring(0,6*(i+1))+' '+line.substring(6*(i+1)+1);
				boardPrint.set(4*(j+1),temp);
				}
			else{
				piece=chessBoard.get(i).get(j).getP();
				line = boardPrint.get(4*(j+1));
				temp = line.substring(0,6*(i+1))+piece+line.substring(6*(i+1)+1);
				boardPrint.set(4*(j+1),temp);
				}
			
			}
		}
	
	}
	
//this returns the integer index of x from the string board
public int getXFromChar(char x){
int i=0;
for (char letter: boardPrint.get(1).toCharArray()){
					if (letter==x){
						i=boardPrint.get(1).indexOf(letter);}}
		return i;
		}
	
//this returns the integer index of y from the string board
public int getYFromChar(char y){
	int i=0;
	int n=0;
	for (String line : boardPrint){
		if ( line.startsWith(Character.toString(y))){
			n=i;
			}
		i+=1;
		}
	return n;
	}
	
//this returns the character of the piece n from the string array
public char getPiece(int x, int y){
	char piece = boardPrint.get(y).charAt(x);
	return piece;		
}
//getter
public boolean getOnB(){
	return this.onBoard;
	}
	
	
//this method takes a two dimentional array list of pieces in and returns true if one of the kings is threatened by a piece of opposite color 
public boolean isCheck(ArrayList <ArrayList <Piece>> chess){
	//System.out.println(chess);
	int n = 0;
	for (int i=0; i<chess.size();i++){
		for (int j=0; j<chess.get(i).size();j++){
			if (chess.get(i).get(j)!=null){
			if (chess.get(i).get(j).getP()=='K'){
				//System.out.println("KingTest   "+chess.get(i).get(j).getW());
				//i, and j are the location of a king, so now rescan board to check if any of the players can move to i, j
				for (int k=0;k<chess.size();k++){
					for (int l=0; l<chess.get(k).size();l++){
						if (chess.get(k).get(l)!=null){
							if (chess.get(i).get(j).getW()!=chess.get(k).get(l).getW()){
								//System.out.println("check test     "+chess.get(i).get(j).getW()+chess.get(k).get(l).getP());
								if (chess.get(k).get(l).canMove(i,j)== true){
								System.out.println(chess.get(k).get(l).getP()+","+chess.get(k).get(l).getX()+","+chess.get(k).get(l).getY()+","+chess.get(k).get(l).getW()+","+chess.get(i).get(j).getW()+","+chess.get(i).get(j).getY());
								this.whichKing = chess.get(i).get(j).getW();
								n+=1;
								}
							}
					}}
				
				
				}}
		
		}}}
		if (n>=1){
		return true;	
		}
		else return false;
	}
	
//this method takes in an initial position and a final position for a piece and returns a copy of the chessboard with the piece in x1, y1 moved to x2,y2
public ArrayList <ArrayList <Piece>> isGoingToBeInCheck(int x1, int y1, int x2, int y2){
	
	ArrayList <ArrayList <Piece>> dummy = new ArrayList<ArrayList<Piece>>();
	//initializes dummy chessboard to what it currently is 
	for (int i=0;i<8;i++){
	dummy.add(new ArrayList<Piece>());
	for (int j=0;j<8;j++){
		dummy.get(i).add(j,null);
		}
	}
	for (int i=0; i<chessBoard.size();i++){
		for (int j=0; j<chessBoard.get(i).size();j++){
			if (chessBoard.get(i).get(j)!=null){
			if (chessBoard.get(i).get(j).getP()=='P'){
				dummy.get(i).set(j,new Pawn(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW()));
				}
			else if (chessBoard.get(i).get(j).getP()=='R'){
				dummy.get(i).set(j,new Rook(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW()));
				}
			else if (chessBoard.get(i).get(j).getP()=='N'){
				dummy.get(i).set(j,new Knight(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW()));
				}
			else if (chessBoard.get(i).get(j).getP()=='B'){
				dummy.get(i).set(j,new Bishop(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW()));
				}
			else if (chessBoard.get(i).get(j).getP()=='Q'){
				dummy.get(i).set(j,new Queen(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW()));
				}
			else if (chessBoard.get(i).get(j).getP()=='K'){
				dummy.get(i).set(j,new King(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW()));
				}}
		
	}}
	dummy.get(x1).get(y1).setX(x2);
	dummy.get(x1).get(y1).setY(y2);
	dummy.get(x2).set(y2,dummy.get(x1).get(y1));
	dummy.get(x1).set(y1,null);
	printArray(dummy);
	return dummy;
}

	
//this method is used as a test, it takes in a two dimentional array and prints it to the console.
public void printArray(ArrayList <ArrayList <Piece>> chess){
	for (int i=0; i<8;i++){
		for (int j=0;j<8;j++){
			if (chess.get(i).get(j)!=null){
			System.out.println(chess.get(i).get(j).getP()+","+chess.get(i).get(j).getX()+","+chess.get(i).get(j).getY()+","+chess.get(i).get(j).getW());}
		}
		}
	
	}
}
