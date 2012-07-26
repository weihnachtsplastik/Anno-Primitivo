package main;

import java.awt.Graphics;
import src.AnnoRunnable;
import src.GamePanel;
import src.GameWindow;
import src.GuiInterface;
import src.GuiManager;
import src.GuiScreen;
import src.TextureManager;
import src.World;

public class Anno
{	
	private Thread animator;
	private GamePanel gamePanel;
	private GameWindow gameWindow;
	private GuiManager guiMngr;
	private boolean paused;
	private boolean running;
	private TextureManager texMngr;
	private World world;

	public Anno()
	{
		running = false;
		paused = false;
		world = new World();
		texMngr = new TextureManager();
		gameWindow = new GameWindow(this, 806, 604, "Anno Primitivo");
		gamePanel = new GamePanel();
		gameWindow.add(gamePanel);
		guiMngr = new GuiManager(this);
		addGuis();
	}

	private void addGuis()
	{
		guiMngr.openGui(new GuiScreen());
		guiMngr.openGui(new GuiInterface());
	}

	private void gameRender()
	{
		Graphics g = gamePanel.getGraphics();
		if(g == null)
		{
			System.out.println("Graphics is null!");
			return;
		}
		guiMngr.paintGuis(g);
	}

	private void gameRepaint()
	{
		gamePanel.repaint();
	}

	private void gameUpdate()
	{
		guiMngr.updateGuis();
		if(!paused)
		{
			world.updateWorld();
		}
	}

	/**
	 * Gibt das Game Panel zurück.<br>
	 * Dies ist die Komponente, auf der das Bild entsteht. Es hat also die Größe, die das gerenderte Bild maximal haben darf.
	 */
	public GamePanel getGamePanel()
	{
		return gamePanel;
	}

	/**
	 * Gibt den Gui Manager zurück.<br>
	 * Dieser verwaltet alle Guis. Er ist vorallem dann notwendig, wenn eine neue Gui geöffnet oder eine alte geschlossen werden soll.
	 */
	public GuiManager getGuiManager()
	{
		return guiMngr;
	}

	/**
	 * Gibt den Texture Manager zurück.<br>
	 * Dieser verwaltet alle Texturen. Dies ist sehr hilfreich, wenn man eine Textur, die auf der Festplatte liegt zeichnen möchte. Hierzu muss die das Bild im Ordner "res" liegen. Außerdem speichert er einmal geladene Texturen im Arberitsspeicher ab, sodass diese beim nächsten mal nicht mehr von der Festplatte geladen werden muss, was wiederum den Spielverlauf verschnellert.
	 */
	public TextureManager getTextureManager()
	{
		return texMngr;
	}

	/**
	 * Gibt die aktuelle Welt zurück.<br>
	 * Hier ist alles über die Welt gespeichert. Die Blöcke und deren Inhalte, wenn diese vorhanden sind, und die Items, die schon eingesammelt wurden.
	 */
	public World getWorld()
	{
		return world;
	}

	/**
	 * Gibt zurück, ob das Spiel gerade pausiert ist.
	 */
	public boolean isGamePaused()
	{
		return paused;
	}

	/**
	 * Pausiert das Spiel.
	 */
	public void pauseGame()
	{
		paused = true;
	}

	/**
	 * Lässt das Spiel laufen.
	 */
	public void run()
	{
		running = true;
		while(running)
		{
			gameUpdate();
			gameRender();
			gameRepaint();
			try
			{
				Thread.sleep(20L);
			}
			catch(InterruptedException exeption)
			{
				exeption.printStackTrace();
			}
		}
		System.exit(0);
	}

	/**
	 * Startet das Spiel.
	 */
	public void startGame()
	{
		if(animator == null || !running)
		{
			animator = new Thread(new AnnoRunnable(this));
			world.genWorld();
			animator.start();
		}
	}

	/**
	 * Stoppt das Spiel.
	 */
	public void stopGame()
	{
		running = false;
	}

	/**
	 * Lässt das Spiel weiter laufen.
	 */
	public void unpauseGame()
	{
		paused = false;
	}
	
	public static void main(String[] args)
	{
		Anno anno = new Anno();
		anno.startGame();
	}
}
