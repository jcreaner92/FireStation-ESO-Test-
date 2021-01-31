package firestation;

/**
 * Created by John Creaner on 27/01/2021
 * COMMENTS ABOUT PROGRAM HERE
 */

//Abstract class to act as a blue print for all task type classes
public abstract class Task
{
   //counts the amount of tasks
   static int taskCount = 1;

   public abstract String getDescription();

   public abstract void setDescription(String description);

   public abstract int getAssignedTo();

   public abstract String getStartDate();

   public abstract void setAssignedTo(String assignedTo);

   public abstract void setStartDate(String startDate);

   public abstract int getTaskId();

}//class
