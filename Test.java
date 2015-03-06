/* 4 BIT ALU  (74181)
 * OPERATING ON ACTIVE HIGH INPUTS AND OUTPUTS.
 * Copyright  2015 DxD @ IIT(BHU) . All rights reserved.
 * Unless otherwise indicated, all codes  are copyrighted by DxD @ IIT(BHU)  All rights reserved. 
 * No part of these code, either console or graphical may be used for any purpose other than personal use. 
 * Therefore, reproduction, modification, storage in a retrieval system or retransmission, in any form or by any means, electronic, mechanical or otherwise, for reasons other than personal use, is strictly prohibited without prior written permission.
 *  -------------------------CREDIT------------------------------
 *  BIG THANKS TO ACM JTF for providing ACM Package 
 */
import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.awt.event.*;



public class Test  extends GraphicsProgram{
        @Override
	public void run() {
		
		
       defaultG();
       addMouseListeners();
		
	
	} 
	
//  --------------------------------run ending------------------------------------------------------

// default
public void defaultG(){
//  graphics
	
// -------------------------------- labelling ----------------------------------------------
		
		GLabel selection=new GLabel("Selection",x+36-bSize/2+20,y+pinSize/2-wLength-bSize-10);
		   selection.setFont("Times New Roman-20");
	       add(selection);
	       
	       
	     GLabel operandA=new GLabel("Operand - A",x+pinSize/2-wLength-bSize-110,y+Astart+3*(Aspace-pinSize/2)+pinSize/2-bSize/2+5);
	       operandA.setFont("Times New Roman-20");
	       add(operandA);
	       
	       
	     GLabel operandB=new GLabel("Operand - B",x+pinSize/2-wLength-bSize-110,y+Bstart+3*(Bspace-pinSize/2)+pinSize/2-bSize/2+5);
	       operandB.setFont("Times New Roman-20");
	       add(operandB);
	       
	     carryIn=new GLabel("C_In",x+pinSize/2-wLength-bSize-50,y+Cnstart+pinSize/2-bSize/2+15);
	       carryIn.setFont("Times New Roman-20");
	       add(carryIn);
	       
	       
	     GLabel modeCI=new GLabel("Mode",x+pinSize/2-wLength-bSize-55,y+Mstart+pinSize/2-bSize/2+15); //mode control input
		       modeCI.setFont("Times New Roman-20");
		       add(modeCI);
		 GLabel modeCID=new GLabel("(H=Logic & L=Arithmetic)",x+pinSize/2-wLength-bSize-70,y+Mstart+pinSize/2-bSize/2+40);
		       add(modeCID);
		       
		carryOut=new GLabel("C_Out ",x+chipWidth-pinSize/2+wLength+bSize+10,y+Cn4start+pinSize/2-bSize/2+15); //mode control input
		       carryOut.setFont("Times New Roman-20");
		       
		       
		 carryOutD=new GLabel("( H = No Carry Out )",x+chipWidth-pinSize/2+wLength+bSize+10,y+Cn4start+pinSize/2-bSize/2+15+20);
		    
		       
		       
		     
		
		       
         // --------------------   BCD display
		       
		       
		       rBCD=new GRect(620,300,80,120);
		       rBCD.setFilled(true);
		       rBCD.setFillColor(Color.pink);
		       rBCD.setColor(Color.black);
		       
		       r0BCD=new GRect(620+20,300+20,40,3);
		       r0BCD.setFilled(true);
		       r0BCD.setColor(Color.black);
		       
		       r3BCD=new GRect(620+20,300+120-20-3,40,3);
		       r3BCD.setFilled(true);
		       r3BCD.setColor(Color.black);
		       
		       
		       r6BCD=new GRect(620+20,300+120/2,40,3);
		       r6BCD.setFilled(true);
		       r6BCD.setColor(Color.LIGHT_GRAY);        // its off
		       
		       
		       r1BCD=new GRect(620+20+40+2,300+20+3,3,40-3);
		       r1BCD.setFilled(true);
		       r1BCD.setColor(Color.black);
		       
		       r2BCD=new GRect(620+20+40+2,300+120/2+3,3,40-6);
	           r2BCD.setFilled(true);
		       r2BCD.setColor(Color.black);
		       
	           r4BCD=new GRect(620+20-5,300+120/2+3,3,40-6);
	           r4BCD.setFilled(true);
		       r4BCD.setColor(Color.black);
		       
		       
	           r5BCD=new GRect(620+20-5,300+20+3,3,40-3);
	           r5BCD.setFilled(true);
		       r5BCD.setColor(Color.black);
		       
		       
		       
		 // ....................................................................................................................      
	 
		 GLabel ABFlag=new GLabel("A=B Flag",x+chipWidth-pinSize/2+wLength+bSize+10,y+220+(90/2-pinSize/2)+pinSize/2-bSize/2+15); //mode control input
		       ABFlag.setFont("Times New Roman-20");
		       
		       
		
		 GLabel cPropogate=new GLabel("C_Propogate",x+chipWidth-pinSize/2+wLength+bSize+10,y+220+2*(90/2-pinSize/2)+pinSize/2-bSize/2+15); //mode control input
				cPropogate.setFont("Times New Roman-20");
			    

		 GLabel cGenerate=new GLabel("C_Generate",x+chipWidth-pinSize/2+wLength+bSize+10,y+220+3*(90/2-pinSize/2)+pinSize/2-bSize/2+15); //mode control input
			    cGenerate.setFont("Times New Roman-20");
			  
         GLabel m0Heading=new GLabel("4-BIT ALU (74181)",470,50);
                m0Heading.setFont("DigifaceWide-40");
                m0Heading.setColor(Color.cyan);
                add(m0Heading);
                
        GLabel m1Heading=new GLabel("4-BIT ALU (74181)",470+3,50+4);
                m1Heading.setFont("DigifaceWide-40");
                m1Heading.setColor(Color.black);
                add(m1Heading);       
                
         GLine m0HLine=new GLine(435-4,57,920-4,57);
          m0HLine.setColor(Color.cyan);  
          add(m0HLine);
         GLine m1HLine=new GLine(435,59,920,59);
          m1HLine.setColor(Color.black);  
          add(m1HLine);
			    
//--------------------------------- -----  operation table  ----------------------------------------------------------------
                double xM=683;
                double yM=630;
    			
          		                             	               // half division
          		add(new GLine(xM+100,70,xM+100,yM));           // +100 in x direction
          		add(new GLine(2*xM-50,70,2*xM-50,yM));         // rightmost
          		add(new GLine(xM+100,70,2*xM-50,70));          // topmost
          		add(new GLine(xM+100,yM,2*xM-50,yM));          //bottom most
          		add(new GLine(xM+100,140,2*xM-50,140));        //topmost-100 horizontal
          		add(new GLine(944,70,944,yM));                 //+100 in x direction +160 vertical
              	add(new GLine(944+160,70,944+160,yM));         //+100 in x direction +160 +160 vertical
          	    GLabel oSelection=new GLabel("Selection",xM+100+35,70+30);
          	    oSelection.setFont("Times New Roman-25");
          	    add(oSelection);
          	    GLabel oLFunction=new GLabel("Logic Functions",xM+100+160+8,70+30);
          	    oLFunction.setFont("Times New Roman-23");
          	    add(oLFunction);
          	    GLabel oAFunction=new GLabel("Arithmetic Functions",xM+100+160+160+8,70+30);
          	    oAFunction.setFont("Times New Roman-23");
          	    add(oAFunction);
          	    
          	    add(new GLabel("S3       S2       S1       S0"),805,130);
          	    add(new GLabel("( M = H )"),1000,130);
          	    add(new GLabel("( M = L )    ,   Cn = H (No Carry)"),1116,130);
          	    add(new GLabel("  L          L          L          L"),800,170);
          	    add(new GLabel("  F = ! A "),980,170);
          	    add(new GLabel("  F =  A "),1116+50-23,170);
          	    add(new GLabel("  L          L          L          H"),800,200);
          	    add(new GLabel("  F = ! ( A OR B ) "),980,200);
        	    add(new GLabel("  F =  A or B "),1116+50-23,200);
          	    add(new GLabel("  L          L          H          L"),800,230);
          	    add(new GLabel("  F = ! A * B "),980,230);
        	    add(new GLabel("  F =  A OR ! B"),1116+50-23,230);
            	add(new GLabel("  L          L          H          H"),800,260);
            	add(new GLabel("  F = 0  "),980,260);
         	    add(new GLabel("  F =  MINUS 1"),1116+50-23,260);
            	add(new GLabel("  L          H          L          L"),800,290);
            	add(new GLabel("  F = ! ( A * B ) "),980,290);
         	    add(new GLabel("  F =  A PLUS ( A * ! B )"),1116+50-23,290);
            	add(new GLabel("  L          H          L          H"),800,320);
            	add(new GLabel("  F = ! B "),980,320);
         	    add(new GLabel("  F =  ( A OR B ) PLUS ( A * ! B )"),1116+50-23,320);
            	add(new GLabel("  L          H          H          L"),800,350);
            	add(new GLabel("  F = A XOR B "),980,350);
         	    add(new GLabel("  F =  A MINUS B MINUS 1"),1116+50-23,350);
            	add(new GLabel("  L          H          H          H"),800,380);
            	add(new GLabel("  F = A * ! B "),980,380);
         	    add(new GLabel("  F =   ( A * ! B ) MINUS 1"),1116+50-23,380);
            	add(new GLabel("  H          L          L          L"),800,410);
            	add(new GLabel("  F = ! A OR B "),980,410);
         	    add(new GLabel("  F =  A PLUS ( A * B )"),1116+50-23,410);
            	add(new GLabel("  H          L          L          H"),800,440);
            	add(new GLabel("  F = ! A XNOR B "),980,440);
         	    add(new GLabel("  F =  A PLUS B"),1116+50-23,440);
            	add(new GLabel("  H          L          H          L"),800,470);
            	add(new GLabel("  F = B "),980,470);
         	    add(new GLabel("  F =  (A OR ! B ) PLUS ( A * B )"),1116+50-23,470);
            	add(new GLabel("  H          L          H          H"),800,500);
            	add(new GLabel("  F =  A * B "),980,500);
         	    add(new GLabel("  F =  ( A *  B ) MINUS 1"),1116+50-23,500);
            	add(new GLabel("  H          H          L          L"),800,530);
            	add(new GLabel("  F = 1 "),980,530);
         	    add(new GLabel("  F =  A PLUS A"),1116+50-23,530);
            	add(new GLabel("  H          H          L          H"),800,560);
            	add(new GLabel("  F = A OR ! B "),980,560);
         	    add(new GLabel("  F =  ( A or B) PLUS A"),1116+50-23,560);
            	add(new GLabel("  H          H          H          L"),800,590);
            	add(new GLabel("  F = A OR B "),980,590);
         	    add(new GLabel("  F =  ( A or ! B) PLUS A"),1116+50-23,590);
            	add(new GLabel("  H          H          H          H"),800,620);
            	add(new GLabel("  F = A "),980,620);
         	    add(new GLabel("  F =  A MINUS 1"),1116+50-23,620);
            	GLabel copyRight=new GLabel(" Copyright  2015 DxD @ IIT(BHU) . All rights reserved. ",1000,655);
        	    copyRight.setFont("Times New Roman-15");
        	    copyRight.setColor(Color.red);
        	    add(copyRight);
        	    
        	    
        
      	  
      		
			    
			    
			
 //---------------------------------- wires starting from top left in clockwise fashion------------------------------------------
		        
		       
		        wS3=new GLine(x+36,y+pinSize/2,x+36,y+pinSize/2-wLength);
			    wS3.setColor(Color.gray);
				add(wS3);
		        lS3=new GLabel("L",x+36-l,y+pinSize/2-wLength-l);
		        lS3.setColor(Color.gray);
		        lS3.setColor(Color.GRAY);
		        add(lS3);
				
				wS2=new GLine(x+36*2-3,y+pinSize/2,x+36*2-3,y+pinSize/2-wLength);
				wS2.setColor(Color.gray);
				add(wS2);
				lS2=new GLabel("L",x+36*2-3-l,y+pinSize/2-wLength-l);
				lS2.setColor(Color.GRAY);
				lS2.setColor(Color.GRAY);
				add(lS2);
				
				wS1=new GLine(x+36*3-6,y+pinSize/2,x+36*3-6,y+pinSize/2-wLength);
				add(wS1);
				wS1.setColor(Color.gray);
				lS1=new GLabel("L",x+36*3-6-l,y+pinSize/2-wLength-l);
				lS1.setColor(Color.GRAY);
				add(lS1);
				
				wS0=new GLine(x+36*4-9,y+pinSize/2,x+36*4-9,y+pinSize/2-wLength);
				wS0.setColor(Color.gray);
				add(wS0);	
				lS0=new GLabel("L",x+36*4-9-l,y+pinSize/2-wLength-l);
				lS0.setColor(Color.GRAY);
				add(lS0);
				
				wCn4=new GLine(x+chipWidth-pinSize/2,y+Cn4start+pinSize/2,x+chipWidth-pinSize/2+wLength,y+60+pinSize/2);
				wCn4.setColor(Color.RED);
				
				lCn4=new GLabel("H",x+chipWidth-pinSize/2+wLength+l,y+60+pinSize/2+l);
				lCn4.setColor(Color.RED);
				
				
				wF3=new GLine(x+chipWidth-pinSize/2,y+90+(120/4-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+90+(120/4-pinSize/2)+pinSize/2);
				wF3.setColor(Color.gray);
				
				lF3=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+90+(120/4-pinSize/2)+pinSize/2+l);
				lF3.setColor(Color.GRAY);
				
				
				wF2=new GLine(x+chipWidth-pinSize/2,y+90+2*(120/4-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+90+2*(120/4-pinSize/2)+pinSize/2);
				wF2.setColor(Color.gray);
				
				lF2=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+90+2*(120/4-pinSize/2)+pinSize/2+l);
				lF2.setColor(Color.GRAY);
				
				
				
				wF1=new GLine(x+chipWidth-pinSize/2,y+90+3*(120/4-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+90+3*(120/4-pinSize/2)+pinSize/2);
				wF1.setColor(Color.gray);
				
				lF1=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+90+3*(120/4-pinSize/2)+pinSize/2+l);
				lF1.setColor(Color.GRAY);
				
				
				
				wF0=new GLine(x+chipWidth-pinSize/2,y+90+4*(120/4-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+90+4*(120/4-pinSize/2)+pinSize/2);
				wF0.setColor(Color.gray);
				
				lF0=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+90+4*(120/4-pinSize/2)+pinSize/2+l);
				lF0.setColor(Color.GRAY);
				
				
				
				wAB=new GLine(x+chipWidth-pinSize/2,y+220+(90/2-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+220+(90/2-pinSize/2)+pinSize/2);
				wAB.setColor(Color.gray);
				
				lAB=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+220+(90/2-pinSize/2)+pinSize/2+l);
				lAB.setColor(Color.GRAY);
				
				
				wP=new GLine(x+chipWidth-pinSize/2,y+220+2*(90/2-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+220+2*(90/2-pinSize/2)+pinSize/2);
				wP.setColor(Color.gray);
				
				wP.setColor(Color.gray);
				lP=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+220+2*(90/2-pinSize/2)+pinSize/2+l);
				lP.setColor(Color.GRAY);
			
				
				
				wG=new GLine(x+chipWidth-pinSize/2,y+220+3*(90/2-pinSize/2)+pinSize/2,x+chipWidth-pinSize/2+wLength,y+220+3*(90/2-pinSize/2)+pinSize/2);
				wG.setColor(Color.gray);
				
				lG=new GLabel("L",x+chipWidth-pinSize/2+wLength+l,y+220+3*(90/2-pinSize/2)+pinSize/2+l);
				lG.setColor(Color.GRAY);
				
				
				wM=new GLine(x+pinSize/2,y+Mstart+pinSize/2,x+pinSize/2-wLength,y+Mstart+pinSize/2);
				wM.setColor(Color.gray);
				add(wM);
				lM=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Mstart+pinSize/2+l);
				lM.setColor(Color.GRAY);
				add(lM);
				
