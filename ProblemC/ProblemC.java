import java.util.*;
import java.lang.*;

//Författare: Johannes Thessén 2020-07-02

class ProblemC {

  public static int kruskalMacaulay(int n) {
      // return (int) Math.floor((Math.sqrt(8*n)+1)/2);
      return (int) Math.ceil((Math.sqrt(8*n+1)-1)/2);
    }

  public static void main(String[] args) {

    //-------------------------------- Numerisk lösning ------------------------------------
    Scanner scan = new Scanner(System.in);
    int n;
    int bestSolution;

    //Två fall:
    //1. Ett batteri sprängs på första testet och vi måste vandra upp nerifrån, 1 mA i taget. Antalet test blir då i värsta fall n/potentialSolution
    //2. Batteriet sprängs på sista innan n och vi måste vandra upp från näst sista säkra.

    int solutionCaseOne; //Fall 1
    int solutionCaseTwo; //Fall 2
    int potentialSolution; //Vi tar det sämsta alternativet av de två.

    int interval; //Används för att beräkna solutionCaseTwo
    int sum;

    while (scan.hasNextInt()) { //Gå igenom alla batterier
      bestSolution = 4711;
      n = scan.nextInt();

      if (n == 0) {
        break;
      }
      else if (n == 1) {
        System.out.println(0);
      }
      else {
        //Använd den beskrivna ansatsen för att testa varje batteri
        //Algoritmen går från 1 mA till (n/2)+1 mA.

        for (int i=1; i<=n/2; i++) {
          //1. testa värsta fall om det första batteriet sprängs
          solutionCaseOne = i;

          //2. Testa värsta fall om det sista batteriet innan n sprängs
          sum = 1;
          solutionCaseTwo = 0;
          interval = i;

          while (sum < n) {
            sum = sum + interval; //Ta ett steg

            if (interval != 1) { //Eftersom vi har förbrukat ett test måste vi minska antalet möjliga test
              interval -= 1;
            }

            solutionCaseTwo += 1;
          }

          solutionCaseTwo = solutionCaseTwo += interval - 1;
          potentialSolution = Math.max(solutionCaseOne, solutionCaseTwo); //Ta det värsta fallet av de två
          bestSolution = Math.min(potentialSolution, bestSolution); //Den bästa lösningen är därmed det minsta antalet test.

        }
        System.out.println(bestSolution);
      }
    }

    //-------------------------------- Lösning med formel från talserien ------------------------------------
    // Scanner scan = new Scanner(System.in);
    // int max = 4711;
    // int n;
    // int x;
    //
    // while (scan.hasNextInt()) {
    //   n = scan.nextInt(); //n är det värde då batteriet är uppmätt att explodera
    //
    //   if (n == 0) {
    //     break;
    //   }
    //   else if (n == 1) {
    //     System.out.println(0);
    //   }
    //   else {
    //     System.out.println(kruskalMacaulay(n-1)); //Eftersom formeln baseras på den andra serien behöver parametern vara n-1
    //   }
    //
    // }
  }
}
