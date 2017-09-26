package snake;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
public class GamePlay extends JPanel implements KeyListener ,ActionListener{
	   private ImageIcon imageTitle; 
	   private int snakeXlength[]=new int[750];
	   private int snakeYlength[]=new int[750];
	   boolean left=false;
	   boolean right=false;
	   boolean up=false;
	   boolean down=false;
	   boolean gameover=false;
	   private ImageIcon rightmouth;
	   private ImageIcon leftmouth;
	   private ImageIcon downmouth;
	   private ImageIcon upmouth;
	   private Timer timer;
	   private int delay=100;
	   private ImageIcon snakeimage;
	   private int lengthofsnake=3;
	   private int move=0;
	   private int score=0;
	   private int enemyXpos[]= {25,50,75,100,125,150,175,200,225,250,275,300
			 , 325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725
			 ,750,775,800,825,850};
	   private int enemyYpos[]={75,100,125,150,175,200,225,250,275,300 ,325
			   ,350,375,400,425,450,475,500,525,550,575,600,625};
	   private ImageIcon enemyimage;
	   private Random random=new Random();
	   private int xpos=random.nextInt(34);
	   private int ypos=random.nextInt(23);
	   public GamePlay()
       {
    	   addKeyListener(this);
    	   setFocusable(true);
    	   setFocusTraversalKeysEnabled(false);
    	   timer = new Timer(delay,this);
    	   timer.start();
       }
       public void paint(Graphics g) {
    	   if(move==0 ) {
    		   snakeXlength[2]=50;
    		   snakeXlength[1]=75;
    		   snakeXlength[0]=100;
    		   snakeYlength[2]=100;
    		   snakeYlength[1]=100;
    		   snakeYlength[0]=100;
    	   }
    	   //draw title image border
    	   g.setColor(Color.BLACK);
    	   g.drawRect(24,10, 851, 55);
    	   //draw the title image
    	   imageTitle= new ImageIcon("snaketitle.jpg");
    	   imageTitle.paintIcon(this,g,25,11);
    	   //draw border for gameplay
    	   g.setColor(Color.BLACK);
    	   g.drawRect(24,74,853,577);
    	   //draw background for the gameplay
    	   g.setColor(Color.white);
    	   g.fillRect(25,75,850,575);
    	   //draw the score
    	   g.setColor(Color.WHITE);
    	   g.setFont(new Font("arial",Font.PLAIN,14));
    	   g.drawString("Scores: "+score, 780, 30);
    	   //draw the length of snake
    	   g.setColor(Color.WHITE);
    	   g.setFont(new Font("arial",Font.PLAIN,14));
    	   g.drawString("Length : "+lengthofsnake, 780, 50);
    	   rightmouth= new ImageIcon("rightmouth.png");
    	   rightmouth.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);
    	   for(int a=0;a<lengthofsnake;a++) {
    		   if(a==0&&right) {
    			   rightmouth= new ImageIcon("rightmouth.png");
    	    	   rightmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    		   }
    		   if(a==0&&left) {
    			   leftmouth= new ImageIcon("leftmouth.png");
    	    	   leftmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    		   }
    		   if(a==0&&up) {
    			   upmouth= new ImageIcon("upmouth.png");
    	    	   upmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    		   }
    		   if(a==0&&down) {
    			   downmouth= new ImageIcon("downmouth.png");
    	    	   downmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    		   }
    		   if(a!=0)
    		   {
        		   snakeimage= new ImageIcon("snakeimage.png");
        	       snakeimage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    		   }
    	   }
    	   enemyimage=new ImageIcon("enemy.png");
    	   if(enemyXpos[xpos]==snakeXlength[0]&&enemyYpos[ypos]==snakeYlength[0]) {
    		   lengthofsnake++;
    		   score+=5;
    		   xpos=random.nextInt(34);
    		   ypos=random.nextInt(23);
    	   }
    	   enemyimage.paintIcon(this, g, enemyXpos[xpos], enemyYpos[ypos]);
    	   for(int i=1;i<lengthofsnake;i++) {
    		   if(snakeXlength[i]==snakeXlength[0]&&snakeYlength[i]==snakeYlength[0])
    		   {
    			   right=false;
    			   left=false;
    			   up=false;
    			   down=false;
    			   g.setColor(Color.GREEN);
    			   g.setFont(new Font("arial",Font.BOLD,50));
    	    	   g.drawString("Game Over", 330, 350);
    	    	   g.setFont(new Font("arial",Font.BOLD,20));
    	    	   g.drawString("Press 'Space' Key to Restart", 330, 380);
    	    	   score=0;
    	    	   gameover=true;
    		   }
    	   }
    	   g.dispose();
       }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if(right) {
			for(int r=lengthofsnake-1;r>=0;r--) {
				snakeYlength[r+1]=snakeYlength[r];
			}
			for(int r=lengthofsnake-1;r>=0;r--) {
				if(r==0) {
					snakeXlength[r]=snakeXlength[r]+25;
				}
				else
				{
					snakeXlength[r]=snakeXlength[r-1];
				}
				if(snakeXlength[r]>850) {
					snakeXlength[r]=25;
				}
			}
			repaint();
		}
        if(left) {
        	for(int r=lengthofsnake-1;r>=0;r--) {
				snakeYlength[r+1]=snakeYlength[r];
			}
			for(int r=lengthofsnake-1;r>=0;r--) {
				if(r==0) {
					snakeXlength[r]=snakeXlength[r]-25;
				}
				else
				{
					snakeXlength[r]=snakeXlength[r-1];
				}
				if(snakeXlength[r]<25) {
					snakeXlength[r]=850;
				}
			}
			repaint();
		}
        if(up) {
        	for(int r=lengthofsnake-1;r>=0;r--) {
				snakeXlength[r+1]=snakeXlength[r];
			}
			for(int r=lengthofsnake-1;r>=0;r--) {
				if(r==0) {
					snakeYlength[r]=snakeYlength[r]-25;
				}
				else
				{
					snakeYlength[r]=snakeYlength[r-1];
				}
				if(snakeYlength[r]<75) {
					snakeYlength[r]=625;
				}
			}
			repaint();
			
		}
        if(down) {
        	for(int r=lengthofsnake-1;r>=0;r--) {
				snakeXlength[r+1]=snakeXlength[r];
			}
			for(int r=lengthofsnake-1;r>=0;r--) {
				if(r==0) {
					snakeYlength[r]=snakeYlength[r]+25;
				}
				else
				{
					snakeYlength[r]=snakeYlength[r-1];
				}
				if(snakeYlength[r]>625){
					snakeYlength[r]=75;
				}
			}
			repaint();
        }
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if((e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT)&&gameover==false) {
			move++;
			if(left==false) {
			     right=true;
			}
			else
			{
				left=true;
				right=false;
			}
			up=false;
			down=false;
		}
		if((e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT)&&gameover==false) {
			move++;
			if(right==false) {
			     left=true;
			}
			else
			{
				right=true;
				left=false;
			}
			up=false;
			down=false;
		}
		if((e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP)&&gameover==false) {
			move++;
			if(down==false) {
			     up=true;
			}
			else
			{
				down=true;
				up=false;
			}
			right=false;
			left=false;
		}
		if((e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN)&&gameover==false) {
			move++;
			if(up==false) {
			     down=true;
			}
			else
			{
				up=true;
				down=false;
			}
			right=false;
			left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			move=0;score=0;lengthofsnake=3;
			right=true;
			left=up=down=false;
			xpos=random.nextInt(34);
			ypos=random.nextInt(23);
			gameover=false;
			repaint();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
