package src;

import javax.swing.JFrame;
import main.Anno;

@SuppressWarnings("serial")
public class GameWindow extends JFrame
{
	public GameWindow(Anno anno, int width, int height, String title)
	{
		super();
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(anno.getTextureManager().getTexture("/icon.ico"));
		addKeyListener(new GameKeyListener(anno));
		addMouseListener(new GameMouseListener(anno));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
