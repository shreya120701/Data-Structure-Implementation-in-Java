//DATA STRUCTURE IMPLEMENTATION IN JAVA
import java.io.*;
import java.util.Scanner;

class S_Patient
{
	int data;
	Node next;

	S_Patient(){};
}

class Node extends S_Patient			
{

	String name;
	String phoneno;
	String age;
	String gen;
	String problem;

	
	Node(){};
	Node(int dd,String nn,String pp,String aa,String gg,String rr)
	{
		data = dd;
		name = nn;
		phoneno = pp;
		age = aa;
		gen = gg;
		problem = rr;
	}
}

class LinkedList 
{
	Node head;
	
	public void insert(int data,String name,String phoneno,String age,String gen,String problem)
	{
		Node node = new Node();
		node.data = data;
		node.name = name;
		node.phoneno = phoneno;
		node.age = age;
		node.gen = gen;
		node.problem = problem;
		node.next = null;
		
		if(head==null)
		{
			head = node;
		}
		else
		{
			Node n = head;
			while(n.next!=null)
			{
				n = n.next;
			}
			n.next =  node;
		}
		
	}
	public void AddPat(int data)
	{
				
		Scanner sc= new Scanner(System.in);   
		System.out.print("Enter name: ");  
		String str1= sc.nextLine();
		
		System.out.print("Enter phone no: ");  
		String str2= sc.nextLine();  
		
		System.out.print("Enter age: ");  
		String str3= sc.nextLine();  
		
		System.out.print("Enter gender: ");  
		String str4= sc.nextLine();  
		
		System.out.print("Enter problem/disease: ");  
		String str5= sc.nextLine();
		
		Node node = new Node(data, str1, str2, str3, str4,str5);		
		
		node.next = null;
		node.next = head;
		head = node;
	}
	
	public void AddPatSpe(int index,int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(index==0)
		{
			AddPat(data);
		}
		else{
		Node n = head;
		for(int i=0;i<index-1;i++)
		{
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
		}
		System.out.println("patient in emergency; Loaded with his ID only...");
	}
	
	public void CleanUp()
	{
		Scanner sc1= new Scanner(System.in);
		System.out.println("which record you want to delete?"); 
		int index= sc1.nextInt();
		
		if(index==0)
		{
			head = head.next;
		}
		else
		{
			Node n = head;
			Node n1 = null;
			for(int i=0;i<index-1;i++)
			{
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			
			n1 = null;
		}
		sc1.close();
	}
	
	public void PrintList()
	{
		Node node = head;
		
		while(node.next!=null)
		{
		
			System.out.println(node.data+"  "+node.name+"  "+node.phoneno+"  "+node.age+"  "+node.gen+"  "+node.problem);
			node = node.next;
		}
		System.out.println(node.data+"  "+node.name+"  "+node.phoneno+"  "+node.age+"  "+node.gen+"  "+node.problem);
	}
	
	public void SearchList()
	{
		Node node = head;
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the Patient name:");
		 String str=sc.nextLine();
		 System.out.println(str);
		
		while(node.next!=null)
		{
		
			if(str.equals(node.name)) {
			System.out.println(node.data+"  "+node.name+"  "+node.phoneno+"  "+node.age+"  "+node.gen+"  "+node.problem);}
			node = node.next;
		}
		if(str.equals(node.name)) 
		{
			System.out.println(node.data+"  "+node.name+"  "+node.phoneno+"  "+node.age+"  "+node.gen+"  "+node.problem);
		}
		
	}
}


public class Runner 
{
	static void welcomescreen()
	{
    	System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("|                WELCOME                 |");
        System.out.println("|                 NHCE                   |");
        System.out.println("|             MINI PROJECT               |");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        
        System.out.println("\n\n\n Enter any key");
        
        Scanner sc= new Scanner(System.in);
        System.out.println("");
		String num = sc.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");	
    }

	public static void main(String[] args) throws IOException
	{
		
		//===========================
				welcomescreen();
		//===========================
		int min = 10;  
		int max = 99; 
		int b=0;
		LinkedList list = new LinkedList();  
	    
		
		
			
	    FileOutputStream file = new FileOutputStream("output.dat");  
		DataOutputStream data = new DataOutputStream(file); 
		try
		{
		FileInputStream fstream = new FileInputStream("input.dat");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;


		
		while ((strLine = br.readLine()) != null)   
		{
			  String[] stringarray = strLine.split(",");      
				String name = stringarray[0];
				String phone= stringarray[1];
				String age=stringarray[2];
				String gender=stringarray[3];
				String problem=stringarray[4];
		
		
		list.insert((int)(Math.random()*(max-min+1)+min), name, phone, age,gender,problem);
		++b;
		System.out.println("loaded  "+b+"  record");
		data.writeChars("loaded  "+b+"  record \n");

		}		
		  in.close();
		  br.close();
	    }
		catch (Exception e)
		{//Catch exception if any
	  System.err.println("Error: " + e.getMessage());
	  data.writeChars("Error: \n" + e.getMessage());
	  }
		//====================>>>>		
		Scanner input= new Scanner(System.in);
		System.out.println("do you want to add any more records?");
		data.writeChars("do you want to add any more records? \n");
		char in= input.next().charAt(0);
		if(in == 'y' || in == 'Y')
		 { 
		 System.out.println("yes, please enter next record");
		 data.writeChars("yes, please enter next record \n");
		
		//====================>>>>
		
		int a=1;
		Scanner sc= new Scanner(System.in);
		
		while(a==1)
		{
			System.out.println("enter the option:\noption 1- With patient details\noption 2- W/O patient details");
			data.writeChars("enter the option(1 for insert at begin, 2 at choosen location): \n");
			int num = sc.nextInt();
			switch(num)
			{
			case 1:
				list.AddPat((int)(Math.random()*(max-min+1)+min));
				break;
				
			case 2:
				System.out.println("where do you want to insert?");
				data.writeChars("where do you want to insert? \n");
				int loc = sc.nextInt();

				list.AddPatSpe(loc, (int)(Math.random()*(max-min+1)+min));
				break;
				
			default:
				System.out.println("it's not a valid option");
				data.writeChars("it's not a valid option \n");
				break;
			}
			
			Scanner input1= new Scanner(System.in);
			System.out.println("do you want to add any more records?");
			data.writeChars("do you want to add any more records? \n");
			char in1= input1.next().charAt(0);
			if(in1 == 'y' || in1 == 'Y')
			 { System.out.println("yes, please enter next record");
			 data.writeChars("yes, please enter next record \n");}
			if(in1 == 'n' || in1 == 'N')
			 { --a; }
			
		}
		}		    
		
		//====================>>>>


		System.out.println("======================================");
		data.writeChars("====================================== \n");
		list.PrintList();
		//===================
		//System.out.println("welcome to search");		
		System.out.println("do you want to search a record?");
		data.writeChars("do you want to search a record? \n");
		char in1= input.next().charAt(0);
		if(in1 == 'y' || in1 == 'Y')
		 {
			list.SearchList();
		 }
		
		data.writeChars("All records are uploaded successfully \n");
		System.out.println("======================================");
		data.writeChars("====================================== \n");
		
		System.out.println("do you want to delete a record?");
		data.writeChars("do you want to delete a record? \n");
		char in2= input.next().charAt(0);
		if(in2 == 'y' || in2 == 'Y')
		 { 
			list.CleanUp();
		 }
		
		list.PrintList();
		System.out.println("Succcess..."); 
		data.writeChars("Succcess...");  
		data.flush();  
        data.close();
        file.close();
        
        
	}

}
