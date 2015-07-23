package alpha;

public class StopPoint
{
	int netID;
	int stpID;
	int sarID;
	int daID;
	Point pntObj;
	String stpDesc;
	
	
	StopPoint(int nID, int stID, int saID, int dID, Point pObj, String stDesc)
	{
		netID = nID;
		stpID = stID;
		sarID = saID;
		daID = dID;
		pntObj = pObj;
		stpDesc = stDesc;
	}
	
	public int getNetID()
	{
		return netID;
	}
	public int getStpID()
	{
		return stpID;
	}
	public int getSarID()
	{
		return sarID;
	}
	public int getDaID()
	{
		return daID;
	}
	public Point getPntObj()
	{
		return pntObj;
	}
	public String stpDesc()
	{
		return stpDesc;
	}
}
