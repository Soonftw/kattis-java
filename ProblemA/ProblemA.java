import java.util.*;
import java.lang.*;

//Författare: Johannes Thessén 2020-07-01

class ProblemA {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numberOfTemperatures = scan.nextInt(); //läs in antal dagar
    int daysBelowZero = 0; //Initiera resultatet

    for (int i=0; i<numberOfTemperatures ; i++ ) { //För varje heltal som är mindre än 0, addera 1 till resultatet
      int temp = scan.nextInt();
      if (temp < 0) {
        daysBelowZero += 1;
      }
    }
    System.out.print(daysBelowZero);

  }
}
