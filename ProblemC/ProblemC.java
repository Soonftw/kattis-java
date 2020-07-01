import java.util.*;
import java.lang.*;

//Författare: Johannes Thessén 2020-07-01

class ProblemC {

  public static int kruskalMacaulay(int n) {
      // return (int) Math.floor((Math.sqrt(8*n)+1)/2);
      return (int) Math.ceil((Math.sqrt(8*n+1)-1)/2);
    }

  public static void main(String[] args) {
  //Det här programmet tar reda på antalet tester man i värsta fall måste göra för att
  //ta reda på när ett batteri exploderar.

  //En ansats är att ta "tre steg" i taget. Det vill säga att om n = 10 testar jag
  //1-4-7-9. Om det sprängs på säg 4 vet jag att batteriet dör på 2 eller 3. Då räcker det med att testa
  //ett av dem för att vara helt säker på det kritiska värdet.

  //En annan ansats är att börja lite längre in. Om startpunkten är (x//2) vid jämt x, och (x-1/2) vid udda så kan två saker hända:

  //1. batteriet sprängs och vi måste titta till vänster (med bara ett batteri kvar). Eftersom vi bara har ett batteri
  // behöver vi börja från början och ta ett steg i taget.

  //2. batteriet sprängs inte och vi kan nu titta till höger. Eftersom batteriet inte sprängts än kan vi
  //vid fall 2 ta två steg i taget. Om batteriet sprängs måste vi även titta på det till vänster.

  //Det här funkar vid små n, men uppe vid n = 23 funkar det inte alls. Om man radar upp de första 10 n med den metoden så uppstår ett mönster:
  // 0 1 2 2 3 3 3 4 4 4 4 ... Det här är en serie som kallas för The Kruskal-Macaulay function M_2(n). (A123578) https://oeis.org/A123578.
  // A(n) kan här approximeras med antingen formeln A(n) ~ round(sqrt(2*n)/2) eller A(n) ~ round((sqrt(8*n)+1)/2).

  //När man väl har A så ser det ganska självklart ut. Ta exemplet n = 23. A kommer vara 7, vilket är den ström som vi testar först.
  //Om batteriet sprängs måste vi testa med 1 mA och uppåt, ett steg i taget.

  //Om batteriet inte sprängs kan vi ta sju steg till och upprepa samma process.


  //https://mathworld.wolfram.com/Self-CountingSequence.html




//Om jag hoppar i steg första gången, så kan jag bara hoppa i-1 steg nästa gång.
    Scanner scan = new Scanner(System.in);
    int max = 4711;
    int n;
    int x;

    while (scan.hasNextInt()) {
      n = scan.nextInt(); //n är det värde då batteriet är uppmätt att explodera

      if (n == 0) {
        break;
      }
      else if (n == 1) {
        System.out.println(0);
      }
      else {
        System.out.println(kruskalMacaulay(n-1)); //Eftersom formeln baseras på den andra serien behöver parametern vara n-1
      }

    }
  }
}
