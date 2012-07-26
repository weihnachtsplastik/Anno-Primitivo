package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Anno;

public class GameKeyListener implements KeyListener
{
	private Anno anno;

	public GameKeyListener(Anno anno)
	{
		this.anno = anno;
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
	}

	@Override
	public void keyTyped(KeyEvent event)
	{
		if(!anno.getGuiManager().fireKeyType(event.getKeyChar(), event.getID()))
		{
			switch(event.getKeyChar())
			{
				case KeyEvent.VK_ESCAPE:
				case KeyEvent.VK_PAUSE:
					if(anno.getGuiManager().getGui(GuiPause.class) == null)
					{
						anno.getGuiManager().openGui(new GuiPause());
					}
					else
					{
						anno.getGuiManager().closeGui(anno.getGuiManager().getGui(GuiPause.class));
					}
					break;
				case 'b':
					if(anno.getGuiManager().getGui(GuiBuiltMenu.class) == null)
					{
						anno.getGuiManager().openGui(new GuiBuiltMenu());
					}
					else
					{
						anno.getGuiManager().closeGui(anno.getGuiManager().getGui(GuiBuiltMenu.class));
					}
					break;
			}
		}
	}
}
