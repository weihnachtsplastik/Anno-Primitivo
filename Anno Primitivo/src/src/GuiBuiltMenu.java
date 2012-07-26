package src;

import java.awt.Color;
import java.awt.Graphics;

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
		g.setColor(new Color(0.0F, 0.0F, 0.0F, 0.75F));
		g.fillRect(getX(), getY(), width, height);
	}
}
