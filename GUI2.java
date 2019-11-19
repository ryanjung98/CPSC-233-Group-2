import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
  
public class GUI2 extends JFrame implements MouseListener, MouseMotionListener {
	
	// Instance Variables 
	
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    int sx,sy;
    int dx,dy;
    int x,y;
    
    //Constructor
    
    public GUI2(){
        Dimension boardSize = new Dimension(600, 600);
  
        //Use a Layered Pane for this this application
        
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
 
        //Add a chess board to the Layered Pane 
  
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        
        boolean flag=false;
        
        for (int j = 0; j < 8; j++) {
        	if(j%2==0)
        		flag=false;
        	else if(j%2==1)
        		flag=true;
        	for(int i=0;i<8;i++){
        		JPanel square = new JPanel( new BorderLayout() );
        		chessBoard.add( square );
        		if(flag==true)
        			square.setBackground( i % 2 == 0 ? Color.black : Color.white );
        		else
        			square.setBackground( i % 2 == 0 ? Color.white : Color.black );
            	}
        }
        //Add the black pieces to the board

        JLabel piece = new JLabel( new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BR.gif") );
        JPanel panel = (JPanel)chessBoard.getComponent(0);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BN.gif"));
        panel = (JPanel)chessBoard.getComponent(1);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BB.gif"));
        panel = (JPanel)chessBoard.getComponent(2);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BQ.gif"));
        panel = (JPanel)chessBoard.getComponent(3);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BK.gif"));
        panel = (JPanel)chessBoard.getComponent(4);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BB.gif"));
        panel = (JPanel)chessBoard.getComponent(5);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BN.gif"));
        panel = (JPanel)chessBoard.getComponent(6);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BR.gif"));
        panel = (JPanel)chessBoard.getComponent(7);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(8);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(9);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(10);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(11);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(12);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(13);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(14);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/BP.gif"));
        panel = (JPanel)chessBoard.getComponent(15);
        panel.add(piece);

       // Add white pieces to the Board
        
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(48);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(49);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(50);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(51);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(52);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(53);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(54);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WP.gif"));
        panel = (JPanel)chessBoard.getComponent(55);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WR.gif"));
        panel = (JPanel)chessBoard.getComponent(56);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WR.gif"));
        panel = (JPanel)chessBoard.getComponent(63);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WN.gif"));
        panel = (JPanel)chessBoard.getComponent(57);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WN.gif"));
        panel = (JPanel)chessBoard.getComponent(62);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WB.gif"));
        panel = (JPanel)chessBoard.getComponent(58);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WB.gif"));
        panel = (JPanel)chessBoard.getComponent(61);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WK.gif"));
        panel = (JPanel)chessBoard.getComponent(60);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon("/Users/mo_mahgoub99/Desktop/ChessGroup/ChessGame/art/pieces/plain/WQ.gif"));
        panel = (JPanel)chessBoard.getComponent(59);
        panel.add(piece);
        
    }
    
    public void mousePressed(MouseEvent e){
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
        x=e.getX();
        y=e.getY();
 
        //sx=source x
 
        sx=(e.getX())/75;   
        sy=(e.getY())/75;
 
        if (c instanceof JPanel) 
        	return;
  
        	Point parentLocation = c.getParent().getLocation();
        	xAdjustment = parentLocation.x - e.getX();
        	yAdjustment = parentLocation.y - e.getY();
        	chessPiece = (JLabel)c;
        	chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        	chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        	layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    	}
    
    	//Move the chess piece around
     
    	public void mouseDragged(MouseEvent me) {
    		if (chessPiece == null) return;
    		chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    	}
      
    	//Drop the chess piece back onto the chess board
  
    	public void mouseReleased(MouseEvent e) {
    		if(chessPiece == null) return;
  
    		//dx= destination x     
 
    		dx=(e.getX())/75;
 
       
    		dy=(e.getY())/75;
 
    		//Here d main logic comes
 
    		if((sx==dx) || (sy==dy))
    		{
    			chessPiece.setVisible(false);
    			Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
 
    			if (c instanceof JLabel){
    				Container parent = c.getParent();
    				parent.remove(0);
    				parent.add( chessPiece );
    			}
    			else {
    				Container parent = (Container)c;
    				parent.add( chessPiece );
     
    			}
    			chessPiece.setVisible(true);
 
    		}
    		else
    			chessPiece.setLocation(x + xAdjustment, y + yAdjustment);
 
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
        JFrame frame = new GUI2();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
     }
}