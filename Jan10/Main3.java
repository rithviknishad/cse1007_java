package Jan10;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char str[] = in.nextLine().toCharArray();

        for (int i = 0; i < str.length - 1; i += 2) {
            char ch = str[i];
            str[i] = str[i + 1];
            str[i + 1] = ch;

        }

        System.out.println(str);

        in.close();
    }
}
