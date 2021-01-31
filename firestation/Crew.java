package firestation;

/**
 * Created by John Creaner on 28/01/2021
 * COMMENTS ABOUT PROGRAM HERE
 */


public class Crew
{
   //Crew properties
   //Crew is made up of an array of individuals
   private Individual crewMembers[];
   //Static int to record the number of instances of Crew
   private static int crewCount = 1;
   //Crew id to identity each crew
   private int crewId;

   //Constructor takes in an array of Individuals
   public Crew(Individual[] crewMembers)
   {
      this.crewId = crewCount;
      this.crewMembers = crewMembers;
      crewCount++;
   }

   public int getCrewId()
   {
      return crewId;
   }

}
