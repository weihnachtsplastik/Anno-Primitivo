package src;

public class World
{
	private WorldData worldData;
	private Block worldMap[][];
	private EntityManager entityMngr;

	public World()
	{
		worldMap = new Block[25][17];
		worldData = new WorldData();
		entityMngr = new EntityManager();
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
		for(int i = 0; i < worldMap.length; i++)
		{
			for(int j = 0; j < worldMap[i].length; j++)
			{
				int id = (int) (Math.random() * 8);
				if(id >= 0 && id <= 4)
				{
					id = 0;
				}
				else if(id >= 5 && id <= 6)
				{
					id = 1;
				}
				else
				{
					id = 2;
				}
				worldMap[i][j] = new Block(id);
			}
		}
		worldMap[12][8] = new Block(3);
		entityMngr.addEntity(new EntityLumberjack(1));
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
		return worldMap[x][y];
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
		return worldMap[x][y].getBlockID();
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
		worldMap[x][y].onClick(x, y, this);
	}

	/**
	 * Aktuallisiert das Geschehen auf der Welt.
	 */
	public void updateWorld()
	{
		entityMngr.updateEntitys();
	}
}
