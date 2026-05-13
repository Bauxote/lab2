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
                char c1 = Character.toLowerCase(words[i].charAt(0));
                char c2 = Character.toLowerCase(words[j].charAt(0));
                if (c1 > c2) {
                    StringBuffer temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }

        System.out.println("\nSorted unique words (by first letter):");
        for (int i = 0; i < wordCount; i++) {
            if (i > 0 && Character.toLowerCase(words[i].charAt(0)) ==
                         Character.toLowerCase(words[i - 1].charAt(0))) {
                continue;
            }
            System.out.print(words[i].toString() + " ");
        }
    }
}
