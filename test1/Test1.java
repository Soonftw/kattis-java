import java.util.*;
import java.lang.*;

public class Test1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n1 = scan.nextInt();
    int n2 = scan.nextInt();
    int n3 = scan.nextInt();

    int c = Math.max(n1, Math.max(n2, n3));
    int a = Math.min(n1, Math.min(n2, n3));
    int b = (n1+n2+n3) - (a+c);

    scan.nextLine();

    char[] order = scan.nextLine().toCharArray();

    for (int i=0;i<order.length ;i++ ) {
      switch(order[i]) {
        case 'A':
          System.out.print(a);
          break;
        case 'B':
          System.out.print(b);
          break;
        default:
          System.out.print(c);
          break;
      }
      System.out.print(" ");
    }

  }

}
