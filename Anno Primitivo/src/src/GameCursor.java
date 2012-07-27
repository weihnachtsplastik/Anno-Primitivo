package src;


import java.awt.Graphics;
import main.Anno;

public class GameCursor 
{
	
	private int x,y ;
	
	private int CursorID = 255;
	private Anno anno;
	
	public GameCursor(Anno anno){
		
		this.anno = anno;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}
	
	public void paintCursor(Graphics g, float zoom){
		try{
		x = anno.getGamePanel().getMousePosition().x;
		y = anno.getGamePanel().getMousePosition().y;
		}catch(Exception e){}
		x -= x % (32*zoom); 
		y -= y % (32*zoom);
		
		
		switch(CursorID){
			case 101:
				g.drawImage(anno.getTextureManager().getTexture(CursorID),x,y,(int)(32*zoom),(int)(32*zoom),null);break;
			case 102:
				g.drawImage(anno.getTextureManager().getTexture(CursorID),x,y,(int)(32*zoom*2),(int)(32*zoom*2),null);break;
			}

	}
	
	public void setCursorID(int id){
		CursorID = id;
	}
	
	public int getCursorID(){
		return CursorID;
	}

	
	
}