				wCn=new GLine(x+pinSize/2,y+Cnstart+pinSize/2,x+pinSize/2-wLength,y+Cnstart+pinSize/2);
				wCn.setColor(Color.RED);
				add(wCn);
				lCn=new GLabel("H",x+pinSize/2-wLength-bSize+l,y+Cnstart+pinSize/2+l);
				lCn.setColor(Color.RED);
				add(lCn);
				
				wB3=new GLine(x+pinSize/2,y+Bstart+(Bspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Bstart+(Bspace-pinSize/2)+pinSize/2);
				wB3.setColor(Color.gray);
				add(wB3);
				lB3=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Bstart+(Bspace-pinSize/2)+pinSize/2+l);
				lB3.setColor(Color.GRAY);
				add(lB3);
				
				wB2=new GLine(x+pinSize/2,y+Bstart+2*(Bspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Bstart+2*(Bspace-pinSize/2)+pinSize/2);
				wB2.setColor(Color.gray);
				add(wB2);
				lB2=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Bstart+2*(Bspace-pinSize/2)+pinSize/2+l);
				lB2.setColor(Color.GRAY);
				add(lB2);
				
				wB1=new GLine(x+pinSize/2,y+Bstart+3*(Bspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Bstart+3*(Bspace-pinSize/2)+pinSize/2);
				wB1.setColor(Color.gray);
				add(wB1);
				lB1=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Bstart+3*(Bspace-pinSize/2)+pinSize/2+l);
				lB1.setColor(Color.GRAY);
				add(lB1);
				
