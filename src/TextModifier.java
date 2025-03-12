import org.w3c.dom.css.Counter;


import java.util.Scanner;

public class TextModifier {

    public static void main(String[] args) {
        textModifier();
    }

    public static void textModifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите текст: ");
        String text = scanner.nextLine();

        StringBuilder spaceText = new StringBuilder();
        boolean spaceDel = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (!spaceDel) {
                    spaceText.append(text.charAt(i));
                }
                spaceDel = true;
            } else {
                spaceText.append(text.charAt(i));
                spaceDel = false;
            }
            
        }

        StringBuilder swappedText = new StringBuilder();
        for (int i = 0; i < spaceText.length(); i++) {

            if (spaceText.charAt(i) == '-') {
                if (i == 0 || i == spaceText.length() - 1) {
                    continue;
                }
                if (i > 0 && i < spaceText.length() - 1) {
                    char a = spaceText.charAt(i + 1);
                    char b = spaceText.charAt(i - 1);
                    swappedText.setCharAt(swappedText.length() - 1, a);
                    swappedText.append(b);
                    i++;


                }
            } else {
                swappedText.append(spaceText.charAt(i));
            }
        }

        String replacedText = swappedText.toString().replace('+', '!');

        int sum = 0;
        String summText = "";
        for (int i = 0; i < replacedText.length(); i++) {
            char c = replacedText.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            } else {
                summText += c;
            }
        }


        System.out.println(" Измененный текст: " + summText + " " + sum);

        scanner.close();

    }
}