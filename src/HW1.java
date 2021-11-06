import java.util.*;

public class HW1 {

    //Task1
    public static ArrayList getListWithIntegers(ArrayList ls) {
        ArrayList intList = new ArrayList();
        for (Object item : ls) {
            if (item instanceof Integer) {
                intList.add(item);
            }
        }

        return intList;
    }

    //Task2
    public static char firstNonRepeatingLetter(String str) {
        int [] amountOfChars = new int[26];
        Arrays.fill(amountOfChars,0);

        for (int i = 0; i < str.length(); i++) {
            char j = Character.toUpperCase(str.charAt(i));
            amountOfChars[j-65]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char j = Character.toUpperCase(str.charAt(i));
            if (amountOfChars[j - 65] == 1) {
                return str.charAt(i);
            }
        }

        return ' ';
    }

    //Task3
    public static int getDigitalRoot(int n) {
        if (n < 10) {
            return n;
        }

        int digitRoot = 0;
        do {
            digitRoot += (n % 10);
            n /= 10;
        } while (n > 0);

        return getDigitalRoot(digitRoot);
    }

    //Task4 (first way)
    public static int countPairs(int[] ls, int target) {
        int totalCount = 0;
        for (int i = 0; i < ls.length -1; i++) {
            for (int j = i+1; j < ls.length; j++) {
                if (ls[i] + ls[j] == target) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

    //Task4 (second way)
    public static int countPairs2(ArrayList<Integer> ls, int target) {
        long totalCount = 0;
        for (int j : ls) {
            totalCount += ls.subList(ls.indexOf(j)+1,ls.size()).stream().filter(i -> i + j == target).count();
        }
        System.out.println(totalCount);
        return 0;
    }

    //Task5
    public static String sortByFullName(String guestList) {
        guestList += ';';
        guestList = guestList.toUpperCase();
        List<String> pair;

        String[] surnameName = guestList.split(";|\\:");
       // System.out.println(Arrays.toString(surnameName));
        List<List<String>> fullName = new ArrayList<List<String>>();

        for (int i = 0; i < surnameName.length; i = i+2) {
            fullName.add(Arrays.asList(surnameName[i], surnameName[i+1]));
        }

        Collections.sort(fullName, new Comparator<List<String>>() {
            public int compare(List<String> ls1, List<String> ls2) {
                int res = ls1.get(0).compareToIgnoreCase(ls2.get(0));
                if (res != 0) {
                    return res;
                }
                return ls1.get(1).compareToIgnoreCase(ls2.get(1));
            }
        });

        String formatGuestList = "";
        for (List<String> i : fullName) {
            formatGuestList += ("(" + i.get(0) + "," + i.get(1) + ")");
        }

        return formatGuestList;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Task 1");
        ArrayList ls = new ArrayList(Arrays.asList(1,2,"a","b","aasf","1","123",231));
        System.out.print("Initial array list: ");
        System.out.println(ls);

        System.out.print("Updated array list: ");
        System.out.println(getListWithIntegers(ls));


        System.out.println("\nTask 2");
        System.out.println("A first non-repeated char in \"stress\": " + firstNonRepeatingLetter("stress"));
        System.out.println("A first non-repeated char \"sTreSS\": " + firstNonRepeatingLetter("sTreSS"));


        System.out.println("\nTask 3");
        System.out.println("Digital root for 16: "+getDigitalRoot(16));
        System.out.println("Digital root for 942: "+getDigitalRoot(942));
        System.out.println("Digital root for 132189: "+getDigitalRoot(132189));
        System.out.println("Digital root for 493193: "+getDigitalRoot(493193));


        System.out.println("\nTask 4");
        int[] arr = {1,3,6,2,2,0,4,5};
        int target = 5;
        System.out.println("Initial array: " + Arrays.toString(arr));
        System.out.println("The amount of pairs: "+countPairs(arr, target));


        System.out.println("\nTask 5");
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println("Initial string: " + s);
        String newS = sortByFullName(s);
        System.out.println(newS);
    }
}
