import java.util.Scanner;
public class Game {
	
//INSTANCE VARIABLES 
public static int turn;
public static boolean isW;
public static int type;
public static void main (String[] args){
	int game2Loop=0;
	boolean game=true;
	boolean game1=false;
	boolean game2=false;
	boolean game3=false;
	boolean canMove;
	Board b = new Board();
	//System.out.println(b.chessBoard.size());
	AI AI_game3W=new AI(true);
	AI AI_game3B=new AI(false);
	AI AI_game2= new AI(false);
	String playerColor="";
	String move="";
	String player = "";
	turn =b.getTurn();

	b.printBoard();
	System.out.println("Which type of Game would you like to play");
	System.out.println("(1) Player v.s Player");
	System.out.println("(2) Player v.s AI");
	System.out.println("(3) AI v.s AI");
	Scanner keyboard1=new Scanner(System.in);
	String GameType = keyboard1.nextLine();
	type=Integer.parseInt(Character.toString(GameType.charAt(0)));
	if (type==1){game1=true;}
	else if (type==2){
		game2=true;
		while (game2Loop==0){
		System.out.println("Which color would you like to play? Black or White?");
		Scanner keyboard3=new Scanner(System.in);
		playerColor = keyboard3.nextLine();
		if (playerColor.equals("black")|| playerColor.equals("white") || playerColor.equals("Black") || playerColor.equals("White")){
			//System.out.println(playerColor);
			game2Loop+=1;
			if (playerColor.equals("black") || playerColor.equals("Black"))
			{AI_game2=new AI(true);}
			
}
		}
		}
	else if (type==3){game3=true;}
	//only for player vs player
	while (game==true){
		if (turn % 2 ==0)
		{
			isW=false;
			if (game2==true){
				if (playerColor.equals("White")||playerColor.equals("white")){
					player="AI";
					}
				else {player="Player";}
				}
			else if (game1==true){player = "P2";}
			else if (game3==true){player = "AI2";}
			}
		else 
		{
		isW=true;
		if (game2==true){
			if (playerColor.equals("Black")||playerColor.equals("black")){
				player="AI";
				}
			else {player="Player";}
			}
		else if (game1==true){player = "P1";}	
		else if (game3==true){player="AI1";}
		}
		
	canMove=false;
	while(canMove==false){
	if (game1==true||(game2==true && player!="AI")){
	System.out.println(player + " please enter your move: ");
	Scanner keyboard2=new Scanner(System.in);
	move=keyboard2.nextLine();}
	
	else if (game2==true&&player=="AI"){
		//System.out.println(player+" made a Move! Your turn!");
		move=AI_game2.NextMove();
		}
	else if (game3==true&&isW==true){
		//System.out.println("AI Player 1 is deciding where to move");
		//Thread.sleep(3000);
		move=AI_game3W.NextMove();
		}
	else if (game3==true && isW==false){
		//System.out.println("AI Player 2 is deciding where to move");
		////Thread.sleep(3000);
		move=AI_game3B.NextMove();
		}
		//System.out.println(move);
	canMove=b.scanBoard(move);
	
	// if (b.isCheck(Board.chessBoard)){
		// System.out.println("Youre in Check, Try again!");
		// System.out.println("Youre in Check!");
		// }
	if (canMove){
	turn+=1;
	b.printBoard();
	try {java.util.concurrent.TimeUnit.SECONDS.sleep(2);}
	catch(Exception e){}
	b.toggleEnPassant(turn);//invokes method in Board class used to switch all enpassant of players pawns to false if it is now their turn
	}
	else {System.out.println("Invalid move, Try again!");}
	}
	if(b.isMate){
		System.out.println("Checkmate");
		game=false;
	}
	}
	
   }
   

}
