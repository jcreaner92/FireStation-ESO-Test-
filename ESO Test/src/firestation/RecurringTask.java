package firestation;

/**
 * Created by John Creaner on 28/01/2021
 * COMMENTS ABOUT PROGRAM HERE
 */
//Extends task, other task types like OneOfTask may be added to the system in the future.
public class RecurringTask extends Task
{
   //Class variables
   int taskId;
   String description;
   String assignTo;
   String startDate;
   // frequency recorded in every X days
   int frequency;

   //Constructor
   public RecurringTask(String description, String startDate, int frequency)
   {
      super();
      this.taskId = taskCount;
      this.description = description;
      this.frequency = frequency;
      taskCount++;
   }

   @Override
   public String getDescription()
   {
      return description;
   }

   @Override
   public void setDescription(String description)
   {
      this.description = description;
   }

   //Never got to this part of the program to assign crews to each task.
   //I would of done this based on which week in the year is was as crews work one week on and one week off.
   @Override
   public int getAssignedTo()
   {

      return 0;
   }

   @Override
   public String getStartDate()
   {
      return startDate;
   }

   @Override
   public void setAssignedTo(String assignedTo)
   {
      this.assignTo = assignedTo;
   }

   @Override
   public void setStartDate(String startDate)
   {
      this.startDate = startDate;
   }

   @Override
   public int getTaskId()
   {
      return taskId;
   }

   @Override
   public String toString()
   {
      return "RecurringTask [taskId=" + taskId + ", description=" + description + ", assignTo=" + assignTo
            + ", startDate=" + startDate + ", frequency=" + frequency + "]";
   }
}// class
