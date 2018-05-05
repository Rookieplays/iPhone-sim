class Contacts
{
	private String firstName,lastName,email;
	private boolean newContact,moreDetails;
	private int number;
	public Contacts()
	{
		this.firstName="Unknown";
		this.lastName="Unknown";
		this.email="Unknown";
		this.newContact=false;
		this.moreDetails=false;
		this.number=(+353);
	}
	public Contacts(String firstName, String lastName, boolean newContact, int number)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.newContact=newContact;
		this.number=number;
	}
	public String getFirstname()
	{
		return firstName;
	}
	public void setFirstname(String firstName)
	{
		this.firstName=firstName;
	}
	public String getLastname()
	{
		return lastName;
	}
	public void setLastname(String lastName)
	{
		this.lastName=lastName;
	}
	public boolean isNewContact()
	{
		return newContact;
	}
	public void setIfNewContact(boolean newContact)
	{
		this.newContact=newContact;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number=number;
	}
	public void addMoreDetails(boolean moreDetails)
	{
		this.moreDetails=moreDetails;
	}
	public boolean isMoreDetais()
	{
		return moreDetails;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	public String toString()
	{
		return "First Name: "+firstName+" | Last Name: "+lastName+" | Phone No. :"+number+" New Contact? : "+newContact;
	}
}