/* Got the main source of the code through a video on Youtube
 * Reference: https://www.youtube.com/watch?v=SNYFjgz4bU4
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
  
public class ChessBoardGui extends JFrame implements MouseListener, MouseMotionListener {
	
	// Instance Variables 
	
    JLayeredPane layeredPane;
    JPanel cB;
    JLabel cP;
    int xAdjustment;
    int yAdjustment;
    int sourceX,souceY;
    int destinationX,destinationY;
    int integerX,integerY;
    
    //Constructor
    
    public ChessBoardGui(){
        Dimension boardSize = new Dimension(600, 600);
  
        //Use a Layered Pane for this this application
        
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
 
        //Add a chess board to the Layered Pane 
  
        cB = new JPanel();
        layeredPane.add(cB, JLayeredPane.DEFAULT_LAYER);
        cB.setLayout( new GridLayout(8, 8) );
        cB.setPreferredSize( boardSize );
        cB.setBounds(0, 0, boardSize.width, boardSize.height);
        
        boolean flag=false;
        
        // This for statement creates an 8x8 array for the chess Board with 64 components and colors each one in black/white
        
        for (int j = 0; j < 8; j++) {
        	if(j%2==0)
        		flag=false;
        	else if(j%2==1)
        		flag=true;
        	for(int i=0;i<8;i++){
        		JPanel square = new JPanel( new BorderLayout() );
        		cB.add( square );
        		if(flag==true)
        			square.setBackground( i % 2 == 0 ? Color.black : Color.white );
        		else
        			square.setBackground( i % 2 == 0 ? Color.white : Color.black );
            	}
        }
        //Add and load the black pieces to the board

        JLabel piece = new JLabel( new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BR.gif") );
        JPanel panel = (JPanel)cB.getComponent(0);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BN.gif"));
        panel = (JPanel)cB.getComponent(1);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BB.gif"));
        panel = (JPanel)cB.getComponent(2);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BQ.gif"));
        panel = (JPanel)cB.getComponent(3);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BK.gif"));
        panel = (JPanel)cB.getComponent(4);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BB.gif"));
        panel = (JPanel)cB.getComponent(5);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BN.gif"));
        panel = (JPanel)cB.getComponent(6);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BR.gif"));
        panel = (JPanel)cB.getComponent(7);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(8);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(9);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(10);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(11);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(12);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(13);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(14);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)cB.getComponent(15);
        panel.add(piece);

       // Add and load the white pieces to the Board
        
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(48);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(49);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(50);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(51);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(52);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(53);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(54);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)cB.getComponent(55);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WR.gif"));
        panel = (JPanel)cB.getComponent(56);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WR.gif"));
        panel = (JPanel)cB.getComponent(63);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WN.gif"));
        panel = (JPanel)cB.getComponent(57);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WN.gif"));
        panel = (JPanel)cB.getComponent(62);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WB.gif"));
        panel = (JPanel)cB.getComponent(58);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WB.gif"));
        panel = (JPanel)cB.getComponent(61);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WK.gif"));
        panel = (JPanel)cB.getComponent(60);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WQ.gif"));
        panel = (JPanel)cB.getComponent(59);
        panel.add(piece);
        
    }
    
    // The mousePressed method is called once after every time a mouse button is pressed
    
    public void mousePressed(MouseEvent e){
        cP = null;
        Component c =  cB.findComponentAt(e.getX(), e.getY());
        integerX=e.getX();
        integerY=e.getY();
 
  
        sourceX=(e.getX())/75;   
        souceY=(e.getY())/75;
 
        if (c instanceof JPanel) 
        	return;
  
        	Point parentLocation = c.getParent().getLocation();
        	xAdjustment = parentLocation.x - e.getX();
        	yAdjustment = parentLocation.y - e.getY();
        	cP = (JLabel)c;
        	cP.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        	cP.setSize(cP.getWidth(), cP.getHeight());
        	layeredPane.add(cP, JLayeredPane.DRAG_LAYER);
    	}
    
    	//The mouseDragged method moves the chess piece around
     
    	public void mouseDragged(MouseEvent me) {
    		if (cP == null) return;
    		cP.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    	}
      
    	// The mouseReleased Method Drops the chess piece back onto the chess board
  
    	public void mouseReleased(MouseEvent e) {
    		if(cP == null) return;
  
    		 
 
    		destinationX=(e.getX())/75;
 
       
    		destinationY=(e.getY())/75;
 
    		//Here is where the main destination logic comes
 
    		if((sourceX==destinationX) || (souceY==destinationY))
    		{
    			cP.setVisible(false);
    			Component c =  cB.findComponentAt(e.getX(), e.getY());
 
    			if (c instanceof JLabel){
    				Container parent = c.getParent();
    				parent.remove(0);
    				parent.add( cP );
    			}
    			else {
    				Container parent = (Container)c;
    				parent.add( cP );
     
    			}
    			cP.setVisible(true);
 
    		}
    		else
    			cP.setLocation(integerX + xAdjustment, integerY + yAdjustment);
 
    	}        
 
    public void mouseClicked(MouseEvent e) {
   
    }
    public void mouseMoved(MouseEvent e) {
   }
    public void mouseEntered(MouseEvent e){
   
    }
    public void mouseExited(MouseEvent e) {
   
    }
  
 
   public static void main(String[] args) {
        JFrame frame = new ChessBoardGui(); //Builds the frame
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true); // makes the board visible
     }
}