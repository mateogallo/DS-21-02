package e1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCount {

    public static int countWords ( String text ) {
        int spaces = 0;
        boolean followSpace = false;

        if (text==null){
            return 0;
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ' && !followSpace) {
                spaces++;
            }
            if (text.charAt(i) == ' ' && !followSpace){
                followSpace=true;
            }else if (text.charAt(i) != ' '){
                followSpace=false;
            }
        }
        if (text.charAt(text.length()-1) == ' ' && text.charAt(0)==' '){
            return spaces-1;
        }else if(text.charAt(0)==' ' || text.charAt(text.length()-1)==' '){
            return spaces;
        }else {
            return spaces+1;
        }
    }

    public static int countChar ( String text , char c) {
        int numberChar=0;
        if (text==null){
            return 0;
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==c){
                numberChar++;
            }
        }
        return numberChar;
    }

    public static int countCharIgnoringCase ( String text , char c ) {
        int numberChar=0;
        if (text==null){
            return 0;
        }
        char c1= Character.toUpperCase(c);
        if (c1==c){
            c1= Character.toLowerCase(c);
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==c || text.charAt(i)==c1){
                numberChar++;
            }
        }
        return numberChar;

    }

    public static boolean isPasswordSafe ( String password ){
        if (password.length() < 8) {
            return false;
        }
            Pattern lowercase = Pattern.compile("[a-z]");
            Pattern uppercase = Pattern.compile("[A-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[?@#$.,]");

            Matcher hasLowercase = lowercase.matcher(password);
            Matcher hasUppercase = uppercase.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLowercase.find() && hasUppercase.find() && hasDigit.find() && hasSpecial.find();

    }

}
