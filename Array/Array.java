package Array;

public class Array {
    public static void main(String[] args) {
        System.out.println("---- Monodimensional array ----");

        // arr = array(['a', 'b', 'c', 'd', 'e']) //php

        // Java array (monodimensional array)
        String[] arr = { "a", "b", "c", "d", "e" };

        // print array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("---- Bidimensional array ----");

        // Java Array (bidimensional array)
        // Curly braces instead of square brackets
        String[][] arr2 = {
                { "a", "b", "c" }, // 0
                { "1", "2", "3" } // 1
        };

        arr2[0][0] = "x"; // change 'a' to 'x'
        arr2[1][2] = "9"; // change '3' to '9'

        // print array
        // arr2.length = 2 (number of rows)
        for (int row = 0; row < arr2.length; row++) { // 2 times
            // arr2[row].length = 3 (number of columns)
            for (int col = 0; col < arr2[row].length; col++) { // 3 times
                // arr2[row][col] = 'a', 'b', 'c', '1', '2', '3'
                System.out.print(arr2[row][col]); // 6 times
            }
            System.out.println();
        }

        System.out.println("---- Tridimensional array ----");

        // Java Array (tridimensional array)
        String[][][] arr3 = {
                {
                        { "a", "b", "c" },
                        { "1", "2", "3" }
                },
                {
                        { "x", "y", "z" },
                        { "1", "2", "3" }
                }
        };

        // print array
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                for (int k = 0; k < arr3[i][j].length; k++) {
                    System.out.print(arr3[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("----------------------------------------------------");
    }
}
