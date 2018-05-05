import javafx.scene.control.*;
class Profile
{
	private String user;
	private String number;
	private Label icon;
	public Profile()
	{
		this.user="user";

		this.number="";
	}
	public Profile(String user,String number)
	{
		this.user=user;

		this.number=number;
	}
	public void setIcon()
	{
		user=user.toUpperCase();
		String names[];
		if(user.contains(" "))
		{
				names=user.split(" ");
				icon=new Label(names[0].charAt(0)+""+names[1].charAt(0)+"");
		}
		else
			icon=new Label(user.charAt(0)+"");

	}
	public void setUser(String user)
	{
		
			this.user=user;
	}
	public void setUser(String fn,String sn)
	{
		if(!(sn.trim().equals(" "))||!(sn.trim().equals(""))||!(sn.equals(" ")))
		this.user=fn+" "+sn;
		else 
			this.user=fn.trim();
	}
	public void setNumber(String number,String regionCode)
	{
		this.number=number.trim();
		if(number.substring(0,2).equals("89")||number.substring(0,2).equals("85")||number.substring(0,2).equals("83")||number.substring(0,2).equals("87")||number.substring(0,2).equals("86")||number.substring(0,2).equals("51")||number.substring(0,2).equals("61"))
		{
			if(regionCode==null||regionCode.equals(""))
			number="(0"+number.substring(0,2)+") "+number.substring(2,number.length()-3)+" "+number.substring(number.length()-3,number.length());
			else
			number="+"+regionCode+" (0"+number.substring(0,2)+") "+number.substring(2,number.length()-3)+" "+number.substring(number.length()-3,number.length());
		}
		else 
			number=number;
		this.number=number;
	} 
	public void setNumber(String number)
	{
		this.number=number.trim();
		if(number.substring(0,2).equals("89")||number.substring(0,2).equals("85")||number.substring(0,2).equals("83")||number.substring(0,2).equals("87")||number.substring(0,2).equals("86")||number.substring(0,2).equals("51")||number.substring(0,2).equals("61"))
		{
			
			number="(0"+number.substring(0,2)+") "+number.substring(2,number.length()-3)+" "+number.substring(number.length()-3,number.length());
		}
		else 
			number=number;
		this.number=number;
	} 
	public Label getLabel()
	{
		return icon;
	}
	public String getUser()
	{
		return user;
	}
	public String getNumber()
	{
		return number;
	}

}