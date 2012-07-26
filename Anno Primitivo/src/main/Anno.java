package main;

import java.awt.Graphics;
import src.GamePanel;
import src.GameWindow;
import src.GuiManager;
import src.GuiRender;
import src.TextureManager;
import src.World;

public class Anno
{	
	private Thread threadAnimate;
	private Thread threadUpdate;
	private GamePanel gamePanel;
	private GameWindow gameWindow;
	private GuiManager guiMngr;
	private boolean paused;
	private boolean animRunning;
	private boolean updtRunning;
	private TextureManager texMngr;
	private World world;

	public Anno()
	{
		animRunning = false;
		updtRunning = false;
		paused = false;
		world = new World(this);
		texMngr = new TextureManager();
		gameWindow = new GameWindow(this, 800, 600, "Anno Primitivo");
		gamePanel = new GamePanel();
		gameWindow.add(gamePanel);
		guiMngr = new GuiManager(this);
		guiMngr.openGui(new GuiRender());
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
	 * Gibt das Game Panel zur�ck.<br>
	 * Dies ist die Komponente, auf der das Bild entsteht. Es hat also die Gr��e, die das gerenderte Bild maximal haben darf.
	 */
	public GamePanel getGamePanel()
	{
		return gamePanel;
	}

	/**
	 * Gibt den Gui Manager zur�ck.<br>
	 * Dieser verwaltet alle Guis. Er ist vorallem dann notwendig, wenn eine neue Gui ge�ffnet oder eine alte geschlossen werden soll.
	 */
	public GuiManager getGuiManager()
	{
		return guiMngr;
	}

	/**
	 * Gibt den Texture Manager zur�ck.<br>
	 * Dieser verwaltet alle Texturen. Dies ist sehr hilfreich, wenn man eine Textur, die auf der Festplatte liegt zeichnen m�chte. Hierzu muss die das Bild im Ordner "res" liegen. Au�erdem speichert er einmal geladene Texturen im Arberitsspeicher ab, sodass diese beim n�chsten mal nicht mehr von der Festplatte geladen werden muss, was wiederum den Spielverlauf verschnellert.
	 */
	public TextureManager getTextureManager()
	{
		return texMngr;
	}

	/**
	 * Gibt die aktuelle Welt zur�ck.<br>
	 * Hier ist alles �ber die Welt gespeichert. Die Bl�cke und deren Inhalte, wenn diese vorhanden sind, und die Items, die schon eingesammelt wurden.
	 */
	public World getWorld()
	{
		return world;
	}

	/**
	 * Gibt zur�ck, ob das Spiel gerade pausiert ist.
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
	 * Berechnet alle �nderungen.
	 */
	public void doTick()
	{
		updtRunning = true;
		while(updtRunning)
		{
			gameUpdate();
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
	 * Zeichnet das Spiel.
	 */
	public void run()
	{
		animRunning = true;
		while(animRunning)
		{
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
		if(threadUpdate == null || !updtRunning)
		{
			threadUpdate = new Thread(new AnnoRunnableUpdate(this));
		}
		if(threadAnimate == null || !animRunning)
		{
			threadAnimate = new Thread(new AnnoRunnableAnimate(this));
			threadAnimate.start();
		}
		world.genWorld();
	}

	/**
	 * Stoppt das Spiel.
	 */
	public void stopGame()
	{
		animRunning = false;
		updtRunning = false;
	}

	/**
	 * L�sst das Spiel weiter laufen.
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