				wB0=new GLine(x+pinSize/2,y+Bstart+4*(Bspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Bstart+4*(Bspace-pinSize/2)+pinSize/2);
				wB0.setColor(Color.gray);
				add(wB0);
				lB0=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Bstart+4*(Bspace-pinSize/2)+pinSize/2+l);
				lB0.setColor(Color.GRAY);
				add(lB0);
				
				wA3=new GLine(x+pinSize/2,y+Astart+(Aspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Astart+(Aspace-pinSize/2)+pinSize/2);
				wA3.setColor(Color.gray);
				add(wA3);
				lA3=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Astart+(Aspace-pinSize/2)+pinSize/2+l);
				lA3.setColor(Color.GRAY);
				add(lA3);
				
				wA2=new GLine(x+pinSize/2,y+Astart+2*(Aspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Astart+2*(Aspace-pinSize/2)+pinSize/2);
				wA2.setColor(Color.gray);
				add(wA2);
				lA2=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Astart+2*(Aspace-pinSize/2)+pinSize/2+l);
				lA2.setColor(Color.GRAY);
				add(lA2);
				
				wA1=new GLine(x+pinSize/2,y+Astart+3*(Aspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Astart+3*(Aspace-pinSize/2)+pinSize/2);
				wA1.setColor(Color.gray);
				add(wA1);
				lA1=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Astart+3*(Aspace-pinSize/2)+pinSize/2+l);
				lA1.setColor(Color.GRAY);
				add(lA1);
				
