package firestation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by John Creaner on 28/01/2021 COMMENTS ABOUT PROGRAM HERE
 */


public class Main
{
   // initializing tasks
   static Task sweepFloor;
   static Task emptyTrash;
   static Task washFireEngine1;
   static Task washFireEngine2;
   static Task serviceBothFireEngines;


   public static void main(String[] args)
   {

		/* Creating objects of the different tasks
		With a frequency of everyday, every other day, every week and every month */
      emptyTrash = new RecurringTask("Empty the Trash", "01-02-2021", 2);
      sweepFloor = new RecurringTask("Sweep the Floors", "01-01-2021", 1);
      washFireEngine1 = new RecurringTask("Wash Fire Engine One", "01-07-2021", 7);
      washFireEngine2 = new RecurringTask("Wash Fire Engine Two", "01-14-2021", 7);
      serviceBothFireEngines = new RecurringTask("Service Both Fire Engines", "01-28-2021", 28);

      // creating 2 arrays with of the crews with 7 members each
      Individual[] individualsCrewOne = {new Individual(), new Individual(), new Individual(), new Individual(),
            new Individual(), new Individual(), new Individual()};
      Individual[] individualsCrewTwo = {new Individual(), new Individual(), new Individual(), new Individual(),
            new Individual(), new Individual(), new Individual()};

      //Creating 2 objects as crew1 and crew2 and passing the arrays of individuals
      Crew crewOne = new Crew(individualsCrewOne);
      Crew crewTwo = new Crew(individualsCrewTwo);

      // Creating an arraylist adding each task to it
      ArrayList<Task> allTasks = new ArrayList<>();
      allTasks.add(sweepFloor);
      allTasks.add(emptyTrash);
      allTasks.add(washFireEngine1);
      allTasks.add(washFireEngine2);
      allTasks.add(serviceBothFireEngines);

      // calling the welcome method
      welcomeMessage();
      //Creating instance of scanner class to take user input.
      Scanner keyboard = new Scanner(System.in);
      // Using a try catch to catch invalid input
      try
      {
         //creating a boolean to be an exit criteria for the do-while loop
         boolean quit = false;
         //opening a do while loop to continue running through the menu until the user request to quit.
         do
         {
            //calling the menu method to print out the menu.
            menu();
            //recording next user int input and storing it to choice
            int choice = keyboard.nextInt();
            // Taking in the choice from the keyboard and putting into switch statement
            switch (choice)
            {
               case 1:
                  // Creating an enhanced for loop to go through tasks and print them out
                  for (Task t : allTasks)
                  {
                     System.out.println(t.getDescription());
                  }
                  break;
               case 2:
                  // Asking user to enter a date in correct format
                  System.out.println("Please enter the date in the following format (yyyy-mm-dd)");
                  //this keyboard nextLine has to be here due to a bug with nextLine after nextInt
                  keyboard.nextLine();
                  // reading in a string date from the keyboard
                  String date = keyboard.nextLine();
                  //Storing the response from the getTasksFromDate method to an ArrayList.
                  ArrayList<Task> tasksOnDate = getTasksFromDate(date);
                  System.out.println("The Tasks on " + date + " are as follows:");
                  //For loop to print out tasks description and date
                  for (Task t : tasksOnDate)
                  {
                     System.out.println(t.getTaskId() + " " + t.getDescription());
                  }
                  break;
               case 3:
                  // When user chooses to leave the menu the system quits
                  System.out.println("Thanks for using the system");
                  //quit true to exit loop
                  quit = true;
                  break;
               default:
                  System.out.println("Invalid choice, please choose again");
            }
         } while (!quit);
      } catch (InputMismatchException e) //This will catch if the user enters an integer value for choice.
      {
         System.out.println(
               "Input invalid, please only enter a number between 1 and 3. Restart the system to try again");
      }

   }

   public static void welcomeMessage()
   {
      // method printing out the welcome message
      System.out.println();
      System.out.println("Welcome to the Fire Station Task Schedule Application");
      System.out.println();

   }

   public static void menu()
   {
      // method printing out the menu options
      System.out.println("Please choose from one of the following options:");
      System.out.println();
      System.out.println("1. View all tasks");
      System.out.println("2. View tasks on a specific date");
      System.out.println("3. Quit");
   }

   public static ArrayList<Task> getTasksFromDate(String date)
   {
      //Converts the String date to a LocalDate
      LocalDate dt = LocalDate.parse(date);
      //Converts the date to the day it is in the year.
      int dayOfYear = dt.getDayOfYear();
      //returns the tasks using getTasksFromDayOfYear method.
      return getTasksFromDayOfYear(dayOfYear);
   }

   public static ArrayList<Task> getTasksFromDayOfYear(int dayOfYear)
   {
      // adding sweep the floor to every day of the year
      ArrayList<Task> tasksOnDate = new ArrayList<>();
      //sweepFloor happens everyday so always added.
      tasksOnDate.add(sweepFloor);
      // if the day of the year is even add empty the trash to the array cause it happens every second day
      if (dayOfYear % 2 == 0)
      {
         tasksOnDate.add(emptyTrash);
      }
      // if the day of the year can be divided by 28 (to include leap years) add service fire engines to the array
      if (dayOfYear % 28 == 0)
      {
         //assuming both fire engines can be serviced on the same day.
         tasksOnDate.add(serviceBothFireEngines);
         // Or else every other week each fire engine 2 gets washed
      } else if (dayOfYear % 14 == 0)
      {
         tasksOnDate.add(washFireEngine2);
         // Or else every other week each fire engine 1 gets washed
      } else if (dayOfYear % 7 == 0)
      {
         tasksOnDate.add(washFireEngine1);
      }

      // Returning the tasks depending on how the divide into the days of the year
      return tasksOnDate;
   }

}
