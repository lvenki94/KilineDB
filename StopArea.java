package alpha;

import java.util.LinkedList;
import java.util.ListIterator;

public class StopArea 
{
	int netID;
	int sarID;
	int sarPri;
	String sarName;
	LinkedList<StopPoint> stpPntLL = new LinkedList<StopPoint>();
	
	StopArea(int nID, int saID, String saName, int saPri)
	{
		netID = nID;
		sarID = saID;
		sarName = saName;
		sarPri  = saPri;
	}
	
	public int getNetID()
	{
		return netID;
	}
	
	public int getSarID()
	{
		return sarID;
	}
	
	public String getSarName()
	{
		return sarName;
	}
	
	public int getSarPri()
	{
		return sarPri;
	}
	
	/**
	 * Add a StopPoint Object to the StopPoint LinkedList
	 * @param stPointObj StopPoint Object to be added to the List.
	 */
	
	public void addStopPoint(StopPoint stPointObj)
	{
		stpPntLL.add(stPointObj);
	}
	
	/**
	 * Returns the StopPoint Object specified by the StopPoint ID
	 * @param stpID StopPoint ID of the StopPoint Object Required
	 * @return StopPoint Object 
	 */
	
	public StopPoint getStopPointObj(int stpID)
	{
		StopPoint ret = null;
		if(getStpPntLLSize() != 0)
		{
			StopPoint stpObj = stpPntLL.get(0);
			
			ListIterator<StopPoint> itr = stpPntLL.listIterator();
			
			while(itr.hasNext())
			{
				stpObj = itr.next();
				if(stpObj.getStpID() == stpID)
				{
					ret = stpObj;
					break;
				}
			}
			
		}
		else
		{
			ret = null;
		}
		
		return ret;
	}
	
	public int getStpPntLLSize()
	{
		return stpPntLL.size();
	}
}

