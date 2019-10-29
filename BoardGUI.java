/* Got the main source of the code through a video on Youtube
 * Reference: https://www.youtube.com/watch?v=no4m-TIX-rc
*/
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class BoardGUI extends JPanel{
	
/*Used to set the adjustment of the board frame and pick certain colors to create the chess board 
 */	
    public static void main(String[] args){
        JFrame FR = new JFrame();//Builds the frame
        FR.setSize(600,600);//Setting the size of the frame
        FR.getContentPane().add(new BoardGUI());
        FR.setLocationRelativeTo(null);// set the location to null because the adjustment of boxes is made through paint class
        FR.setBackground(Color.GRAY);//setting the background color to gray
        FR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FR.setVisible(true);// makes the board visible
    }  
   /*This method creates the chess board by first making a black board. 
    *Then later covering it with white boxes to create the full chess board
   */
 public void paint(Graphics g){
        
        g.fillRect(100, 100, 400, 400);// Makes the chess board all black
        
    //Cover some boxes in white in the chess board
        for(int i = 100; i <= 400; i+=100){
            for(int j = 100; j <= 400; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }
    //Covers the rest of the other white boxes in the chess board   
        for(int i = 150; i <= 450; i+=100){
            for(int j = 150; j <= 450; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }
    }
}