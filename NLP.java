import java.util.ArrayList;

public class NLP {

private ArrayList<String> headlines; //the arraylist of headlines given by the user

  public NLP(ArrayList<String> headlines) {
    this.headlines = headlines;
  }

  /*
   * will return arraylist headlines
   */
  public ArrayList<String> getHeadlines(){
    return headlines;
  }

  /*
   * adds a headline
   */
public void addHeadline(String input){
  headlines.add(input);
}


  /*
  * will analyze every word in headline, if one matches, boom it gives stats (as of march 3 2025 but nobodys perfect). i THINK its student developed because i didn't copy paste it from anything but. it might be like a really close knockoff of something else accidentally!!
  */
 public String analyzeHeadlines() {
    ArrayList<String> goalies = new ArrayList<String>(FileReader.toStringList("tenders.txt"));
    ArrayList<Double> gaa = new ArrayList<Double>(FileReader.toDoubleList("gaa.txt"));
    ArrayList<Double> sv = new ArrayList<Double>(FileReader.toDoubleList("sv.txt"));
    
 /*
   * loop through each goaliue
   */
    for (int i = 0; i < goalies.size(); i++) {
      String current = goalies.get(i); // CURRENT FUll name of the goalie
      double curGaa = gaa.get(i); // current gaa of goalie
      double curSv = sv.get(i); //Curent save rate of goalie
      int space = current.indexOf(" "); // find space between first and last name

       /*
   * make sure goalie name has space in it
   */
      if (space != -1) {
        String lastName = current.substring(space + 1); // get  last name

    /*
   * loop through every headline
   */
        for (int j = 0; j < headlines.size(); j++) {
          String hl = headlines.get(j); // Full headline
          boolean printed = false; // makes printed so the same thing doesn't print twice
          
   /*
   * find and extract words from the headline using indexOf and substring
   */
     int start = 0;
  while (start < hl.length()) {
     int end = hl.indexOf(" ", start); // find space
  if (end == -1) {
     end = hl.length(); // if no space, end at the last character
  }
     String word = hl.substring(start, end); // Extract the word

     /*
     * Check to see if the word matches the last name, then print if it does
     */
   if (word.equalsIgnoreCase(lastName) && !printed) {
      System.out.println("\n\n\n" + current + " has a GAA of " + curGaa + " and a save rate of " + curSv + " as of March 3, 2025.");
      printed = true; // ensure that the word is only printed once
   }

      start = end + 1; // move start to the next word (after the space)
   }
        }
      }
    }
   return ""; 
  }

}
