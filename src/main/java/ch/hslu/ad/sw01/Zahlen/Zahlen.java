package ch.hslu.ad.sw01.Zahlen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zahlen {

    private static final Logger Log = LogManager.getLogger();
    public static void main(String[] args) {
        //System.out.println(checkSymmetric(701));
        System.out.println(findSymmetric(501));
    }

    public static boolean checkSymmetric(final int n){
        String temp = Integer.toString(n);
        // String Builder hinzufügen
        StringBuilder input1 = new StringBuilder();

        // String-Input hinzufügen
        input1.append(temp);

        // String-Input umkehren
        input1.reverse();

        StringBuilder input2 = new StringBuilder();
        input2.append(n);

        // String temp und input1 vergleichen
        if(input1.toString().equals(input2.toString())){
            return true;
        } else {
            return false;
        }
    }

    public static int findSymmetric(int n){
        if(checkSymmetric(n)){
            return n;
        }
        while(checkSymmetric(n ) != true){
            n++;
            checkSymmetric(n);
        }
        return n;
    }
}
