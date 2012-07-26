package src;

import java.awt.Color;
import java.awt.Graphics;

public class GuiPause extends Gui
{
	public GuiPause()
	{
		super();
		x = 0;
		y = 0;
	}

	@Override
	public boolean onGuiButtonClick(GuiButton guiButton)
	{
		if(guiButton.isEnabled() && guiButton.getID() == 0)
		{
			close();
			return true;
		}
		else if(guiButton.isEnabled() && guiButton.getID() == 1)
		{
			return true;
		}
		else if(guiButton.isEnabled() && guiButton.getID() == 2)
		{
			anno.stopGame();
			return true;
		}
		return false;
	}

	@Override
	public void onGuiOpen()
	{
		width = anno.getGamePanel().getWidth();
		height = anno.getGamePanel().getHeight();

		GuiButton guiButton;
		controlList.clear();
		guiButton = new GuiButton(0, "/MenuButton/back.png", x + width / 2 - 112, y + height / 2 - 80, 224, 32, this);
		guiButton.setHoverTexture("/MenuButton/back_select.png");
		controlList.add(guiButton);
		guiButton = new GuiButton(1, "/MenuButton/options.png", x + width / 2 - 112, y + height / 2 - 16, 224, 32, this);
		guiButton.setHoverTexture("/MenuButton/options_select.png");
		guiButton.setDisabledTexture("/MenuButton/options_disabled.png");
		guiButton.setEnabled(false);
		controlList.add(guiButton);
		guiButton = new GuiButton(2, "/MenuButton/quit.png", x + width / 2 - 112, y + height / 2 + 48, 224, 32, this);
		guiButton.setHoverTexture("/MenuButton/quit_select.png");
		controlList.add(guiButton);
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(new Color(0.0F, 0.0F, 0.0F, 0.6F));
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public boolean pausesGame()
	{
		return true;
	}
}
