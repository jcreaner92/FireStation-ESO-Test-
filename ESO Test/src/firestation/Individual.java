package firestation;

/**
 * Created by John Creaner on 27/01/2021
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Individual
{
   //Individual properties
   //Static int to count number of individual instances
   private static int individualCount = 1;
   //id to uniquely identify each individual
   private int id;

   //Constructor that takes no arguments
   public Individual()
   {
      this.id = individualCount;
      //increment by 1 each time.
      individualCount++;
   }
}
