
public class Piece {
  //INSTANCE VARIABLES
  private boolean white; //boolean for if white or black
  private int xpos; private int ypos; //positions of piece between 1 and 8
  private boolean danger;
  
  //CONSTRUCTORS
  public Piece(boolean white, boolean danger){
    this.white=white;
    this.danger=danger;
  }
  public Piece(Piece shithead){
    white=shithead.white;
    danger=shithead.danger;
    xpos=shithead.xpos;
    ypos=shithead.ypos;
  }
  
}
