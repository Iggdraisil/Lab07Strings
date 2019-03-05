import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    public static String readInputText() {
        System.out.print("Enter String\n");
        Scanner sc = new Scanner(System.in);
        String output = sc.nextLine();
        return output;

    }


    public String processTextFromConsole() {
        Pattern pattern = Pattern.compile("\\b[AaEeIiYuUuOo]\\w*");
        List<String> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(StringProcessor.readInputText());
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return  sortWordsAlphabetOrder(result).toString();

    }

    public String processText(String text) {
        Pattern pattern = Pattern.compile("\\b[AaEeYuUuOo]\\w*");
        List<String> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return  sortWordsAlphabetOrder(result).toString();
    }



    public List<String> sortWordsAlphabetOrder(List<String> input) {
        for (int j=0; j<input.size(); j++) {
            for (int i = 0; i < input.size()-1; i++) {
                if (shouldBeSwapped(input.get(i),input.get(i +1))) {
                    Collections.swap(input, i, i + 1);
                }
            }
        }
        return input;
    }

    public boolean shouldBeSwapped(String word1, String word2) {
        Pattern firstPattern = Pattern.compile("[^aeiyuo]");
        Pattern secondPattern = Pattern.compile("[^aeiyuo]");
        for (int i = 1; i<Integer.min(word1.length(),word2.length()); i++) {
            Matcher firstMatcher = firstPattern.matcher(Character.toString(word1.charAt(i)));
            Matcher secondMatcher = secondPattern.matcher(Character.toString(word2.charAt(i)));

            if (firstMatcher.matches() && secondMatcher.matches()) {
                int result = word1.charAt(i)-word2.charAt(i);
                if (result>0) {
                    return true;
                }
                else
                    if (result<0) {
                        return false;
                    }
                continue;
            }
            if (secondMatcher.matches()) {
                return true;
            } else if (firstMatcher.matches()) {
                return false;
            }
            continue;
        }
        return false;
    }

}
