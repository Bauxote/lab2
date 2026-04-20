import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        StringBuffer input = new StringBuffer(scanner.nextLine());
        scanner.close();
        StringBuffer[] words = new StringBuffer[100];
        int wordCount = 0;
        int start = 0;

        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                if (start < i) {
                    StringBuffer word = new StringBuffer();
                    for (int j = start; j < i; j++) {
                        word.append(input.charAt(j));
                    }
                    words[wordCount++] = word;
                }
                start = i + 1;
            }
        }

        for (int i = 0; i < wordCount; i++) {
            for (int j = i + 1; j < wordCount; j++) {
                if (compare(words[i], words[j]) > 0) {
                    StringBuffer temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }

        System.out.println("\n Sorted text:");
        for (int i = 0; i < wordCount; i++) {
            if (i > 0 && compare(words[i], words[i - 1]) == 0) {
                continue;
            }
            System.out.print(words[i].toString() + " ");
        }
    }

    public static int compare(StringBuffer sb1, StringBuffer sb2) {
        int len1 = sb1.length();
        int len2 = sb2.length();
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = sb1.charAt(k);
            char c2 = sb2.charAt(k);
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}