				wA0=new GLine(x+pinSize/2,y+Astart+4*(Aspace-pinSize/2)+pinSize/2,x+pinSize/2-wLength,y+Astart+4*(Aspace-pinSize/2)+pinSize/2);
				wA0.setColor(Color.gray);
				add(wA0);
				lA0=new GLabel("L",x+pinSize/2-wLength-bSize+l,y+Astart+4*(Aspace-pinSize/2)+pinSize/2+l);
				lA0.setColor(Color.GRAY);
				add(lA0);
		
				
//-------------------------------------------------- main chip----------------------------------------------------------
				
				
		GRect chip = new GRect(x,y,chipWidth,chipHeight);
		chip.setColor(Color.black);
		chip.setFilled(true);
		chip.setFillColor(Color.cyan);
		add(chip);
	
		for(int i=0;i<4;i++){
			add(new GRect(x+(i+1)*(chipWidth/5-pinSize/2),y,pinSize,pinSize));
			add(new GLabel("S"+(3-i),x+(i+1)*(chipWidth/5-pinSize/2)-4,y+20));
		}
		   
		
		for(int i=0;i<4;i++){
			add(new GRect(x,y+Astart+(i+1)*(Aspace-pinSize/2),pinSize,pinSize));
			add(new GLabel("A"+(3-i),x+10,y+Astart+(i+1)*(Aspace-pinSize/2)+7));
			
		}
		
		for(int i=0;i<4;i++){
			add(new GRect(x,y+Bstart+(i+1)*(Bspace-pinSize/2),pinSize,pinSize));
		    add(new GLabel("B"+(3-i),x+10,y+Bstart+(i+1)*(Bspace-pinSize/2)+7));
		    
		}
			
		add(new GRect(x,y+Cnstart,pinSize,pinSize));
		add(new GLabel("Cn",x+10,y+Cnstart+7));
		
		add(new GRect(x,y+Mstart,pinSize,pinSize));
		add(new GLabel("M",x+10,y+Mstart+7));
		
		add(new GRect(x+chipWidth-pinSize,y+Cn4start,pinSize,pinSize));
		add(new GLabel("Cn+4",x+chipWidth-pinSize-35,y+60+7));
	
		for(int i=0;i<4;i++){
		   add(new GRect(x+chipWidth-pinSize,y+90+(i+1)*(120/4-pinSize/2),pinSize,pinSize));
		   add(new GLabel("F"+(3-i),x+chipWidth-pinSize-18,y+90+(i+1)*(120/4-pinSize/2)+7));
		}
		for(int i=0;i<3;i++){
			add(new GRect(x+chipWidth-pinSize,y+220+(i+1)*(90/2-pinSize/2),pinSize,pinSize));
			if(i==0)
		          add(new GLabel("A=B",x+chipWidth-pinSize-25,y+220+(i+1)*(90/2-pinSize/2)+7));
			if(i==1)
			      add(new GLabel("P",x+chipWidth-pinSize-12,y+220+(i+1)*(90/2-pinSize/2)+7));
			if(i==2)
				  add(new GLabel("G",x+chipWidth-pinSize-12,y+220+(i+1)*(90/2-pinSize/2)+7));
		}
		
		
// ---------------------------------------- high low box ------------------------------------------------------
		
		
		
		bS3=new GRect(x+36-bSize/2,y+pinSize/2-wLength-bSize,bSize,bSize);
	    add(bS3);
	    
	    bS2=new GRect(x+36*2-3-bSize/2,y+pinSize/2-wLength-bSize,bSize,bSize);
	    add(bS2);
		
		bS1=new GRect(x+36*3-6-bSize/2,y+pinSize/2-wLength-bSize,bSize,bSize);
	    add(bS1);
		
		bS0=new GRect(x+36*4-9-bSize/2,y+pinSize/2-wLength-bSize,bSize,bSize);
	    add(bS0);
		
