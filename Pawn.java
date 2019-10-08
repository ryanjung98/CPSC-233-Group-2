
public class Pawn extends Piece{
// INSTANCE VARIABLES
private int xpos;
private int ypos;
//CONSTRUCTORS
public Pawn (int x, int y){
this.xpos = x;
this.ypos = y;
}
public Pawn (Pawn p){
this.xpos = p.xpos;
this.ypos = p.ypos;
}
}
