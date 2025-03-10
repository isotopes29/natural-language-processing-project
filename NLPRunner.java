import java.util.Scanner;
import java.util.ArrayList;

public class NLPRunner {
  public static void main(String[] args) {

ArrayList<String> fish = new ArrayList<String>();
NLP headlines = new NLP(fish);

    
  /*
   * gets the actual code started and this probably could have been done more efficiently but oh well
   */
        Scanner input = new Scanner(System.in);
    System.out.println("What would you like to do?\nAdd\nExit\n");
    String userInput = input.nextLine();
    boolean j = false;
    if (userInput.equalsIgnoreCase("add")){
      String userHeadline = input.nextLine();
      headlines.addHeadline(userHeadline);
      System.out.println("\nWould you like to add another headline?\nYes\nNo\n");
      String userYesNo = input.nextLine();
      for (int i = 0; i < 5; i++){
        if (userYesNo.equalsIgnoreCase("yes")){
            userHeadline = input.nextLine();
            headlines.addHeadline(userHeadline);
            System.out.println("\nWould you like to add another headline?\nYes\nNo\n");
            userYesNo = input.nextLine();
      } else if (userYesNo.equalsIgnoreCase("no")){
          j = true;
      }
      }
      if (j == true){
        System.out.println("\nWould you like to analyze your headlines?");
        userYesNo = input.nextLine();
        if (userYesNo.equalsIgnoreCase("yes")){
          headlines.analyzeHeadlines();
        } else{
          System.out.println("Exiting.");
        }
      }
    } else{
      System.out.println("Exiting.");
    }
    
    
  }
}
