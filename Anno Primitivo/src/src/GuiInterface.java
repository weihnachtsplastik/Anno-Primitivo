package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GuiInterface extends Gui
{
	public GuiInterface()
	{
		super();
		x = 0;
		y = 544;
		width = 800;
		height = 32;
	}

	@Override
	public boolean onGuiButtonClick(GuiButton guiButton)
	{
		if(guiButton.isEnabled() && guiButton.getID() == 0)
		{
			anno.getGuiManager().openGui(new GuiBuiltMenu());
			return true;
		}
		return false;
	}

	@Override
	public void onGuiOpen()
	{
		controlList.clear();
		GuiButton guiButton = new GuiButton(0, "/gui/build.png", x + width - 32, 0, 32, 32, this);
		guiButton.setHoverTexture("/gui/build_select.png");
		guiButton.setDisabledTexture("/gui/build_disabled.png");
		guiButton.useTextures();
		controlList.add(guiButton);
	}

	@Override
	public void onUpdateScreen()
	{
		if(anno.getGuiManager().getGui(GuiBuiltMenu.class) == null)
		{
			controlList.get(0).setEnabled(true);
		}
		else
		{
			controlList.get(0).setEnabled(false);
		}
	}
	
	@Override
	public void paint(Graphics g)
	{
		TextureManager texMngr = anno.getTextureManager();
		World world = anno.getWorld();
		
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height / 2);

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 0, 20));
		g.drawImage(texMngr.getTexture(256), x, y, null);
		g.drawString("" + world.getWorldData().getItem(256).getAmount(), x + 34, y + 23);
		g.drawImage(texMngr.getTexture(257), x + 96, 544, null);
		g.drawString("" + world.getWorldData().getItem(257).getAmount(), x + 130, y + 23);
		g.drawImage(texMngr.getTexture(258), x + 192, y, null);
		g.drawString("" + world.getWorldData().getItem(258).getAmount(), x + 226, y + 23);
	}
}
