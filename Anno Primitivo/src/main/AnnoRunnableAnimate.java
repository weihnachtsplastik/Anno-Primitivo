package main;


public class AnnoRunnableAnimate implements Runnable
{
	private Anno anno;

	public AnnoRunnableAnimate(Anno anno)
	{
		this.anno = anno;
	}

	@Override
	public void run()
	{
		anno.run();
	}
}
