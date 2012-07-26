package src;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import main.Anno;

public class GameMouseWheelListener implements MouseWheelListener
{
	private Anno anno;

	public GameMouseWheelListener(Anno anno)
	{
		this.anno = anno;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event)
	{
		if(!anno.isGamePaused())
		{
			if(event.getWheelRotation() > 0)
			{
				((GuiScreen) anno.getGuiManager().getGui(GuiScreen.class)).zoomOut();
			}
			else
			{
				((GuiScreen) anno.getGuiManager().getGui(GuiScreen.class)).zoomIn();
			}
		}
	}
}
