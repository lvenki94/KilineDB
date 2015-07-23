package alpha;

public class Point
{
	int pntID;
	int pntX;
	int pntY;
	
	Point(int id, int X, int Y)
	{
		pntID = id;
		pntX = X;
		pntY = Y;
	}
	
	public int getPntID()
	{
		return pntID;
	}
	public int getPntX()
	{
		return pntX;
	}
	public int getPntY()
	{
		return pntY;
	}
}
