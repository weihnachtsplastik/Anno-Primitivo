package src;

import java.util.ArrayList;
import java.util.List;
import main.Anno;

public class World
{
	private Anno anno;
	private WorldData worldData;
	private EntityManager entityMngr;
	private List<Chunk> chunkList;
	private final int chunkCountWidth;
	private final int chunkCountHeight;

	public World(Anno anno)
	{
		this.anno = anno;
		worldData = new WorldData();
		entityMngr = new EntityManager();
		chunkList = new ArrayList<Chunk>();
		chunkCountWidth = 32;
		chunkCountHeight = 32;
	}

	/**
	 * Gibt den Entity Manager zurück.<br>
	 * Dieser verwaltet alle Entitys.
	 */
	public EntityManager getEntityManager()
	{
		return entityMngr;
	}

	/**
	 * Generiert die Welt nach Zufall.
	 */
	public void genWorld()
	{
		GuiRender gui = (GuiRender) anno.getGuiManager().getGui(GuiRender.class);
		gui.setPorgressBarMaximum(chunkCountHeight * Chunk.getSize());
		for(int y = 0; y < chunkCountHeight; y++)
		{
			for(int x = 0; x < chunkCountWidth; x++)
			{
				chunkList.add(new Chunk(x, y));
			}
		}

		for(int i = 0; i < chunkCountHeight * Chunk.getSize(); i++)
		{
			for(int j = 0; j < chunkCountWidth * Chunk.getSize(); j++)
			{
				int id = (int) (Math.random() * 8);
				if(id >= 0 && id <= 4)
				{
					setBlock(i, j, new BlockGrass());
				}
				else if(id >= 5 && id <= 6)
				{
					setBlock(i, j, new BlockForest());
				}
				else
				{
					setBlock(i, j, new BlockRock());
				}
			}
			gui.setProgressBarPosition(i);
		}
		setBlock(12, 8, new BlockBase());
		EntityLumberjack entity = new EntityLumberjack(1);
		entity.setPosition(12.0F, 8.0F);
		entityMngr.addEntity(entity);
		gui.setProgressBarPosition(gui.getPorgressBarMaximum());
		gui.close();
	}

	/**
	 * Gibt den Block an der angegebenen Position zurück.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 * @return Den angegbenen Block.
	 */
	public Block getBlock(int x, int y)
	{
		return getChunk(getInChunkGrid(x), getInChunkGrid(y)).getBlock(x % Chunk.getSize(), y % Chunk.getSize());
	}

	/**
	 * Gibt die ID des Blocks an der angegebenen Position zurück.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            dis Y-Position
	 * @return Die ID des angegebenen Blocks.
	 */
	public int getBlockID(int x, int y)
	{
		return getBlock(x, y).getBlockID();
	}

	/**
	 * Setzt den angegebenen Block auf die angegebene Position in der Welt.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 * @param block
	 *            der Block, der gesetzt werden soll
	 */
	public void setBlock(int x, int y, Block block)
	{
		getChunk(getInChunkGrid(x), getInChunkGrid(y)).setBlock(x % Chunk.getSize(), y % Chunk.getSize(), block);
	}

	private int getInChunkGrid(int i)
	{
		i -= i % Chunk.getSize();
		return i / Chunk.getSize();
	}

	private Chunk getChunk(int x, int y)
	{
		for(int i = 0; i < chunkList.size(); i++)
		{
			Chunk chunk = chunkList.get(i);
			if(chunk.getCoordinates().x == x && chunk.getCoordinates().y == y)
			{
				return chunk;
			}
		}
		return null;
	}

	/**
	 * Gibt die WorldData zurück.
	 * 
	 * @return Die WorldData.
	 */
	public WorldData getWorldData()
	{
		return worldData;
	}

	/**
	 * Ruft die "onClick" Methode des Blocks an der angegebene Positon auf.
	 * 
	 * @param x
	 *            die X-Position
	 * @param y
	 *            die Y-Position
	 */
	public void onClick(int x, int y)
	{
		getBlock(x, y).onClick(x, y, this);
	}

	/**
	 * Aktuallisiert das Geschehen auf der Welt.
	 */
	public void updateWorld()
	{
		entityMngr.updateEntitys();
	}
}
