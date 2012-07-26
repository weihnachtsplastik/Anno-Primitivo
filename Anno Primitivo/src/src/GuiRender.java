package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GuiRender extends Gui
{
	private int pgBarPos;
	private int pgBarMax;

	public GuiRender()
	{
		pgBarPos = 0;
		pgBarMax = 100;
		x = 0;
		y = 0;
	}

	@Override
	public void onGuiOpen()
	{
		width = anno.getGamePanel().getWidth();
		height = anno.getGamePanel().getHeight();
	}

	@Override
	public void onGuiClose()
	{
		anno.getGuiManager().openGui(new GuiScreen());
		anno.getGuiManager().openGui(new GuiInterface());
	}

	public void setPorgressBarMaximum(int max)
	{
		pgBarMax = max;
	}

	public void setProgressBarPosition(int pos)
	{
		pgBarPos = pos;
	}

	public int getPorgressBarMaximum()
	{
		return pgBarMax;
	}

	public int getProgressBarPosition()
	{
		return pgBarPos;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Generiere Welt...", x + 300, y + height / 2 - 30);
		g.setColor(Color.darkGray);
		g.fillRect(x + 100, y + height / 2 - 5, width - 200, 10);
		g.setColor(Color.green);
		g.fillRect(x + 100, y + height / 2 - 5, (int) ((width - 200) * ((double) pgBarPos / pgBarMax)), 10);
	}
}
