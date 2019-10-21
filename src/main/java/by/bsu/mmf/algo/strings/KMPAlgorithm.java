package by.bsu.mmf.algo.strings;

public class KMPAlgorithm {

    public int[] calculatePrefixFunction(String s) {
        int[] p = new int[s.length()];
        p[0] = 0;
        int j = 0;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(j) == s.charAt(i)) {
                p[i] = p[i - 1] + 1;
                j++;
            } else {
                 while (j > 0) {
                     int previousPrefixFuncValue = p[j - 1];
                     j = p[j - 1];
                     if(s.charAt(j) == s.charAt(i)) {
                         p[i] = previousPrefixFuncValue + 1;
                         j++;
                         break;
                     }
                 }
            }
        }

        return p;
    }



}
