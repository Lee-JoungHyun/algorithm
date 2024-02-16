package BOJ.finish;

import java.util.Arrays;
import java.util.Comparator;

public class BOJ5052 {


    public static void main(String[] args) {
        String[] strs = new String[4];
        strs[0] = "as321";
        strs[1] = "as3";
        strs[2] = "bs31";
        strs[3] = "z31";
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;
                else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) > o2.charAt(i))
                            return 1;
                        else if (o1.charAt(i) < o2.charAt(i))
                            return -1;
                    }

                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(strs));

    }
}
