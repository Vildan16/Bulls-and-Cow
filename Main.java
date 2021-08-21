package bullscows;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int grade(char[] ans, char[] num) {
        int cow = 0;
        int bull = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (ans[i] == num[j] && i == j)
                    bull++;
                else if (ans[i] == num[j])
                    cow++;
            }
        }
        if (cow != 0 && bull != 0)
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
        else if (cow != 0)
            System.out.println("Grade: " + cow + " cow(s).");
        else if (bull != 0)
            System.out.println("Grade: " + bull + " bull(s).");
        else
            System.out.println("None.");
        return bull;
    }

    public static String getR(int len, int num) {
        StringBuilder s = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
        StringBuilder res = new StringBuilder();
        Random random = new Random();
        int rn;
        for (int i = 0; i < len; i++) {
            rn = random.nextInt(num);
            if (s.charAt(rn) != ' ') {
                res.append(s.charAt(rn));
                s.replace(rn, rn + 1, " ");
            }
            else
                i--;
        }
        return res.toString();
    }

    public static void play(String code) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = code.toCharArray();
        int bull = 0;
        int count = 1;
        char[] ans = new char[code.length()];
        String s;
        while (bull != code.length()) {
            System.out.println("Turn " + count + ":");
            s = scanner.nextLine();
            for (int i = 0; i < ans.length; i++)
                ans[i] = s.charAt(i);
            bull = grade(ans, arr);
        }
        System.out.println("Congratulations! You guessed the secret code.");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        int len = 0;
        try { len = scanner.nextInt(); }
        catch (Exception e) {
            System.out.println("Error");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        int n = scanner.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        if (n > 36 || n < len || len < 1)
            System.out.println("Error");
        else {
                System.out.print("The secret is prepared: ");
                for (int i = 0; i < n; i++)
                    System.out.print("*");
                if (n < 11)
                    System.out.println(" (0-" + (n - 1) + ").");
                else
                    System.out.println(" (0-9, a-"+ alphabet.charAt(n - 11) + ").");
            System.out.println("Okay, let's start a game!");
            play(getR(len, n));
        }
    }
}
