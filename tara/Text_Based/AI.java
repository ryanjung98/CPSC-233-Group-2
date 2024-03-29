public class AI extends Board{
	
private boolean color;

public AI(boolean color){
	super(1);
	this.color = color;
	}
public void setColor(boolean col){
	this.color=col;
	}

public String NextMove(){
	char piece=' ';
	int pieceValue=0;
	int xpos=0;
	int ypos=0;
	int threatx=0;
	int threaty=0;
	int counter=0;
	int count2=0;
	String move = "";
	//AI cannot use i,j,k,l 
	//gets position of our king if hes in check
	if (super.isCheck(super.chessBoard)){
		
		for (int it1=0;it1<super.chessBoard.size();it1++){
			for (int jt1=0 ;jt1<super.chessBoard.get(it1).size();jt1++){
				if (super.chessBoard.get(it1).get(jt1)!=null&&super.chessBoard.get(it1).get(jt1).getP()=='K'&& super.chessBoard.get(it1).get(jt1).getW()==this.color){
					xpos=it1;
					ypos=jt1;
					}
				}
			
			
			}
	//finds players on opposing teams that are threatening us, first sees if any of our players can take that piece, 
	//then if not sees if any one player can move so that the board is no longer in check. 	
		for (int it2=0;it2<super.chessBoard.size();it2++){
			for (int jt2=0 ;jt2<super.chessBoard.get(it2).size();jt2++){
				if (super.chessBoard.get(it2).get(jt2)!=null&&super.chessBoard.get(it2).get(jt2).canMove(xpos,ypos)&&super.chessBoard.get(it2).get(jt2).getW()!=this.color){
					threatx=it2;
					threaty=jt2;
					}}}
		for (int it3=0;it3<super.chessBoard.size();it3++){
			for (int jt3=0; jt3<super.chessBoard.get(it3).size();jt3++){
				if (super.chessBoard.get(it3).get(jt3)!=null&&super.chessBoard.get(it3).get(jt3).canMove(threatx,threaty)&&super.isCheck(super.isGoingToBeInCheck(it3,jt3,threatx,threaty))==false&&super.chessBoard.get(it3).get(jt3).getW()==this.color){
						move=this.toString(it3,jt3,threatx,threaty);
								count2+=1;
								//System.out.println(it3+","+jt3+","+it2+","+jt2);
								//System.out.println(move);
								
								}}}
		if (count2==0){
								
					 for (int it4=0;it4<super.chessBoard.size();it4++){
						for (int jt4=0 ;jt4 < super.chessBoard.get(it4).size();jt4++){
							if (super.chessBoard.get(it4).get(jt4)!=null&&super.chessBoard.get(it4).get(jt4).getW()==this.color){
								for (int it5=0;it5<super.chessBoard.size();it5++){
									for (int jt5=0;jt5<super.chessBoard.get(it5).size();jt5++){
										if (super.chessBoard.get(it4).get(jt4).canMove(it5,jt5)&&super.isCheck(super.isGoingToBeInCheck(it4,jt4,it5,jt5))==false){
										System.out.println("test");
										move=this.toString(it4,jt4,it5,jt5);
										//count2+=1;
									//	System.out.println(it3+","+jt3+","+it4+","+jt4);
										//System.out.println(super.chessBoard.get(it3).get(jt3).canMove(it4,jt4));
										}
										
										}
									
									}
								}
									//System.out.println(super.chessBoard.get(it3).get(jt3).canMove(it4,jt4)+","+super.isCheck(super.isGoingToBeInCheck(it3,jt3,it4,jt4))+","+super.chessBoard.get(it3).get(jt3).getP()+","+it3+","+jt3+","+it4+","+jt4);
							
									
									}
								
								
								
								
							
							
						
						}
			
				
				}
		}
	else{
//System.out.println("test");
	for (int it1 =0; it1< super.chessBoard.size();it1++){
		for (int jt1=0;jt1<super.chessBoard.get(it1).size();jt1++){
			if (super.chessBoard.get(it1).get(jt1)!=null&&super.chessBoard.get(it1).get(jt1).getW()==this.color){
				for (int it2=0; it2<super.chessBoard.size();it2++){
					for (int jt2=0; jt2<super.chessBoard.get(it2).size();jt2++){
						if (super.chessBoard.get(it2).get(jt2)!=null&&super.chessBoard.get(it1).get(jt1).canMove(it2,jt2)==true&&super.chessBoard.get(it2).get(jt2).getW()!=this.color &&super.isCheck(isGoingToBeInCheck(it1,jt1,it2,jt2))==false&&super.chessBoard.get(it2).get(jt2).getValue()>pieceValue){
							move=this.toString(it1,jt1,it2,jt2);
							//System.out.println(super.chessBoard.get(it1).get(jt1).canMove(it2,jt2));
							pieceValue=super.chessBoard.get(it2).get(jt2).getValue();
							
						}
							}
						}
					}
				}
			}
		
	if (pieceValue==0){
		for (int it3 =0; it3< super.chessBoard.size();it3++){
		for (int jt3=0;jt3<super.chessBoard.get(it3).size();jt3++){
		if (super.chessBoard.get(it3).get(jt3)!=null&&super.chessBoard.get(it3).get(jt3).getW()==this.color&&super.chessBoard.get(it3).get(jt3).getP()=='P'){
			if (super.chessBoard.get(it3).get(jt3).getX()==3||super.chessBoard.get(it3).get(jt3).getX()==4){
				for (int kk=0;kk<8;kk++){
					for (int ll=0;ll<8;ll++){
						if (super.chessBoard.get(it3).get(jt3).canMove(kk,ll)&&super.isCheck(isGoingToBeInCheck(it3,jt3,kk,ll))==false){
							move=this.toString(it3,jt3,kk,ll);
							counter+=1;
						//	break();
							}
						}
					}
			if (counter==0&&(super.chessBoard.get(it3).get(jt3).getX()==2||super.chessBoard.get(it3).get(jt3).getX()==5)){
				for (int kkk=0;kkk<8;kkk++){
					for (int lll=0;lll<8;lll++){
						if (super.chessBoard.get(it3).get(jt3).canMove(kkk,lll)&&super.isCheck(isGoingToBeInCheck(it3,jt3,kkk,lll))==false){
							move=this.toString(it3,jt3,kkk,lll);
							counter+=1;
				}}}
				}
				
				}
				}
			
			}
		}
		}
	 if ((pieceValue==0)&&counter==0){
		for (int ii=0; ii< super.chessBoard.size();ii++){
			for (int jj=0;jj<super.chessBoard.get(ii).size();jj++){
				if (super.chessBoard.get(ii).get(jj)!=null&&super.chessBoard.get(ii).get(jj).getW()==this.color){
					for (int k4=0;k4<8;k4++){
					for (int l4=0;l4<8;l4++){
						if (super.chessBoard.get(ii).get(jj).canMove(k4,l4)&&super.isCheck(isGoingToBeInCheck(ii,jj,k4,l4))){
							move=this.toString(ii,jj,k4,l4);
							}
						
						}}
					}
				}
			}
		
		}}
		
		
	System.out.println(move);
	return move;
	
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
	//System.out.println( x1+Integer.toString(j)+','+x2+Integer.toString(l));
	return x1+Integer.toString(7-j)+','+x2+Integer.toString(7-l);
	}

}
