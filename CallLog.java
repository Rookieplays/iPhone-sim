import java.util.*;
class CallLog
{
	private ArrayList<CallerID>calls= new ArrayList<CallerID>();
	private int missedCalls,answeredCalls,MadeCalls,allCalls;
	public CallLog()
	{
		this.missedCalls=0;
		this.answeredCalls=0;
		this.MadeCalls=0;
	}
	public CallLog(int missedCalls,int answeredCalls,int MadeCalls)
	{
		this.missedCalls=missedCalls;
		this.answeredCalls=answeredCalls;
		this.MadeCalls=MadeCalls;
	}		
	public void setMissedCalls(int missedCalls)
	{
		this.missedCalls=missedCalls;
	}
	public int getMissedCalls()
	{
		return missedCalls;
	}
	public void setAllCalls(int allCalls)
	{
		this.allCalls=allCalls;
	}
	public int getAllCalls()
	{
		return allCalls;
	}
	public void setAnsweredCalls(int answeredCalls)
	{
		this.answeredCalls=answeredCalls;
	}
	public int getAnswered()
	{
		return answeredCalls;
	}
	public int getMadeCalls()
	{
		return MadeCalls;
	}
	public void setMadeCalls(int MadeCalls)
	{
		this.MadeCalls=MadeCalls;
	}
	public ArrayList<CallerID> getCalls()
	{
		return calls;
	}
	public void addCalls(CallerID id )
	{
		calls.add(id);
	}
	public String toString()
	{
		return "Missed Calls: "+missedCalls+" | Answered Calls: "+ answeredCalls+" | Made Calls: "+MadeCalls+" | All Calls: "+allCalls;
	}
}