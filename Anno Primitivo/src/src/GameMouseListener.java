package src;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.Anno;

public class GameMouseListener implements MouseListener
{
	private Anno anno;
	private boolean isMouseEntered;

	public GameMouseListener(Anno anno)
	{
		isMouseEntered = false;
		this.anno = anno;
	}

	/**
	 * Gibt zur�ck, ob die Maus �ber dem Fenster ist oder nicht.
	 */
	public boolean isMouseEntered()
	{
		return isMouseEntered;
	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
		if(isMouseEntered())
		{
			int x = event.getX();
			int y = event.getY();
			if(anno.getOS() == EnumOS.windows){
				x /= 32;
				y /= 32;
			}
			anno.getGuiManager().fireClick(x, y);
		}
	}

	@Override
	public void mouseEntered(MouseEvent event)
	{
		isMouseEntered = true;
	}

	@Override
	public void mouseExited(MouseEvent event)
	{
		isMouseEntered = false;
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
	}
}
