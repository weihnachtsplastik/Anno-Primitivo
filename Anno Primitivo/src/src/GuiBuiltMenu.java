package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


public class GuiBuiltMenu extends Gui
{

	
	public GuiBuiltMenu()
	{
		super();
		x = 608;
		y = 256;
		width = 192;
		height = 288;
		
	}

	@Override
	public void onGuiOpen(){
		GuiButton button;
		
		controlList.clear();
		button = new GuiButton(0,"/block_icons/weg_Icon.png",10,10,32,32,this);
		button.useTextures();
		controlList.add(button);
		button.setEnabled(true);
		
		button = new GuiButton(1,"/block_icons/Holzfällerhütte.png",50,10,32,32,this);
		button.useTextures();
		controlList.add(button);
		button.setEnabled(true);
		
		button.setEnabled(true);
	}
	
	@Override
	public boolean onGuiButtonClick(GuiButton button)
	{
		if(button.isEnabled() && button.getID() == 0)
		{
			anno.getCursor().setCursorID(101);
			System.out.println("der Weg wurde aktiviert");
			return true;
		}
		else if(button.isEnabled() && button.getID() == 1)
		{
			anno.getCursor().setCursorID(102);
			System.out.println("die Holzfällerhütte wurde aktiviert");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onClick(int x, int y)
	{
		if(!isOnGui(x, y))
		{
			close();
		}
		if( super.onClick(x, y) == false){
			anno.getCursor().setCursorID(255);
		}
		return false;
	}

	@Override
	public void paint(Graphics g)
	{
		TextureManager texMngr = anno.getTextureManager();
		World world = anno.getWorld();
		
		g.setColor(new Color(0.0F, 0.0F, 0.0F, 0.75F));
		g.fillRect(getX(), getY(), width, height);
		g.setFont(new Font("Arial",2,20));
		g.setColor(Color.blue);
	}
}
