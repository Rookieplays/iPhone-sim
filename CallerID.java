import java.time.*;
class CallerID extends CallLog
{
	private String callerName;
	private LocalTime timeCalled;
	private int  callerNumber;
	public CallerID(String callerName, int callerNumber)
	{
		this.callerName=callerName;
		this.callerNumber=callerNumber;
		timeCalled=LocalTime.now();	
	}
	public void setCallerName(String callerName)
	{
		this.callerName=callerName;
	}
	public String getCallerName()
	{
		return callerName;
	}
	public int getCallerNumber()
	{
		return callerNumber;
	}
	public void setCallerNumber(int callerNumber)
	{
		this.callerNumber=callerNumber;
	}
	public LocalTime getTimeCalled()
	{
		return timeCalled;
	}
	public String toString()
	{
		return callerName+","+callerNumber+","+timeCalled+"\n";
	}
}