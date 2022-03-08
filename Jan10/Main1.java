package Jan10;

import java.util.Scanner;

/*
    1.	Accept  two numbers M and N .print M rows and N columns in the following format
    For eg M=4 and N=4
    # * * #
    & # # &
    * # # *
    # & & #
    a.	Odd rows  contains ‘*’ and even rows contains &
    b.	Diagonal elements contains “#”
*/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt(), n = in.nextInt();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // Odd rows contains '*' and even '&'
                char result = i % 2 == 0 ? '*' : '&';
                // Apply diagonal element logic if square matrix
                if (m == n && (i == j || i + j + 1 == m))
                    result = '#';

                System.out.print(result);
            }
            System.out.println();
        }
        in.close();
    }
}
