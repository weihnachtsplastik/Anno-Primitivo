package src;

import main.Anno;

public class AnnoRunnable implements Runnable
{
	private Anno anno;

	public AnnoRunnable(Anno anno)
	{
		this.anno = anno;
	}

	@Override
	public void run()
	{
		anno.run();
	}
}
