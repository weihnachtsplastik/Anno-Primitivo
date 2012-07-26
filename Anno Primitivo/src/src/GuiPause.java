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
		guiButton = new GuiButton(0, "/gui/back.png", x + width / 2 - 112, y + height / 2 - 80, 224, 32, this);
		guiButton.setHoverTexture("/gui/back_select.png");
		guiButton.useTextures();
		controlList.add(guiButton);
		guiButton = new GuiButton(1, "/gui/options.png", x + width / 2 - 112, y + height / 2 - 16, 224, 32, this);
		guiButton.setHoverTexture("/gui/options_select.png");
		guiButton.setDisabledTexture("/gui/options_disabled.png");
		guiButton.useTextures();
		guiButton.setEnabled(false);
		controlList.add(guiButton);
		guiButton = new GuiButton(2, "/gui/quit.png", x + width / 2 - 112, y + height / 2 + 48, 224, 32, this);
		guiButton.setHoverTexture("/gui/quit_select.png");
		guiButton.useTextures();
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
