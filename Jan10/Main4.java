package Jan10;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        int n = input.length(), count = 0;

        for (int i = 0; i < n / 2; ++i) {
            if (input.charAt(i) != input.charAt(n - i - 1))
                count++;
        }

        if (count <= 1)
            System.out.println("Can be palindrome");
        else
            System.out.println("Not possible");

        in.close();
    }
}