		bA3=new GRect(x+pinSize/2-wLength-bSize,y+Astart+(Aspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bA3);
		
		
		bA2=new GRect(x+pinSize/2-wLength-bSize,y+Astart+2*(Aspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bA2);
		
		
		bA1=new GRect(x+pinSize/2-wLength-bSize,y+Astart+3*(Aspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bA1);
		
		
	    bA0=new GRect(x+pinSize/2-wLength-bSize,y+Astart+4*(Aspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bA0);
		
		
		bB3=new GRect(x+pinSize/2-wLength-bSize,y+Bstart+(Bspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bB3);
		
		
		bB2=new GRect(x+pinSize/2-wLength-bSize,y+Bstart+2*(Bspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bB2);
		
		
		bB1=new GRect(x+pinSize/2-wLength-bSize,y+Bstart+3*(Bspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bB1);
		
		
		bB0=new GRect(x+pinSize/2-wLength-bSize,y+Bstart+4*(Bspace-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		add(bB0);
		
		
		bCn=new GRect(x+pinSize/2-wLength-bSize,y+Cnstart+pinSize/2-bSize/2,bSize,bSize);
		add(bCn);
		
		 
		bM=new GRect(x+pinSize/2-wLength-bSize,y+Mstart+pinSize/2-bSize/2,bSize,bSize);
		add(bM);
		
		
	    bCn4=new GRect(x+chipWidth-pinSize/2+wLength,y+Cn4start+pinSize/2-bSize/2,bSize,bSize);
		
		
		bF3=new GRect(x+chipWidth-pinSize/2+wLength,y+90+(120/4-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		bF2=new GRect(x+chipWidth-pinSize/2+wLength,y+90+2*(120/4-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		bF1=new GRect(x+chipWidth-pinSize/2+wLength,y+90+3*(120/4-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		bF0=new GRect(x+chipWidth-pinSize/2+wLength,y+90+4*(120/4-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		bAB=new GRect(x+chipWidth-pinSize/2+wLength,y+220+(90/2-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		bP=new GRect(x+chipWidth-pinSize/2+wLength,y+220+2*(90/2-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		bG=new GRect(x+chipWidth-pinSize/2+wLength,y+220+3*(90/2-pinSize/2)+pinSize/2-bSize/2,bSize,bSize);
		
		
		
// reset button
		reset=new GRect(190,140,50,25);
		reset.setFilled(true);
		reset.setFillColor(Color.CYAN);
		add(reset);
		lReset=new GLabel("RESET",190+5,140+18);
		lReset.setColor(Color.black);
		add(lReset);
// result button  
		bResultx=new GRect(500,140,115,25);
		bResultx.setFilled(true);
		bResultx.setFillColor(Color.cyan);
		add(bResultx);    
		result=new GLabel("UPDATE RESULT",500+8,140+18);
		add(result);

				
				
		 
	
				
		
		
	
		
		
		
// --------------------------------------------- mouse location ---------------------------------------
	
		label = new GLabel("");
		add(label, 10, 30);
		// Must call this method to be able to get mouse events
		
}
		
	
// This method is called every time user moves mouse.
        @Override
		public void mouseMoved(MouseEvent e) {
		label.setLabel("" + e.getX() + ", " + e.getY() + "");
		}

		
// This method is called when mouse is clicked.
        @Override
		public void mouseClicked(MouseEvent e){
			  
				  
				
	              if(getElementAt(e.getX(),e.getY())==reset || getElementAt(e.getX(),e.getY())==lReset){
	            	  removeAll();
	            	  defaultG();
	              }
	              
	            
			
              if(getElementAt(e.getX(),e.getY())==bS0){
            	  
            	  removeR();
					if(i0%2==0){
					lS0.setLabel("H");
					lS0.setColor(Color.RED);
					wS0.setColor(Color.RED);
					
					mainOperation();
					updateBCD();
					}
					else {
						lS0.setLabel("L");
					    lS0.setColor(Color.gray);
					    wS0.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
				   }i0++;
	         }
				
				

			  if(getElementAt(e.getX(),e.getY())==bS1){
				 
				  removeR(); 
					if(i1%2==0){
					lS1.setLabel("H");
					lS1.setColor(Color.RED);
					wS1.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lS1.setLabel("L");
					    lS1.setColor(Color.gray);
					    wS1.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i1++;
			  }
				

				if(getElementAt(e.getX(),e.getY())==bS2){
					 removeR();
					if(i2%2==0){
					lS2.setLabel("H");
					lS2.setColor(Color.RED);
					wS2.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lS2.setLabel("L");
					    lS2.setColor(Color.gray);
					    wS2.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i2++;
				   }
				

				if(getElementAt(e.getX(),e.getY())==bS3){
					 removeR();
					if(i3%2==0){
					lS3.setLabel("H");
					lS3.setColor(Color.RED);
					wS3.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lS3.setLabel("L");
					    lS3.setColor(Color.gray);
					    wS3.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i3++;
				   }
				

				if(getElementAt(e.getX(),e.getY())==bA0 ){
					 removeR();
					if(i4%2==0){
					lA0.setLabel("H");
					lA0.setColor(Color.RED);
					wA0.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lA0.setLabel("L");
					    lA0.setColor(Color.gray);
					    wA0.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i4++;
				   }
				
				
				if(getElementAt(e.getX(),e.getY())==bA1){
					 removeR();
					if(i5%2==0){
					lA1.setLabel("H");
					lA1.setColor(Color.RED);
					wA1.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lA1.setLabel("L");
					    lA1.setColor(Color.gray);
					    wA1.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i5++;
				   }
				
				
				if(getElementAt(e.getX(),e.getY())==bA2){
					 removeR();
					if(i6%2==0){
					lA2.setLabel("H");
					lA2.setColor(Color.RED);
					wA2.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lA2.setLabel("L");
					    lA2.setColor(Color.gray);
					    wA2.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i6++;
				   }
				
				
				if(getElementAt(e.getX(),e.getY())==bA3){
					 removeR();
					if(i7%2==0){
					lA3.setLabel("H");
					lA3.setColor(Color.RED);
					wA3.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lA3.setLabel("L");
					    lA3.setColor(Color.gray);
					    wA3.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i7++;
				   }
				
				
				if(getElementAt(e.getX(),e.getY())==bB0){
					
					 removeR();
					if(i8%2==0){
					lB0.setLabel("H");
					lB0.setColor(Color.RED);
					wB0.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lB0.setLabel("L");
					    lB0.setColor(Color.gray);
					    wB0.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i8++;
				   }
				
				

				if(getElementAt(e.getX(),e.getY())==bB1){
					 removeR();
					if(i9%2==0){
					lB1.setLabel("H");
					lB1.setColor(Color.RED);
					wB1.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lB1.setLabel("L");
					    lB1.setColor(Color.gray);
					    wB1.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i9++;
				   }
				

				if(getElementAt(e.getX(),e.getY())==bB2){
					 removeR();
					if(i10%2==0){
					lB2.setLabel("H");
					lB2.setColor(Color.RED);
					wB2.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lB2.setLabel("L");
					    lB2.setColor(Color.gray);
					    wB2.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i10++;
				   }
				
				
				

				if(getElementAt(e.getX(),e.getY())==bB3){
					 removeR();
					if(i11%2==0){
					lB3.setLabel("H");
					lB3.setColor(Color.RED);
					wB3.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						lB3.setLabel("L");
					    lB3.setColor(Color.gray);
					    wB3.setColor(Color.gray);
					    mainOperation();
					    updateBCD();
					}i11++;
				   }
				

				if(getElementAt(e.getX(),e.getY())==bCn){
					 removeR();
					if(i12%2==0){
					lCn.setLabel("L");
					lCn.setColor(Color.gray);
					wCn.setColor(Color.gray);
					mainOperation();
					updateBCD();
					}
					else {
						lCn.setLabel("H");
					    lCn.setColor(Color.RED);
					    wCn.setColor(Color.RED);
					    mainOperation();
					    updateBCD();
					}i12++;
				   }
				
				

				if(getElementAt(e.getX(),e.getY())==bM){
					 removeR();
					if(i13%2==0){
					lM.setLabel("H");
					remove(bCn);
					remove(lCn);
					remove(wCn);
					remove(carryIn);
					remove(bCn4);
					remove(lCn4);
					remove(wCn4);
					remove(carryOut);
					remove(carryOutD);
					lM.setColor(Color.RED);
					wM.setColor(Color.RED);
					mainOperation();
					updateBCD();
					}
					else {
						add(bCn);
						add(lCn);
						add(wCn);
						add(carryIn);
						lM.setLabel("L");
					    lM.setColor(Color.gray);
					    wM.setColor(Color.gray);
					    
					    mainOperation();
					    updateBCD();
					}i13++;
				   }
				
				
				if(getElementAt(e.getX(),e.getY())==bResultx || getElementAt(e.getX(),e.getY())==result){
					add(bF0);
					add(bF1);
					add(bF2);
					add(bF3);
					add(bAB);
					add(bP);
					add(bG);
					add(wF0);
					add(wF1);
					add(wF2);
					add(wF3);
					add(wAB);
					add(wP);
					add(wG);
					add(lF0);
					add(lF1);
					add(lF2);
					add(lF3);
					add(lAB);
					add(lP);
					add(lG);
				if(lM.getLabel().equals("L")){
					add(bCn4);
					add(lCn4);
					add(wCn4);
					add(carryOut);
					add(carryOutD);
				}
				   add(rBCD);
			       add(r0BCD);
			       add(r3BCD);
			       add(r6BCD);
			       add(r1BCD);
			       add(r2BCD);
			       add(r4BCD);
			       add(r5BCD);
			       
					
				}

	       }
		
		
   
	
/* Private instance variable */
		
	   private final	int chipHeight=400;
	   private final	int chipWidth=180;
	   private final	int x=280;  //chip starting x
	   private final	int y=200;  // chip starting y
	   private final	int pinSize=6;
	   private final	int Astart=10;
	   private final	int Bstart=150;
	   private final	int Cnstart=320;
	   private final	int Mstart=363;
	   private final	int Aspace=32;
	   private final	int Bspace=Aspace;
	   private final	int Cn4start=60;
	   private final 	int l=5;
	   private final	int bSize=20;
	   private final        int wLength=70;
		
		
		
		private GLabel label;
		private GRect bS0;
		private GRect bS1;
		private GRect bS2;
		private GRect bS3;
		private GRect bA0;
		private GRect bA1;
		private GRect bA2;
		private GRect bA3;
		private GRect bB0;
		private GRect bB1;
		private GRect bB2;
		private GRect bB3;
		private GRect bCn;
		private GRect bM;
		private GRect rBCD;
		private GRect r0BCD;
		private GRect r1BCD;
		private GRect r2BCD;
		private GRect r3BCD;
		private GRect r4BCD;
		private GRect r5BCD;
		private GRect r6BCD;
		private GRect reset;
		private GRect bCn4;
		private GRect bResultx;
		private GRect bF3;
		private GRect bF2;
		private GRect bF1;
		private GRect bF0;
		private GRect bAB;
		private GRect bP;
		private GRect bG;
		
		
		
	    
	
		private GLabel lS0;
		private GLabel lS1;
		private GLabel lS2;
		private GLabel lS3;
		private GLabel lA0;
		private GLabel lA1;
		private GLabel lA2;
		private GLabel lA3;
		private GLabel lB0;
		private GLabel lB1;
		private GLabel lB2;
		private GLabel lB3;
		private GLabel lCn;
		private GLabel lM;
		private GLabel lCn4;
		private GLabel lF0;
		private GLabel lF1;
		private GLabel lF2;
		private GLabel lF3;
		private GLabel lAB;
		private GLabel lP;
		private GLabel lG;
		private GLabel lReset;
		private GLabel carryIn;
		private GLabel carryOut;
		private GLabel carryOutD;
		private GLabel result;
		
		
	    private GLine wS0;
	    private GLine wS1;
	    private GLine wS2;
	    private GLine wS3;
	    private GLine wA0;
	    private GLine wA1;
	    private GLine wA2;
	    private GLine wA3;
	    private GLine wB0;
	    private GLine wB1;
	    private GLine wB2;
	    private GLine wB3;
	    private GLine wCn;
	    private GLine wM;
	    private GLine wCn4;
	    private GLine wF0;
	    private GLine wF1;
	    private GLine wF2;
	    private GLine wF3;
	    private GLine wAB;
	    private GLine wP;
	    private GLine wG;
	    
	    private int i0=0;
	    private int i1=0;
	    private int i2=0;
	    private int i3=0;
	    private int i4=0;
	    private int i5=0;
	    private int i6=0;
	    private int i7=0;
	    private int i8=0;
	    private int i9=0;
	    private int i10=0;
	    private int i11=0;
	    private int i12=0;
	    private int i13=0;
	    private final int iR=0;


// AB --- multiply

private boolean m(boolean n1,boolean n2){
	if(n1 && n2)
		return n1;
	else if(!n1)
		return n1;
		else return n2;
	
	
}

// A+B ---- addition

private boolean a(boolean n1,boolean n2){
	if(!n1 && !n2)
		return n1;
	else if(n1)
		return n1;
		else return n2;
   }

// removing output
   private void removeR(){
	   remove(bF0);
		remove(bF1);
		remove(bF2);
		remove(bF3);
		remove(bAB);
		remove(bP);
		remove(bG);
		remove(wF0);
		remove(wF1);
		remove(wF2);
		remove(wF3);
		remove(wAB);
		remove(wP);
		remove(wG);
		remove(lF0);
		remove(lF1);
		remove(lF2);
		remove(lF3);
		remove(lAB);
		remove(lP);
		remove(lG);
		remove(bCn4);
		remove(lCn4);
		remove(wCn4);
		remove(carryOut);
		remove(carryOutD);
		remove(rBCD);
		remove(r0BCD);
		remove(r1BCD);
		remove(r2BCD);
		remove(r3BCD);
		remove(r4BCD);
		remove(r5BCD);
		remove(r6BCD);
		
   }


// method to convert gLabel to boolean

		public boolean gTB(GLabel S){
			if(S.getLabel().equals("H"))
				return true;
			else
				return false;
			
		} 
		
// method to convert boolean to gLabel
		
		public GLabel bTG(boolean b){
			if(b==true){
				GLabel t=new GLabel("H");
				return t;
				}
				
			else {
				 GLabel f=new GLabel("L");
				 return f;
			}
			
		}
// .......................... BCD display updating .............................
public void updateBCD(){
	if(lF0.getLabel()=="L" && lF1.getLabel()=="L" && lF2.getLabel()=="L" && lF3.getLabel()=="L" ){
    r0BCD.setColor(Color.black);
    r1BCD.setColor(Color.black);
    r2BCD.setColor(Color.black);
    r3BCD.setColor(Color.black);
    r4BCD.setColor(Color.black);
    r5BCD.setColor(Color.black);
    r6BCD.setColor(Color.LIGHT_GRAY);
        }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="L" && lF2.getLabel()=="L" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.LIGHT_GRAY);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.LIGHT_GRAY);
	    r4BCD.setColor(Color.LIGHT_GRAY);
	    r5BCD.setColor(Color.LIGHT_GRAY);
	    r6BCD.setColor(Color.LIGHT_GRAY);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="H" && lF2.getLabel()=="L" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.LIGHT_GRAY);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.LIGHT_GRAY);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="H" && lF2.getLabel()=="L" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.LIGHT_GRAY);
	    r5BCD.setColor(Color.LIGHT_GRAY);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="L" && lF2.getLabel()=="H" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.LIGHT_GRAY);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.LIGHT_GRAY);
	    r4BCD.setColor(Color.LIGHT_GRAY);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="L" && lF2.getLabel()=="H" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.LIGHT_GRAY);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.LIGHT_GRAY);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="H" && lF2.getLabel()=="H" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.LIGHT_GRAY);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="H" && lF2.getLabel()=="H" && lF3.getLabel()=="L" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.LIGHT_GRAY);
	    r4BCD.setColor(Color.LIGHT_GRAY);
	    r5BCD.setColor(Color.LIGHT_GRAY);
	    r6BCD.setColor(Color.LIGHT_GRAY);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="L" && lF2.getLabel()=="L" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="L" && lF2.getLabel()=="L" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.LIGHT_GRAY);
	    r4BCD.setColor(Color.LIGHT_GRAY);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="H" && lF2.getLabel()=="L" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.LIGHT_GRAY);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="H" && lF2.getLabel()=="L" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.LIGHT_GRAY);
	    r1BCD.setColor(Color.LIGHT_GRAY);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="L" && lF2.getLabel()=="H" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.LIGHT_GRAY);
	    r2BCD.setColor(Color.LIGHT_GRAY);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.LIGHT_GRAY);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="L" && lF2.getLabel()=="H" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.LIGHT_GRAY);
	    r1BCD.setColor(Color.black);
	    r2BCD.setColor(Color.black);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.LIGHT_GRAY);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="L" && lF1.getLabel()=="H" && lF2.getLabel()=="H" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.LIGHT_GRAY);
	    r2BCD.setColor(Color.LIGHT_GRAY);
	    r3BCD.setColor(Color.black);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	    }
	if(lF0.getLabel()=="H" && lF1.getLabel()=="H" && lF2.getLabel()=="H" && lF3.getLabel()=="H" ){
	    r0BCD.setColor(Color.black);
	    r1BCD.setColor(Color.LIGHT_GRAY);
	    r2BCD.setColor(Color.LIGHT_GRAY);
	    r3BCD.setColor(Color.LIGHT_GRAY);
	    r4BCD.setColor(Color.black);
	    r5BCD.setColor(Color.black);
	    r6BCD.setColor(Color.black);
	}
	    
}
		
// .......................... main operation starting ...........................
				
public void mainOperation(){
	
	
	boolean A0=gTB(lA0);
	boolean A1=gTB(lA1);
    boolean A2=gTB(lA2);
	boolean A3=gTB(lA3);
	boolean B0=gTB(lB0);
	boolean B1=gTB(lB1);
    boolean B2=gTB(lB2);
	boolean B3=gTB(lB3);
	boolean S0=gTB(lS0);
	boolean S1=gTB(lS1);
    boolean S2=gTB(lS2);
	boolean S3=gTB(lS3);
	boolean M=gTB(lM);
	boolean Cn=gTB(lCn);
	

	//------------------------------ first row ----------------------------------------------------
	
	
	boolean a00=A0;
	boolean a01=m(B0,S0);
	boolean a02=m(S1,!B0);
	boolean a03=m(A0,m(!B0,S2));
	boolean a04=m(A0,m(B0,S3));
	
	
	boolean a10=A1;
	boolean a11=m(B1,S0);
	boolean a12=m(S1,!B1);
	boolean a13=m(A1,m(!B1,S2));
	boolean a14=m(A1,m(B1,S3));
	
	
	boolean a20=A2;
	boolean a21=m(B2,S0);
	boolean a22=m(S1,!B2);
	boolean a23=m(A2,m(!B2,S2));
	boolean a24=m(A2,m(B2,S3));
	
	
	boolean a30=A3;
	boolean a31=m(B3,S0);
	boolean a32=m(S1,!B3);
	boolean a33=m(A3,m(!B3,S2));
	boolean a34=m(A3,m(B3,S3));
	
	
	// 2ND ROW
	
	
	boolean b00=m(!a02,m(!a00,!a01));
	boolean b01=m(!a03,!a04);
	
	boolean b10=m(!a12,m(!a10,!a11));
	boolean b11=m(!a13,!a14);
	
	boolean b20=m(!a22,m(!a20,!a21));
	boolean b21=m(!a23,!a24);
	
	boolean b30=m(!a32,m(!a30,!a31));
	boolean b31=m(!a33,!a34);
	
    // 3rd row
	
	
	boolean c00=a(m(!b00,b01),m(b00,!b01));
	
	boolean c10=a(m(!b10,b11),m(b10,!b11));
	
	boolean c20=a(m(!b20,b21),m(b20,!b21));

	boolean c30=a(m(!b30,b31),m(b30,!b31));
	
	
	//4th row
	
	boolean d0=a(!Cn,M);    // !(!M)
	boolean d1=m(!M,b00);
	boolean d2=m(!M,m(b01,Cn));
	boolean d3=m(!M,b10);
	boolean d4=m(!M,m(b00,b11));
	boolean d5=m(!M,m(b11,m(b01,Cn)));
	boolean d6=m(!M,b20);
	boolean d7=m(!M,m(b10,b21));
	boolean d8=m(!M,m(b00,m(b21,b11)));
	boolean d9=m(!M,m(b21,m(b11,m(b01,Cn))));
	boolean d10=a(!b01,a(!b11,a(!b21,!b31)));
	boolean d11=a(!Cn,a(!b01,a(!b11,a(!b21,!b31))));
	boolean d12=m(b00,m(b11,m(b21,b31)));
	boolean d13=m(b10,m(b21,b31));
	boolean d14=m(b20,b31);
	boolean d15=b31;
	
	
	// 5th row
	
	boolean e0=m(!d1,!d2);
	boolean e1=m(!d3,m(!d4,!d5));
	boolean e2=m(!d6,m(!d7,m(!d8,!d9)));
	boolean e3=m(!d12,m(!d13,m(!d14,!d15)));
	
	//6th row
	
	
	boolean f0=a(m(!d0,c00),m(d0,!c00));
	boolean f1=a(m(!e0,c10),m(e0,!c10));
	boolean f2=a(m(!e1,c20),m(e1,!c20));
	boolean f3=a(m(!e2,c30),m(e2,!c30));
	boolean f4=a(!d11,!e3);
	
	
	//7th row
	
	boolean g0=m(f0,m(f1,m(f2,f3)));
	
	
	//8th row FINAL RESULT 
	
	//boolean F0=f0;  
	//boolean F1=f1;
	//boolean F2=f2;
	//boolean F3=f3;
	//boolean P=d10;             //CARRY PROPOGATE
	//boolean Cn4=f4;            // CARRY OUTPUT
	//boolean G=e3;              // CARRY GENERATE
	//boolean AB=g0;
	
	// final updating
	//println(F0);
	//println(F1);
	//println(F2);
	//println(F3);
	//println(Cn4);
	//println(Cn);
	
// Updating to GLine objects
   
	lF0.setLabel(bTG(f0).getLabel());
            if(f0==true){
    	          lF0.setColor(Color.RED);
                  wF0.setColor(Color.RED);
            }
            else {
                  lF0.setColor(Color.gray);
                  wF0.setColor(Color.gray);
            }
        
    lF1.setLabel(bTG(f1).getLabel());
           if(f1==true){
                  lF1.setColor(Color.RED);
                  wF1.setColor(Color.RED);
           }
           else {
                  lF1.setColor(Color.gray);
                  wF1.setColor(Color.gray);
            }
    lF2.setLabel(bTG(f2).getLabel());
           if(f2==true){
                  lF2.setColor(Color.RED);
                  wF2.setColor(Color.RED);
           }
           else {
                  lF2.setColor(Color.gray);
                  wF2.setColor(Color.gray);
           }
    lF3.setLabel(bTG(f3).getLabel());
           if(f3==true){
                 lF3.setColor(Color.RED);
                 wF3.setColor(Color.RED);
           }
           else {
                 lF3.setColor(Color.gray);
                 wF3.setColor(Color.gray);
           }
    lP.setLabel(bTG(d10).getLabel());
          if(d10==true){
                 lP.setColor(Color.RED);
                 wP.setColor(Color.RED);
          }
          else {
                 lP.setColor(Color.gray);
                 wP.setColor(Color.gray);
               }
    lCn4.setLabel(bTG(f4).getLabel());
           if(f4==true){
                 lCn4.setColor(Color.RED);
                 wCn4.setColor(Color.RED);
           }
           else {
                 lCn4.setColor(Color.gray);
                 wCn4.setColor(Color.gray);
           }
           
           
    lG.setLabel(bTG(e3).getLabel());
           if(e3==true){
                 lG.setColor(Color.RED);
                 wG.setColor(Color.RED);
           }
           else {
                 lG.setColor(Color.gray);
                 wG.setColor(Color.gray);
           }
    lAB.setLabel(bTG(g0).getLabel());
           if(g0==true){
                 lAB.setColor(Color.RED);
                 wAB.setColor(Color.RED);
           }
           else {
                 lAB.setColor(Color.gray);
                 wAB.setColor(Color.gray);
           }
           
          
     }  //  ending of main operation

	
}/// main ending;