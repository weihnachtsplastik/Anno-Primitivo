package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
	private Image img = null;

	public GamePanel()
	{
		setBackground(Color.black);
		setSize(new Dimension(800, 576));
	}

	/**
	 * Gibt die Graphics zurück, mit denen das aktuelle Fram erzeugt werden soll.
	 */
	public Graphics getGraphics()
	{
		if(img == null)
		{
			img = createImage(getWidth(), getHeight());
			if(img == null)
			{
				System.out.println("Image is null!");
				return null;
			}
			else
			{
				return img.getGraphics();
			}
		}
		else
		{
			return img.getGraphics();
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(img != null)
		{
			super.getGraphics().drawImage(img, 0, 0, null);
		}
	}
}
