package src;

import java.awt.Color;
import java.awt.Graphics;

public class EntityLumberjack extends Entity
{
	public EntityLumberjack(int id)
	{
		super(id);
	}
	
	@Override
	public void paint(Graphics g, float zoom)
	{
		g.setColor(Color.blue);
		g.fillOval((int) (x * 32 * zoom), (int) (y * 32 * zoom), (int) (16 * zoom), (int) (16 * zoom));
	}
	
	@Override
	public void updateEntity()
	{
		x += 0.03125;
	}
}
