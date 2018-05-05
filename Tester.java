import java.util.*;
import java.io.*;
public class Tester
{
	static Scanner sc=new Scanner(System.in);
	static Contacts contact;
	static ArrayList<ArrayList<String>>Phonebook=new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<String>>ePhonebook=new ArrayList<ArrayList<String>>();
	static Order order=new Order(Phonebook);
	public static void main(String[] args) throws IOException
	{
		loadPhoneBook();
				//Phonebook=order.ascendingOrder("f");
		System.out.println("Phone book loaded..,");
		System.out.println(Phonebook);
		String input="";
		contact=new Contacts();
		System.out.println("Enter First Name: ");
		input=sc.nextLine();
		contact.setFirstname(input);
		System.out.println("Enter Last Name: ");
		input=sc.nextLine();
		contact.setLastname(input);
		while(!(input.matches("[0-9]+")))
		{System.out.println("Enter Phone No. : ");
				input=sc.nextLine();}
				contact.setNumber(Integer.parseInt(input));
		if(Phonebook.get(0).contains(contact.getFirstname())&&Phonebook.get(1).contains(" "+contact.getLastname()))
		{
			
			System.out.println("updating...");
			update(contact.getNumber());	
		}
		else
			{
		if(moreDetails()==false)
			addToPhonebook(contact.getFirstname(),contact.getLastname(),contact.getNumber());
		else
			addToEPhonebook(contact.getFirstname(),contact.getLastname(),contact.getNumber(),contact.getEmail());
		}
		Phonebook.clear();
		ePhonebook.clear();
		loadPhoneBook();
		//System.out.println(order.ascendingOrder("f"));

		Phonebook=order.ascendingOrder("f");
		
		System.out.println(Phonebook);

		getInfo();
		//System.out.println(contact);
		//System.out.println(Phonebook);
		
	}

