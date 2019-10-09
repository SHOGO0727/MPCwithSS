import java.util.*;

public class Shamir{
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Pcalculator pc = new Pcalculator();
      DistRecon   dr = new DistRecon();
      BetterScan  bs = new BetterScan();

      long p = 1000000000 + 7;
      System.out.println("p=" + p);

      int n = bs.intScan("n"); // n<p
      int k = bs.intScan("k"); // n<p
      long s = (long)bs.intScan("secret"); // s<p
      //System.out.print("n="); //long n = sc.nextLong();
      //System.out.print("k="); //long k = sc.nextLong();
      //System.out.print("s="); //long s = sc.nextLong();

      long[] id = new long[n];
      for(int i=0;i<n;i++){
        id[i] = i+1;;
      }

      //long startD = System.currentTimeMillis();
      //long startD = System.nanoTime();
      long[] share = dr.shamirD(s,id,p,n,k);
      //long endD = System.currentTimeMillis();
      //long endD = System.nanoTime();

      //long startR = System.currentTimeMillis();
      long ans = dr.shamirR(share,id,p,n,k);
      //long endR = System.currentTimeMillis();
      System.out.println("");
      System.out.println("reconstructed value = " + ans);

    }
}
