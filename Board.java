import java.util.ArrayList;
import java.util.*;
public class Board {
// Update board from piece movement 
// Instance variables needed: ArrayList
 // private ArrayList<Piece> pieces= new ArrayList<Piece>(32);
  private ArrayList<String> boardPrint= new ArrayList<String>();
 
 public Board(){
	String L1= "     A     B     C     D     E     F     G     H   ";
	String L2= "  #################################################";
	String L3= "  #     #     #     #     #     #     #     #     #";
	String L4= "7 #  R  #  N  #  B  #  Q  #  K  #  B  #  N  #  R  #";
	String L5= "  #     #     #     #     #     #     #     #     #";
	String L6= "  #################################################";
	String L7= "  #     #     #     #     #     #     #     #     #";
	String L8= "6 #  P  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #";
	String L9= "  #     #     #     #     #     #     #     #     #";
   String L10= "  #################################################";
   String L11= "  #     #     #     #     #     #     #     #     #";
   String L12= "5 #     #     #     #     #     #     #     #     #";
   String L13= "  #     #     #     #     #     #     #     #     #";
   String L14= "  #################################################";
   String L15= "  #     #     #     #     #     #     #     #     #";
   String L16= "4 #     #     #     #     #     #     #     #     #";
   String L17= "  #     #     #     #     #     #     #     #     #";
   String L18= "  #################################################";
   String L19= "  #     #     #     #     #     #     #     #     #";
   String L20= "3 #     #     #     #     #     #     #     #     #";
   String L21= "  #     #     #     #     #     #     #     #     #";
   String L22= "  #################################################";
   String L23= "  #     #     #     #     #     #     #     #     #";
   String L24= "2 #     #     #     #     #     #     #     #     #";
   String L25= "  #     #     #     #     #     #     #     #     #";
   String L26= "  #################################################";
   String L27= "  #     #     #     #     #     #     #     #     #";
   String L28= "1 #  P  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #";
   String L29= "  #     #     #     #     #     #     #     #     #";
   String L30= "  #################################################";
   String L31= "  #     #     #     #     #     #     #     #     #";
   String L32= "0 #  R  #  N  #  B  #  Q  #  K  #  B  #  N  #  R  #";
   String L33= "  #     #     #     #     #     #     #     #     #";
   String L34= "  #################################################";
   
   boardPrint.add(L1);
   boardPrint.add(L2);
   boardPrint.add(L3);
   boardPrint.add(L4);
   boardPrint.add(L5);
   boardPrint.add(L6);
   boardPrint.add(L7);
   boardPrint.add(L8);
   boardPrint.add(L9);
   boardPrint.add(L10);
   boardPrint.add(L11);
   boardPrint.add(L12);
   boardPrint.add(L13);
   boardPrint.add(L14);
   boardPrint.add(L15);
   boardPrint.add(L16);
   boardPrint.add(L17);
   boardPrint.add(L18);
   boardPrint.add(L19);
   boardPrint.add(L20);
   boardPrint.add(L21);
   boardPrint.add(L22);
   boardPrint.add(L23);
   boardPrint.add(L24);
   boardPrint.add(L25);
   boardPrint.add(L26);
   boardPrint.add(L27);
   boardPrint.add(L28);
   boardPrint.add(L29);
   boardPrint.add(L30);
   boardPrint.add(L31);
   boardPrint.add(L32);
   boardPrint.add(L33);
   boardPrint.add(L34);
   }
   
   public void printBoard (){
	   for (String s : boardPrint){
	   System.out.println(s);}
	   }
	public void changeBoard (String s){
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		String [] spl = s.split(",",2);
		char x1 = spl[0].charAt(0);
		char y1 = spl[0].charAt(1);
		char x2 = spl[1].charAt(0);
		char y2 = spl[1].charAt(1);
		char piece=' ';
		//String s1 = boardPrint.get(0);
		// first 2 for loops find a number accosiated to the letter for initial and final x positions
		for (char letter: boardPrint.get(0).toCharArray()){
					if (letter==x1){
						i=boardPrint.get(0).indexOf(letter);}}
		for (char letter: boardPrint.get(0).toCharArray()){
					if (letter==x2){
						j=boardPrint.get(0).indexOf(letter);}}
		//this loop replaces initial position with an empty space
		for (String line : boardPrint){
			if ( line.startsWith(Character.toString(y1))){
						piece = line.charAt(i);
						line.replace(piece,' ');
						boardPrint.set(k,line);
						System.out.println(piece);
					}
					k+=1;
					}
		//this loop replaced empty space with character in final position 
		for (String line2: boardPrint){
			if ( line2.startsWith(Character.toString(y2))){
				line2.replace(line2.charAt(j),piece);
					boardPrint.set(l,line2);
					}
					l+=1;
				}
