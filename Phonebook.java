import java.util.*;
import java.io.*;
class Phonebook
{
	static Scanner sc=new Scanner(System.in);
	static Contacts contact;
	static  ArrayList<ArrayList<String>>PhonebookList=new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<String>>ePhonebookList=new ArrayList<ArrayList<String>>();
	public Phonebook()throws IOException
	{
		loadPhonebookList();
	
		System.out.println("Phone book loaded..,");
		System.out.println(PhonebookList);
		
	}
	public ArrayList<ArrayList<String>> getPhonebook()throws IOException
	{
		 ArrayList<ArrayList<String>>temp;
		 temp=PhonebookList;
	//	loadPhonebookList();
		return PhonebookList;
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
		if(updateDialog()==true)
		{
			if(contact.isNewContact()==false)
			{
				if(PhonebookList.get(0).contains(contact.getFirstname())&&PhonebookList.get(1).contains(contact.getLastname()+" "))
				{
					indexOfName=PhonebookList.get(0).indexOf(contact.getFirstname());
					PhonebookList.get(2).set(indexOfName," "+number+"");
					while(i<PhonebookList.get(0).size())
					{
						writer.println(PhonebookList.get(0).get(i)+", "+PhonebookList.get(1).get(i)+", "+PhonebookList.get(2).get(i));
						i++;
					}writer.close();
					indexOfName=ePhonebookList.get(0).indexOf(contact.getFirstname());
					ePhonebookList.get(2).set(indexOfName," "+number+"");
					while(j<ePhonebookList.get(0).size())
					{
						aWriter.println(ePhonebookList.get(0).get(j)+", "+ePhonebookList.get(1).get(j)+", "+ePhonebookList.get(2).get(j)+", "+ePhonebookList.get(3).get(j));
						j++;
					}aWriter.close();
				}else System.out.println("This is a new contact");
			}
			else System.out.println("This contact Exists.");
		}
		else
		{
			//ArrayList<ArrayList<String>>temp=new ArrayList<ArrayList<String>>();
			//	temp=PhonebookList;
			//	PhonebookList.clear();
			System.out.println("getting number of apperances of name...");
			for(int k=0;k<PhonebookList.get(0).size();k++)
				{if(PhonebookList.get(0).get(k).equals(contact.getFirstname())&&PhonebookList.get(1).get(k).equals(" "+contact.getLastname()))
								count++;
					else if(PhonebookList.get(1).get(k).contains("("))
						{
							System.out.println("iterations found");
							if(PhonebookList.get(0).get(k).equals(contact.getFirstname())&&((PhonebookList.get(1).get(k)).substring(0,(PhonebookList.get(1).get(k).length()-3))).equals(" "+contact.getLastname()))
								count++;
						}
				}
			System.out.println(count);
				PhonebookList.get(0).add(contact.getFirstname());
				PhonebookList.get(1).add(contact.getLastname()+"("+(count+1)+")");
				PhonebookList.get(2).add(contact.getNumber()+"");
			for(int k=0;k<ePhonebookList.get(0).size();k++)
				if(ePhonebookList.get(0).get(k).equals(contact.getFirstname())&&ePhonebookList.get(1).get(k).equals(" "+contact.getLastname()))
				count++;
				ePhonebookList.get(0).add(contact.getFirstname());
				ePhonebookList.get(1).add(contact.getLastname()+"("+(count+1)+")");
				ePhonebookList.get(2).add(contact.getNumber()+"");
				ePhonebookList.get(3).add(contact.getEmail());
				System.out.println("Done.");
			//indexOfName=PhonebookList.get(0).indexOf(contact.getFirstname());
			while(a<PhonebookList.get(0).size())
					{
						writer.println(PhonebookList.get(0).get(a)+", "+PhonebookList.get(1).get(a)+", "+PhonebookList.get(2).get(a));
						a++;
					}writer.close();

			//indexOfName=ePhonebookList.get(0).indexOf(contact.getFirstname());
					while(b<ePhonebookList.get(0).size())
					{
						aWriter.println(ePhonebookList.get(0).get(b)+", "+ePhonebookList.get(1).get(b)+", "+ePhonebookList.get(2).get(b)+", "+ePhonebookList.get(3).get(b));
						b++;
					}aWriter.close();
		}
	}
	public static void addToPhonebookList(String f,String l,int n)throws IOException
	{
		String info=f+", "+l+", "+n+""+"\n";
		System.out.println(PhonebookList.get(2)+"<"+n+""+">");
		if(PhonebookList.get(2).contains(" "+n+""))
		{
			System.out.println("Number exists!!");
			contact.setIfNewContact(false);
		}
		else 
			{
				PhonebookList.get(0).add(f);
				PhonebookList.get(1).add(l);
				PhonebookList.get(2).add(n+"");
				writeFile("Phonebook.txt",info);
				contact.setIfNewContact(true);
				
			}
		 
	}
	public static void addToEPhonebookList(String f,String l,int n,String email)throws IOException
	{
		String info=f+","+l+","+n+""+","+email+"\n";
		if(ePhonebookList.get(2).contains(" "+n+""))
		{
			System.out.println("Number exists!!");
			contact.setIfNewContact(false);
		}
		else 
			{
				ePhonebookList.get(0).add(f);
				ePhonebookList.get(1).add(l);
				ePhonebookList.get(2).add(n+"");
				ePhonebookList.get(3).add(email);
				writeFile("ExtraPhonebook.txt",info);
				contact.setIfNewContact(true);
				
			}
		 
	}
	
	
	private void loadPhonebookList()throws IOException
	{
		String temp[];
		for(int i=0; i<3;i++)
			PhonebookList.add(new ArrayList<String>());
		for(int i=0; i<4;i++)
			ePhonebookList.add(new ArrayList<String>());
		File PhonebookListFile=new File("Phonebook.txt");
		File extraDetailsFile=new File("ExtraPhonebook.txt");
		Scanner fileReader;
		if(PhonebookListFile.exists())
		{
			fileReader=new Scanner(PhonebookListFile);
			while(fileReader.hasNext())
			{
				temp=fileReader.nextLine().split(",");
				for (int i=0; i<PhonebookList.size();i++ ) 
				{
					PhonebookList.get(i).add(temp[i]);	
					
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
				for (int i=0; i<ePhonebookList.size();i++ ) 
				{
					ePhonebookList.get(i).add(temp[i]);	
					
				}
			}fileReader.close();
		}
		else writeFile("ExtraPhonebook.txt","First Name, Last Name, No., Email \n");

	}
	private void getInfo()
	{
		CallerID caller;
		CallLog CallerLog=new CallLog();
		
		for (int i=0;i<PhonebookList.get(0).size();i++ ) 
		{

			int randSelection=(int)(Math.random()*PhonebookList.get(0).size());

			caller=new CallerID(PhonebookList.get(0).get(randSelection),Integer.parseInt(PhonebookList.get(2).get(randSelection).trim()));
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
	private static void writeFile(String filename,String info)throws IOException
	{
		FileWriter writer=new FileWriter(filename,true);
		writer.write(info);
		writer.close();
	}
}
