import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

public class ToDoList {

	private static InputStreamReader input = new InputStreamReader(System.in);
	private static BufferedReader reader = new BufferedReader(input);
	
	//size of array
	private  static final int N = 100;
	//Record Count
	private static int intRecordCount = 0;
	//array of strings 
	private static String arr[] = new String[N];

	public static void main(String[] args) {
		MainMenu();

	}
	
	private static void MainMenu()
	{
		//variables
		int intMenuChoice = 0;
		
		try
		{
			do
			{
				System.out.println("\nMain Menu");
				System.out.println("==========");
				System.out.println("1. Enter Item into To Do List");
				System.out.println("2. Show items in To To List");
				System.out.println("3. Exit");
				//Accept Choice
				System.out.println("Please Select an Option");
				intMenuChoice = Integer.parseInt(reader.readLine());
				
				//decision for menu
				if (intMenuChoice == 1)
				{
					if (intRecordCount < N)
					{
						System.out.println("\n\n\nNow Accepting Items For To Do List\nType 'exit' for main menu ");
						AcceptDetails();
					}
					else
					{
						System.out.println("\n\n\nError - no Room for additional records ");
						 MainMenu();
					}
				}
				else if (intMenuChoice == 2)
				{
					if (intRecordCount > 0)
					{
						System.out.println("\n\n\nSearching For To Do List");
						ShowDetails();
					}
					else
					{
						System.out.println("\n\n\nError - No Detials Stored ");
						 MainMenu();
					}
				}
				else if (intMenuChoice == 3)
				{
						System.out.println("\n\n\nNow Exiting");	
				}
					else
					{
						System.out.println("\n\n\nInvalid Menu Option");
					}
				}while (intMenuChoice == 3);
		}
			catch (Exception ex)
			{
				System.out.println("\n\n\nInvalid Menu Option");
				 
				}
			MainMenu();
	}
	
	private static void AcceptDetails() throws IOException
	{
				//Accept the information 
			System.out.print ("Enter To Do to add to list: ");
			
			arr[intRecordCount] = reader.readLine();
			//exit case
			if ( arr[intRecordCount].equals("exit"))
			{
				System.out.println("\nInformation saved");
		     MainMenu();
			}
			else 
			intRecordCount++;
			AcceptDetails();
    }
			
	private static void ShowDetails()
	{
		
		System.out.println ("\n\nTo Do List ");
		System.out.println("==========");
		for (int i = 0; i < intRecordCount; i ++)
		{
			System.out.println((i+1) + ". " + arr[i]);
		}
		
		 MainMenu();
	}
}
