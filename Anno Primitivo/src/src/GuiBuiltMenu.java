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
	public boolean onClick(int x, int y)
	{
		if(!isOnGui(x, y))
		{
			close();
		}
		return super.onClick(x, y);
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
		g.drawImage(texMngr.getTexture("/block_icons/weg_Icon.png"),x,y,32,32,null);
	}
}
