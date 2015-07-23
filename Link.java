package alpha;

public class Link 
{
	int lnkID;
	Point pntBegin;
	Point pntEnd;
	String lnkDesc;
	String lnkDate;
	
	
	Link(int lkID, Point ptBegin, Point ptEnd, String lkDesc, String lkDate)
	{
		lnkID = lkID;
		pntBegin = ptBegin;
		pntEnd = ptEnd;
		lnkDesc = lkDesc;
		lnkDate = lkDate;
	}
	
	public int getlnkID()
	{
		return lnkID;
	}
	public Point getPntBegin()
	{
		return pntBegin;
	}
	public Point getPntEnd()
	{
		return pntEnd;
	}
	public String getPntDesc()
	{
		return lnkDesc;
	}
	public String getPntDate()
	{
		return lnkDate;
	}
}
