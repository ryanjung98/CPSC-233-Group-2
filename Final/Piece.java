import java.lang.Math;
public abstract class Piece {//Parent class for all the types of chess pieces
  //INSTANCE VARIABLES
  private boolean white; //boolean for if white or black
  private int xpos; private int ypos; //positions of piece between 1 and 8
  private char piece; //character used to represent the piece in text based game
  private boolean hasMoved; //indicates if the piece has moved yet
  
  //CONSTRUCTORS
  public Piece(char p){
   this.piece = p;
  }
  public Piece(Piece p){//copy constructor
   this.piece = p.piece;
  }
  public Piece(int x, int y, boolean w){//constructor taking x and y positions boolean indicating if the piece is white
	  this.xpos=x;
	  this.ypos=y;
	  this.white=w;
	  this.hasMoved=false;
	  }
	  public Piece(int x, int y, boolean w, boolean h){//constructor does the same as above but also considers if the piece has moved
	  this.xpos=x;
	  this.ypos=y;
	  this.white=w;
	  this.hasMoved=h;
	  }
	  
	public Piece(){//default constructor
		}

	  
//GETTER METHODS

public abstract int getValue();//will return the value of the piece. Used for the AI

public abstract boolean canMove(int i, int j);//This method will contain the logic required to determine if the piece can be moved to the spot i,j from it's current position
public abstract void setEnPassant(boolean boo);//This method is used to set whether or not a piece can be taken by En Passant
public abstract boolean getEnPassant();//Checks if a piece can be taken by En Passant

public boolean getW(){//Returns if the piece is white
	return this.white;
	}
	public char getP(){//Returns the character representing the type of the piece
		return this.piece;
		}
public int getX(){//Returns X position
	return this.xpos;
	}  
	
public int getY(){//Returns Y position
	return this.ypos;
	}
public boolean getHasMoved(){//Returns if the piece has moved or not
	return this.hasMoved;
}
//SETTER METHODS	
public void setW(boolean t){//Sets color of the piece
	this.white=t;
	}
public void setP(char p){//Sets character of the piece
	this.piece = p;
	
	}
public void setX(int x){//Sets X position
	this.xpos = x;
	}
public void setY(int y){//Sets Y position
	this.ypos = y;
	}
public void setHasMoved(boolean hasMoved){//Sets if the piece has moved or not
	this.hasMoved=hasMoved;
}
}
