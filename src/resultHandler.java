/**
 * Created by eisak on 2017-10-19.
 */
public class resultHandler {

    stack s;
    String postfix;

    public resultHandler(String g) {
        s = new stack(g.length());
        postfix = g;
    }

    public String resultMaker() {
        String res = "";
        String temp = "";
        for (int i = 0; i < postfix.length() - 1; i++) {
            if (!Character.toString(postfix.charAt(i)).equals("."))
                temp = Character.toString(postfix.charAt(i));
            if (!Character.toString(postfix.charAt(i + 1)).equals(".")) {

                while (!Character.toString(postfix.charAt(i + 1)).equals(".")) {
                    temp += Character.toString(postfix.charAt(i + 1));
                    i++;
                }
            } else
                i++;

            if (isOperand(temp) != 0) {
                s.add(temp);
            } else {
                String s2 = s.delete();
                String s1 = s.delete();

                s.add(whatOperator(temp, s1, s2));
            }
            temp = "";
        }
        res = s.delete();
        return res;
    }

    public int isOperand(String given) {
        if (given.equals("+"))
            return 0;
        else if (given.equals("*"))
            return 0;
        else if (given.equals("-"))
            return 0;
        else if (given.equals("/"))
            return 0;
        else if (given.equals("^"))
            return 0;
        else if (given.equals(")"))
            return 0;
        else if (given.equals("("))
            return 0;
        else return 1;
    }

    public String whatOperator(String given, String s1, String s2) {
        if (given.equals("+"))
            return Integer.toString(Integer.parseInt(s1) + Integer.parseInt(s2));
        else if (given.equals("*"))
            return Integer.toString(Integer.parseInt(s1) * Integer.parseInt(s2));
        else if (given.equals("-"))
            return Integer.toString(Integer.parseInt(s1) - Integer.parseInt(s2));
        else if (given.equals("/"))
            return Integer.toString(Integer.parseInt(s1) / Integer.parseInt(s2));
        else if (given.equals("^"))
            return Integer.toString(Integer.parseInt(s1) ^ Integer.parseInt(s2));
        else return null;
    }

}
