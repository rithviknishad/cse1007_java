package Jan10;

import java.util.Scanner;

/*
    2. Accept N numbers from the user, Iterate from start number to the end number and print
    the sum of the current number and previous number (don’t use arrays).Print which pair of
    values is having the greater sum and print their sum.
*/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = 0, b = 0, lA = 0, lB = 0;

        for (int i = 0; i < n; ++i) {
            a = b;
            b = in.nextInt();

            int sum = a + b;
            System.out.println("Sum: " + sum);

            if (sum > (lA + lB)) {
                lA = a;
                lB = b;
            }
        }

        System.out.printf("Largest sum: %d (formed by pair: %d, %d)", lA + lB, lA, lB);
        in.close();
    }
}