	public static boolean updateDialog()
	{
		String input="";
		System.out.println("We found a person with the same name in your Phone Book\nDo you want to update the existing Number(y) or add this one to it(n)? y/n");
		input=sc.nextLine();
		if(input.equalsIgnoreCase("y"))
		return true;
		else return false;

	}
	public static void update(int number)throws IOException
	{
		File aFile=new File("Phonebook.txt");
		File bFile=new File("ExtraPhonebook.txt");
		PrintWriter writer=new PrintWriter(aFile);
		PrintWriter aWriter=new PrintWriter(bFile);
		int indexOfName=-1,j=0,i=0,a=0,b=0;
		int count=0,aCount=0;
		Phonebook=order.ascendingOrder("f");
		
		if(updateDialog()==true)
		{
			if(contact.isNewContact()==false)
			{
				if(Phonebook.get(0).contains(contact.getFirstname())&&Phonebook.get(1).contains(" "+contact.getLastname()))
				{
					indexOfName=Phonebook.get(0).indexOf(contact.getFirstname());
					Phonebook.get(2).set(indexOfName," "+number+"");
					while(i<Phonebook.get(0).size())
					{
						writer.println(Phonebook.get(0).get(i)+", "+Phonebook.get(1).get(i)+", "+Phonebook.get(2).get(i));
						i++;
					}writer.close();

					indexOfName=ePhonebook.get(0).indexOf(contact.getFirstname());
					if(indexOfName!=-1)
					{ePhonebook.get(2).set(indexOfName," "+number+"");
										while(j<ePhonebook.get(0).size())
										{
											aWriter.println(ePhonebook.get(0).get(j)+", "+ePhonebook.get(1).get(j)+", "+ePhonebook.get(2).get(j)+", "+ePhonebook.get(3).get(j));
											j++;
										}aWriter.close();
					}else addToEPhonebook(contact.getFirstname(),contact.getLastname(),number,contact.getEmail());
				}else {System.out.println("This is a new contact"); addToPhonebook(contact.getFirstname(),contact.getLastname(),number);}
			}
			else System.out.println("This contact Exists.");
		}
		else
		{
			//ArrayList<ArrayList<String>>temp=new ArrayList<ArrayList<String>>();
			//	temp=Phonebook;
			//	Phonebook.clear();
			System.out.println("getting number of apperances of name...");
			for(int k=0;k<Phonebook.get(0).size();k++)
				{if(Phonebook.get(0).get(k).equals(contact.getFirstname())&&Phonebook.get(1).get(k).equals(" "+contact.getLastname()))
								count++;
					else if(Phonebook.get(1).get(k).contains("("))
						{
							System.out.println("iterations found");
							if(Phonebook.get(0).get(k).equals(contact.getFirstname())&&((Phonebook.get(1).get(k)).substring(0,(Phonebook.get(1).get(k).length()-3))).equals(" "+contact.getLastname()))
								count++;
						}
				}
			System.out.println(count);
				Phonebook.get(0).add(contact.getFirstname());
				Phonebook.get(1).add(contact.getLastname()+"("+(count+1)+")");
				Phonebook.get(2).add(contact.getNumber()+"");
			for(int k=0;k<ePhonebook.get(0).size();k++)
				if(ePhonebook.get(0).get(k).equals(contact.getFirstname())&&ePhonebook.get(1).get(k).equals(" "+contact.getLastname()))
				count++;
				ePhonebook.get(0).add(contact.getFirstname());
				ePhonebook.get(1).add(contact.getLastname()+"("+(count+1)+")");
				ePhonebook.get(2).add(contact.getNumber()+"");
				ePhonebook.get(3).add(contact.getEmail());
				System.out.println("Done.");
			//indexOfName=Phonebook.get(0).indexOf(contact.getFirstname());
			while(a<Phonebook.get(0).size())
					{
						writer.println(Phonebook.get(0).get(a)+", "+Phonebook.get(1).get(a)+", "+Phonebook.get(2).get(a));
						a++;
					}writer.close();

			//indexOfName=ePhonebook.get(0).indexOf(contact.getFirstname());
					while(b<ePhonebook.get(0).size())
					{
						aWriter.println(ePhonebook.get(0).get(b)+", "+ePhonebook.get(1).get(b)+", "+ePhonebook.get(2).get(b)+", "+ePhonebook.get(3).get(b));
						b++;
					}aWriter.close();
		}
	}
	public static void addToPhonebook(String f,String l,int n)throws IOException
	{
		String info=f+", "+l+", "+n+""+"\n";
		System.out.println(Phonebook.get(2)+"<"+n+""+">");
		if(Phonebook.get(2).contains(" "+n+""))
		{
			System.out.println("Number exists!!");
			contact.setIfNewContact(false);
		}
		else 
			{
				Phonebook.get(0).add(f);
				Phonebook.get(1).add(l);
				Phonebook.get(2).add(n+"");
				Phonebook=order.ascendingOrder("f");
		
				writeFile("Phonebook.txt",info);
				contact.setIfNewContact(true);
				
			}
		 
	}
	public static void addToEPhonebook(String f,String l,int n,String email)throws IOException
	{
		String info=f+", "+l+", "+n+""+", "+email+"\n";
		if(ePhonebook.get(2).contains(" "+n+""))
		{
			System.out.println("Number exists!!");
			contact.setIfNewContact(false);
		}
		else 
			{
				ePhonebook.get(0).add(f);
				ePhonebook.get(1).add(l);
				ePhonebook.get(2).add(n+"");
				ePhonebook.get(3).add(email);
				ePhonebook=order.ascendingOrder("f");
		
				writeFile("ExtraPhonebook.txt",info);
				contact.setIfNewContact(true);
				
			}
		 
	}
	public static boolean moreDetails()
	{
		String input="";
		System.out.println("More Details? y/n");
		input=sc.nextLine();
		if(input.equalsIgnoreCase("y"))
		{
			contact.addMoreDetails(true);
			
			while(validEmail(input)==false)
			{	
						System.out.println("Email: ");
						input=sc.nextLine();
						contact.setEmail(input);
			}
			return true;

		}
		else 
		{
			contact.addMoreDetails(false);
			return false;
		}
	}
	public static boolean validEmail(String email)
	{
		String[]domain,address;
		if(email.contains("@")&&email.contains("."))
		{
			System.out.println("Entering test 1..");
			domain=email.split("\u003E");
			address=email.split("@");System.out.println(address.length);
			if(address.length<=2)
			{

				System.out.println("test1: Success");
				System.out.println("Entering test 2..");
				if(domain.length<=3)
					{System.out.println("test2: Success");return true;}
				else {System.out.println("test2: Failure");return false;}
			}
			else
				{System.out.println("test1: Failure");return false;}
		}
		else
			return false;
	}
	public static void loadPhoneBook()throws IOException
	{
		String temp[];
		for(int i=0; i<3;i++)
			Phonebook.add(new ArrayList<String>());
		for(int i=0; i<4;i++)
			ePhonebook.add(new ArrayList<String>());
		File phonebookFile=new File("Phonebook.txt");
		File extraDetailsFile=new File("ExtraPhonebook.txt");
		Scanner fileReader;
		if(phonebookFile.exists())
		{
			fileReader=new Scanner(phonebookFile);
			while(fileReader.hasNext())
			{
				temp=fileReader.nextLine().split(",");
				for (int i=0; i<Phonebook.size();i++ ) 
				{
					Phonebook.get(i).add(temp[i]);	
				
				}
			}fileReader.close();
		}
		else writeFile("Phonebook.txt","First Name, Last Name, No. \n");
		if(extraDetailsFile.exists())
		{
			fileReader=new Scanner(extraDetailsFile);
			while(fileReader.hasNext())
			{
				temp=fileReader.nextLine().split(",");
				for (int i=0; i<ePhonebook.size();i++ ) 
				{
					ePhonebook.get(i).add(temp[i]);	
				
				}
			}fileReader.close();
		}
		else writeFile("ExtraPhonebook.txt","First Name, Last Name, No., Email \n");

	}
	public static void getInfo()
	{
		CallerID caller;
		CallLog CallerLog=new CallLog();
		
		for (int i=0;i<Phonebook.get(0).size();i++ ) 
		{

			int randSelection=(int)(Math.random()*Phonebook.get(0).size());

			caller=new CallerID(Phonebook.get(0).get(randSelection),Integer.parseInt(Phonebook.get(2).get(randSelection).trim()));
			CallerLog.addCalls(caller);
		}
		System.out.println(CallerLog.getCalls());
		ArrayList<CallerID>calls=new ArrayList<CallerID>();
		calls=CallerLog.getCalls();
		CallerLog.setAllCalls(calls.size());
		int c=CallerLog.getAllCalls();
		
			int called=0;System.out.println(c);
			called=(int)(Math.random()*c);System.out.println(called);
			CallerLog.setMissedCalls(called);
			c=c-called;
			 called=(int)(Math.random()*c);System.out.println(called);
			CallerLog.setAnsweredCalls(called);
			c=c-called;
			System.out.println(called);
			CallerLog.setMadeCalls(called);
			
		System.out.println(CallerLog);
		

		
	}
	public static void writeFile(String filename,String info)throws IOException
	{
		FileWriter writer=new FileWriter(filename,true);
		writer.write(info);
		writer.close();
	}
	public static void overWriteFile(String filename,String info)throws IOException
	{
		FileWriter writer=new FileWriter(filename);
		writer.write(info);
		writer.close();
	}
}