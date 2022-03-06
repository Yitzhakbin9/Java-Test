package TEST;

import javax.swing.text.ElementIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

////***************     q1     *******************

        q1();

////***************     q2     *******************


        List<List<Integer>> bigMatrix = createMatrix(40);
        System.out.println(bigMatrix);
        List<List<Integer>> smallMatrix = createMatrix(10);
        System.out.println(smallMatrix);


        System.out.println(isContains(smallMatrix, bigMatrix));

//
////***************     q3     *******************

//        In the files "question3", "MyThread", "Operation"

////***************     q4     *******************

        q4(4, 3);

//***************     q5 , q6 , q7     *******************

        List<String> myList = new ArrayList<>();
        myList.add("Yitzhak");
        myList.add("Noam");
        myList.add("Reut");
        myList.add("Haim");
        myList.add("Eden");

        // Test to functions:
        MyProtectedUniqueList protectedList = new MyProtectedUniqueList("code", myList);
        System.out.println(protectedList + "\n");
        protectedList.Add("Amitai", "code");
        System.out.println("AFTER ADD: " + protectedList + "\n");

        protectedList.Remove(null, "code");
        System.out.println("AFTER REMOVE: " + protectedList + "\n");

        protectedList.RemoveAt(4, "***");
        System.out.println("AFTER REMOVE AT: " + protectedList + "\n");


        protectedList.Sort("code");
        System.out.println("AFTER SORT: " + protectedList + "\n");

        protectedList.Clear("codye");
        System.out.println("AFTER CLEAR: " + protectedList + "\n");


//***************     q7     *******************

        for (var word : protectedList) {
            System.out.println(word);
        }
    }


    public static void q1() {

        Scanner scr = new Scanner(System.in);
        System.out.println("Please enter your name and ID:");
        String name = scr.next();
        String id = scr.next();

        int number = Integer.parseInt(id);
        int lastDigit = number % 10;
        number = number / 10; // tenth digit
        int tenth = number % 10;

        int f = id.length();
        int len = id.length() - tenth;
        String part1 = id.substring(0, len);
        String part2 = id.substring(len, f);
        String dig = String.valueOf(lastDigit);
        String result = part1 + dig + part2;

        System.out.println(name + " , " + result);
    }

    public static double q4(int x, int n) {

        int minus = -1;
        double finalResult = 0;
        for (int i = 1; i <= n; i++) {

            finalResult += minus * (Math.pow(x, 2 * i) / factorial(i));
            minus *= -1;
        }

        return finalResult;
    }

    public static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static List<List<Integer>> createMatrix(int x) {

        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int random;

        for (int i = 1; i <= x; i++) {
            row.clear();
            for (int j = 1; j <= x; j++) {
                random = j * 2;
                row.add(random);
            }
            matrix.add(row);
        }
        return matrix;
    }

    public static boolean isContains(List<List<Integer>> smallMatrix, List<List<Integer>> bigMatrix) {

        int i = 0, j = 0;  // i point on the rows of the big matrix and j points on the rows of the small matrix
        int equalRows = 0;
        while (i < bigMatrix.size() || j < smallMatrix.size() || equalRows < smallMatrix.size()) {
            if (bigMatrix.get(i).containsAll(smallMatrix.get(j))) {
                i++;
                j++;
                equalRows++;
                if (equalRows == smallMatrix.size() - 1) return true;
                else continue;
            } else i++;
        }
        return false;
    }
}
