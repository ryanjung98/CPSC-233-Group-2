import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
  
public class GUI2 extends JFrame implements MouseListener, MouseMotionListener {
	
	// Instance Variables 
    JLayeredPane layeredPane;
    JPanel chess;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    int sx,sy;
    int dx,dy;
    int x,y;
    
    //variables fed into game
   	int x1;
    int x2;
    int y1;
    int y2;
    //char Cx1;
    //char Cx2;
    
    boolean canMove;
    Board b= new Board();
    String input=" ";
   // boolean isW=true;
	//int turn=b.turn;
    String currentDirectory = System.getProperty("user.dir");
    
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
  
        chess = new JPanel();
        layeredPane.add(chess, JLayeredPane.DEFAULT_LAYER);
        chess.setLayout( new GridLayout(8, 8) );
        chess.setPreferredSize( boardSize );
        chess.setBounds(0, 0, boardSize.width, boardSize.height);
        
        boolean flag=false;
        
        for (int j = 0; j < 8; j++) {
        	if(j%2==0)
        		flag=false;
        	else if(j%2==1)
        		flag=true;
        	for(int i=0;i<8;i++){
        		JPanel square = new JPanel( new BorderLayout() );
        		chess.add( square );
        		if(flag==true)
        			square.setBackground( i % 2 == 0 ? Color.black : Color.white );
        		else
        			square.setBackground( i % 2 == 0 ? Color.white : Color.black );
            	}
        }
        //Add the black pieces to the board
        
        //java.net.URL imgURL = getClass().getClassLoader().getResource(BR);
     
        JLabel piece = new JLabel( new ImageIcon(currentDirectory+"/BR.gif") );
        JPanel panel = (JPanel)chess.getComponent(0);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BN.gif"));
        panel = (JPanel)chess.getComponent(1);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BB.gif"));
        panel = (JPanel)chess.getComponent(2);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BQ.gif"));
        panel = (JPanel)chess.getComponent(3);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BK.gif"));
        panel = (JPanel)chess.getComponent(4);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BB.gif"));
        panel = (JPanel)chess.getComponent(5);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BN.gif"));
        panel = (JPanel)chess.getComponent(6);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BR.gif"));
        panel = (JPanel)chess.getComponent(7);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(8);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(9);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(10);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(11);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(12);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(13);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(14);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/BP.gif"));
        panel = (JPanel)chess.getComponent(15);
        panel.add(piece);

       // Add white pieces to the Board
        
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(48);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(49);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(50);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(51);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(52);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(53);
        panel.add(piece);
        piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(54);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WP.gif"));
        panel = (JPanel)chess.getComponent(55);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WR.gif"));
        panel = (JPanel)chess.getComponent(56);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WR.gif"));
        panel = (JPanel)chess.getComponent(63);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WN.gif"));
        panel = (JPanel)chess.getComponent(57);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WN.gif"));
        panel = (JPanel)chess.getComponent(62);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WB.gif"));
        panel = (JPanel)chess.getComponent(58);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WB.gif"));
        panel = (JPanel)chess.getComponent(61);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WK.gif"));
        panel = (JPanel)chess.getComponent(60);
        panel.add(piece);
        panel.add(piece);piece = new JLabel(new ImageIcon(currentDirectory+"/WQ.gif"));
        panel = (JPanel)chess.getComponent(59);
        panel.add(piece);
        
    }
    
    public void mousePressed(MouseEvent e){
        chessPiece = null;
        Component c =  chess.findComponentAt(e.getX(), e.getY());
        x=e.getX();
        y=e.getY();
 
        //sx=source x
 
        sx=(e.getX())/75;   
        sy=(e.getY())/75;
        
        x1=sx;
        y1=sy;
      
 
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
    		
    		x2=dx;
    		y2=dy;
    		
    	
		input = this.toString(x1,y1,x2,y2);
		//System.out.println(x1+","+y1+","+x2+","+y2);
		canMove=b.scanBoard(input);
			//System.out.println(canMove);
    		//Here d main logic comes
 
    		if(canMove == true)
    		{
				//System.out.println(x1+","+y1);
    			chessPiece.setVisible(false);
    			Component c =  chess.findComponentAt(e.getX(), e.getY());
				//turn+=1;
    			if (c instanceof JLabel){
    				Container parent = c.getParent();
    				parent.remove(0);
    				parent.add(chessPiece);
    			}
    			else {
    				Container parent = (Container)c;
    				parent.add( chessPiece );
     
    			}
    			chessPiece.setVisible(true);

    		}
    		else {
				//chessPiece.setLocation(x1,y1);
    			chessPiece.setLocation(x+xAdjustment, y+yAdjustment);
    			}
	
    	        
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
     
     public String toString(int i, int j, int k , int l){
	char x1='A';
	char x2='A';
		if (i==0){x1='A';}
							else if (i==1){x1='B';}
							else if (i==2){x1='C';}
							else if (i==3){x1='D';}
							else if (i==4){x1='E';}
							else if (i==5){x1='F';}
							else if (i==6){x1='G';}
							else if (i==7){x1='H';}
								if (k==0){x2='A';}
							else if (k==1){x2='B';}
							else if (k==2){x2='C';}
							else if (k==3){x2='D';}
							else if (k==4){x2='E';}
							else if (k==5){x2='F';}
							else if (k==6){x2='G';}
							else if (k==7){x2='H';}
	System.out.println( x1+Integer.toString(j)+','+x2+Integer.toString(l));
	return x1+Integer.toString(7-j)+','+x2+Integer.toString(7-l);
	}



}


