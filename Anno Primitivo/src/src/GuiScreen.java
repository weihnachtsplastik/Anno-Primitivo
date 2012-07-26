package src;

import java.awt.Graphics;

public class GuiScreen extends Gui
{
	public GuiScreen()
	{
		super();
		x = 0;
		y = 0;
	}
	
	@Override
	public boolean onClick(int x, int y)
	{
		anno.getWorld().onClick(x / 32, y / 32);
		return super.onClick(x, y);
	}

	@Override
	public void onGuiOpen()
	{
		width = anno.getGamePanel().getWidth();
		height = anno.getGamePanel().getHeight() - 32;
	}

	@Override
	public void paint(Graphics g)
	{
		for(int y = 0; y < (getHeight()) / 32; y++)
		{
			for(int x = 0; x < getWidth() / 32; x++)
			{
				g.drawImage(anno.getTextureManager().getTexture(anno.getWorld().getBlockID(x, y)), x * 32, y * 32, null);
			}
		}
		anno.getWorld().getEntityManager().paintEntitys(g);
	}
}
