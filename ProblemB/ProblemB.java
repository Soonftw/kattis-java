import java.util.*;
import java.lang.*;

//Författare: Johannes Thessén 2020-07-01

class ProblemB {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Hashtable<Character, String> coolerAlphabet = new Hashtable<Character, String>(); //Varje ny bokstav sparas i en hashtable
                                                                                      //Viktigt att escapea karaktärer som '' eller \

    coolerAlphabet.put('a', "@");
    coolerAlphabet.put('b', "8");
    coolerAlphabet.put('c', "(");
    coolerAlphabet.put('d', "|)");
    coolerAlphabet.put('e', "3");
    coolerAlphabet.put('f', "#");
    coolerAlphabet.put('g', "6");
    coolerAlphabet.put('h', "[-]");
    coolerAlphabet.put('i', "|");
    coolerAlphabet.put('j', "_|");
    coolerAlphabet.put('k', "|<");
    coolerAlphabet.put('l', "1");
    coolerAlphabet.put('m', "[]\\/[]");
    coolerAlphabet.put('n', "[]\\[]");
    coolerAlphabet.put('o', "0");
    coolerAlphabet.put('p', "|D");
    coolerAlphabet.put('q', "(,)");
    coolerAlphabet.put('r', "|Z");
    coolerAlphabet.put('s', "$");
    coolerAlphabet.put('t', "\'][\'");
    coolerAlphabet.put('u', "|_|");
    coolerAlphabet.put('v', "\\/");
    coolerAlphabet.put('w', "\\/\\/");
    coolerAlphabet.put('x', "}{");
    coolerAlphabet.put('y', "`/");
    coolerAlphabet.put('z', "2");

    String boringText = scan.nextLine(); //Strängen som ska översättas
    char boringLetter;

    String coolText = ""; //Resultatet
    String coolLetter;

    //Iterera över antalet bokstäver i strängen. Om bokstaven finns som nyckel i det nya alfabetet
    //byts den ut innan den konkateneras till resultatet. Om bokstaven inte finns med
    //konkateneras den till resultatet som den är.

    for (int i = 0; i < boringText.length(); i++){
      boringLetter = Character.toLowerCase(boringText.charAt(i));

      if (coolerAlphabet.containsKey(boringLetter)) {
        coolLetter = coolerAlphabet.get(boringLetter);
      }
      else {
        coolLetter = Character.toString(boringLetter);
      }
      coolText = coolText + coolLetter;
    }

    System.out.print(coolText);
  }
}
