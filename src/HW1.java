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
    public static long countPairs2(List<Integer> ls, int target) {
        long totalCount = 0;
        for (int j : ls) {
            totalCount += ls.subList(ls.indexOf(j)+1,ls.size()).stream().filter(i -> i + j == target).count();
        }
        return totalCount;
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

    //Extra task1
    public static int nextBigger(int num) {
        if (num < 10) {
            return -1;
        }

        List<Integer> digits = new ArrayList<Integer>();
        do {
            digits.add(num % 10);
            num /=10;
        } while (num > 0);

        int i = 0, j = 1;
        while (digits.get(i) <= digits.get(j)) {
            i++; j++;
            if (j == digits.size()) {
                return -1;
            }
        }

        int min_pos = j-1;
        for (int k = j-1; k >= 0; k--) {
            if (digits.get(k) > digits.get(j) && digits.get(k) <= digits.get(min_pos)) {
                min_pos = k;
            }
        }
        Collections.swap(digits, j, min_pos);

        int newNumber = 0;
        for (int k = digits.size()-1; k >= j; k--) {
            newNumber*=10;
            newNumber+=digits.get(k);
        }
        for (int k = 0; k < j; k++) {
            newNumber*=10;
            newNumber+=digits.get(k);
        }

        return newNumber;
    }

    //Extra task2
    public static String toIPv4 (long num) {
        int[] binaries = new int[32];
        Arrays.fill(binaries, 0);

        int index = 0;
        while (num > 0) {
            binaries[31-index++] = (int)(num %2);
            num/=2;
        }

        String IPv4 = "";
        int octet, order;
        for (int i = 3; i >= 0; i--) {
            octet = 0;
            order = 1;
            for (int j = 0; j < 8; j++) {
                octet += (order*binaries[(31-8*i) - j]);
                order *= 2;
            }
            IPv4 += (octet+".");
        }
        return IPv4.substring(0, IPv4.length()-1);
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
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,3,6,2,2,0,4,5));
        System.out.println("The amount of pairs 2: "+countPairs2(arr2, target));


        System.out.println("\nTask 5");
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println("Initial string: " + s);
        String newS = sortByFullName(s);
        System.out.println(newS);


        System.out.println("\nExtra Task 1");
        System.out.println("Next bigger number for 12: " + nextBigger(12));
        System.out.println("Next bigger number for 513: " + nextBigger(513));
        System.out.println("Next bigger number for 2017: " + nextBigger(2017));
        System.out.println("Next bigger number for 9: " + nextBigger(-1));
        System.out.println("Next bigger number for 111: " + nextBigger(-1));
        System.out.println("Next bigger number for 531: " + nextBigger(-1));


        System.out.println("\nExtra Task 2");
        System.out.println("IPv4 for number 2_149_583_361: "+toIPv4(2_149_583_361l));
        System.out.println("IPv4 for number 32: "+toIPv4(32));
        System.out.println("IPv4 for number 0: "+toIPv4(0));
    }
}
