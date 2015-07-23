package alpha;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Application
{
	LinkedList<Point> pntLL = new LinkedList<Point>();
	LinkedList<Network> netLL = new LinkedList<Network>();
	LinkedList<Link> lnkLL = new LinkedList<Link>();
	
	public void dataExtract(Application appObj)throws IOException
	{	
		Extract ext = new Extract();
		ext.extractPoint(appObj);
		ext.extractNetwork(appObj);
		ext.extractStopArea(appObj);
		ext.extractStopPoint(appObj);
		ext.extractLink(appObj);
		ext.extractLine(appObj);
		ext.extractRoute(appObj);
		ext.extractStopPointToRoute(appObj);
		ext.extractLinkToRoute(appObj);
		
		getNumberOfLinesOnNetwork(2);
		getTotalRoutesOnNetwork(2);
		getBusStops(2,1,1);
		getMaxRoute(2);
		getRouteAndLine(3672,352);
	}
		
	
	/**
	 * Returns the Point Object of the specified Point ID
	 * @param pntID Point ID of the required Point Object
	 * @return Point Object of the specified Point ID
	 */
	
	public Point getPntObj(int pntID)
	{
		Point pntObj = pntLL.get(0);
		
		ListIterator<Point> itr = pntLL.listIterator();
		
		while(itr.hasNext())
		{
			pntObj = itr.next();
			if(pntObj.getPntID() == pntID)
			{
				break;
			}
		}
		return pntObj;
	}
	
	/**
	 * 	Return the Link Object of the Specified Link ID
	 * @param lnkID Link ID of the Link Object Required
	 * @return Link Object required for the specified Link ID
	 */
	
	public Link getLinkObj(int lnkID)
	{
		Link lnkObj = lnkLL.get(0);
		
		ListIterator<Link> itr = lnkLL.listIterator();
		
		while(itr.hasNext())
		{
			lnkObj = itr.next();
			if(lnkObj.getlnkID() == lnkID)
			{
				break;
			}
		}
		return lnkObj;
	}
	
	/**
	 * 	Return the Network Object of the Specified Network ID
	 * @param netID Network ID of the Network Object Required
	 * @return Network Object required for the specified Network ID
	 */
	
	public Network getNetworkObj(int netID)
	{
		Network netObj = null;
		
		ListIterator<Network> itr = netLL.listIterator();


		while(itr.hasNext())
		{
			netObj = itr.next();
			if(netObj.getNetID() == netID)
			{
				break;
			}
		}
		
		return netObj;
	}
	
	/**
	 * Adds the Point Object to the Point Linked List
	 * @param pntObj Point to be added
	 */
	
	public void addPoint(Point pntObj)
	{
		pntLL.add(pntObj);
	}
	
	/**
	 * Adds the Link Object to the Link Linked List
	 * @param lnkObj Link Object to be added
	 */
	
	public void addLink(Link lnkObj)
	{
		lnkLL.add(lnkObj);
	}
	
	/**
	 * Adds the Network Object to the Network List
	 * @param netObj Network Object to be added
	 */
	
	public void addNetwork(Network netObj)
	{
		netLL.add(netObj);
	}
	
	public void getNumberOfLinesOnNetwork(int netID)
	{
		Network netObj = null;
		
		netObj = getNetworkObj(netID);
		
		System.out.println(netObj.lneLL.size());
	}
	
	public void getTotalRoutesOnNetwork(int netID)
	{
		Network netObj = null;
		Line lneObj = null;
		
		int count = 0;
		
		netObj = getNetworkObj(netID);
		for(int i = 0 ; i < netObj.lneLL.size() ; i++)
		{
			lneObj = netObj.lneLL.get(i);
			count = count + lneObj.rutLL.size();
		}
		
		System.out.println(count);
	}

	public void getBusStops(int netID, int lneID, int rutID)
	{
		Network netObj = getNetworkObj(netID);
		Line lneObj = netObj.getLineObj(lneID);
		Route rteObj = lneObj.getRutObj(rutID);
		StopPoint stpObj = rteObj.stPntLL.get(0);
		
		for(int i = 0 ; i < rteObj.stPntLL.size() ; i++)
		{
			stpObj = rteObj.stPntLL.get(i);
			if(i == 0)
			{
				System.out.print(stpObj.stpID);
			}
			else
			{
				System.out.print(","+stpObj.stpID);
			}
		}
		System.out.println();
	}
	
	public void getMaxRoute(int netID)
	{
		int large = 0;
		
		Network netObj = getNetworkObj(netID);
		Line lneObj = null;
		Route rteObj = null;
		Route rteFObj = null;
		
		for(int i = 0 ; i < netObj.lneLL.size() ; i++)
		{
			lneObj = netObj.lneLL.get(i);
			for(int j = 0 ; j < lneObj.rutLL.size() ; j++)
			{
				rteObj = lneObj.rutLL.get(j);
				if(rteObj.lnkLL.size() > large)
				{
					large = rteObj.lnkLL.size();
					rteFObj = rteObj;
				}
			}
		}
		
		
		Link lnkObj = lnkLL.get(0);
		Point pntSObj = pntLL.get(0);
		Point pntEObj = pntLL.get(0);
		
		int pntBX, pntBY, pntEX, pntEY, distance = 0, a = 0, b = 0;
		
		for(int i = 0 ; i < rteFObj.lnkLL.size() ; i++)
		{
			lnkObj = rteFObj.lnkLL.get(i);
			
			
			
			pntSObj = lnkObj.getPntBegin();
			pntEObj = lnkObj.getPntEnd();
			
			pntBX = pntSObj.getPntX();
			pntBY = pntSObj.getPntY();
			
			pntEX = pntEObj.getPntX();
			pntEY = pntEObj.getPntY();
			
			a = Math.abs(pntBX - pntEX);
			b = Math.abs(pntBY - pntEY);
			
			distance = distance + (int)Math.sqrt((a * a) + (b * b));
		}
		
		System.out.println(rteFObj.getLneID()+","+rteFObj.getRutID()+","+distance);
	}
	
	public void getRouteAndLine(int src, int dest)
	{
		Network netObj = null;
		Line lneObj = null;
		Route rteObj = null;
		StopPoint stpSObj = null;
		StopPoint stpFObj = null;
		
		int flag = 0;
		
		for(int i = 0 ; i < netLL.size() ; i++)
		{
			netObj = netLL.get(i);
			for(int j = 0 ; j < netObj.lneLL.size() ; j++)
			{
				lneObj = netObj.lneLL.get(j);
				flag = 0;
				for(int k = 0 ; k < lneObj.rutLL.size() ; k++)
				{
					rteObj = lneObj.rutLL.get(k);
					stpSObj = rteObj.getStpObj(src);
					stpFObj = rteObj.getStpObj(dest);
					if(stpSObj.getStpID() == src)
					{
						flag++;
					}
					if(stpFObj.getStpID() == dest)
					{
						flag++;
					}
					if(flag == 2)
					{
						break;
					}
				}
				if(flag == 2)
				{
					break;
				}
			}
			if(flag == 2)
			{
				break;
			}
		}
		System.out.println(rteObj.getLneID()+","+rteObj.getRutID());
	}
}
