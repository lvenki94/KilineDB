package alpha;

import java.util.LinkedList;
import java.util.ListIterator;

public class Route 
{
	int netID;
	int lneID;
	int rutID;
	LinkedList<Link> lnkLL = new LinkedList<Link>();
	LinkedList<StopPoint> stPntLL = new LinkedList<StopPoint>();
	
	Route(int nID, int lnID, int rtID)
	{
		netID = nID;
		lneID = lnID;
		rutID = rtID;
	}
	
	public int getNetID()
	{
		return netID;
	}
	public int getLneID()
	{
		return lneID;
	}
	public int getRutID()
	{
		return rutID;
	}
	
	/**
	 * Returns the StopPoint Object of the Specified StopPoint ID
	 * @param stpID StopPoint ID of the Required StopPoint Object
	 * @return StopPoint Object Required for the specified StopPoint ID
	 */
	public StopPoint getStpObj(int stpID)
	{
		StopPoint stpObj = stPntLL.get(0);
		
		ListIterator<StopPoint> itr = stPntLL.listIterator();
		
		while(itr.hasNext())
		{
			stpObj = itr.next();
			if(stpObj.getStpID() == stpID)
			{
				break;
			}
		}
		return stpObj;
	}
	
	/**
	 * Adds a Link Object to the Link Linked List
	 * @param lnkObj Link Object to be added.
	 */
	
	public void addLink(Link lnkObj)
	{
		lnkLL.add(lnkObj);
	}
	
	/**
	 * Adds a StopPoint Object to the StopPoint Linked List
	 * @param stPntObj StopPoint Object to be added.
	 */
	
	public void addStopPoint(StopPoint stPntObj)
	{
		stPntLL.add(stPntObj);
	}
}

