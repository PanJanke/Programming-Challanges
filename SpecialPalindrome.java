import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialPalindrome {


    //this solution is correct but too slow
    private long substrCount(int n, String s) {
        int result = 0;
        //this pattern finds a substrings which contains only one type of character
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(s);
        List<String> substrings = new LinkedList<>();

        while (matcher.find()) {
            substrings.add(matcher.group());
            int len = matcher.group().length();
            result += (len * (len + 1)) / 2; //Triangular number formula

        }
        for (int i = 1; i < substrings.size() - 1; i++) {
            if (substrings.get(i).length() == 1 &&
                    substrings.get(i - 1).equals(substrings.get(i + 1)))
                result += substrings.get(i - 1).length();
        }

        return result;
    }
}
