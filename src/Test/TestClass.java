package Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class TestClass {
    public static String textFinder(String text){
        String innerString= Arrays.stream(text.split("\n"))
                .map(s->s.split(" "))
                .flatMap(Arrays::stream)
                .filter(s-> !s.isEmpty())
                .map(s->{
                    StringJoiner joiner= new StringJoiner("");
                    for (char c : s.toCharArray()) {
                        if (Character.isLetter(c)) {
                            joiner.add(Character.toString(c));
                        }
                    }
                    return joiner.toString().trim().toLowerCase();
                }).map(TestClass::getfirstUniqueLetter)
                .reduce((first,second)->first+second)
                .get();
        return getfirstUniqueLetter(innerString);
    }
    public static String getfirstUniqueLetter(String letters){
        String resultString="";
        Map<String,Integer> lettersCounter =new LinkedHashMap<>();
        for (String s : letters.split("")) {
            if (lettersCounter.containsKey(s))
                lettersCounter.put(s, lettersCounter.get(s) + 1);
            else {
                lettersCounter.put(s, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : lettersCounter.entrySet()) {
            if (entry.getValue()==1) {
                resultString=entry.getKey();
                break;
            }
        }
        return resultString;
    }
}
