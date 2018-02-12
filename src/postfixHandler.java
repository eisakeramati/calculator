import java.util.StringTokenizer;

/**
 * Created by eisak on 2017-10-09.
 */
public class postfixHandler {


    public postfixHandler() {

    }


    public void res(boolean a, boolean b , boolean c ,  boolean d , boolean e)
    {
        System.out.println((!a)&(!b)&(c)&(!e) | (!b)&(!c)&(!d)&(!e) | (!a)&(!b)&(!d) | (!b)&(c)&(!d) | (!a)&(c)&(d)| (!a)&(b)&(d) | (a)&(!b)&(!c)&(d));
    }

    public int isp(String in) {
        if (in.equals("("))
            return 5;
        else if (in.equals("+"))
            return 4;
        else if (in.equals("-"))
            return 4;
        else if (in.equals("*"))
            return 3;
        else if (in.equals("/"))
            return 3;
        else if (in.equals("^"))
            return 2;
        else if (in.equals("#"))
            return 6;
        else return 7;
    }

    public int icp(String in) {
        if (in.equals("("))
            return 0;
        else if (in.equals("+"))
            return 3;
        else if (in.equals("-"))
            return 3;
        else if (in.equals("*"))
            return 2;
        else if (in.equals("/"))
            return 2;
        else if (in.equals("^"))
            return 1;
        else if (in.equals("#"))
            return 4;
        else return 7;
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

    public String postFixMaker(String infix) {
        String sArray[] = new String[infix.length()];
        for (int i = 0; i < infix.length(); i++) {
            sArray[i] = Character.toString(infix.charAt(i));
        }
        String result = "";
        stack s1 = new stack(infix.length());
        infix = infix + " #";
        String y;
        s1.add("#");
        StringTokenizer st = new StringTokenizer(infix, " ");
        for (String x = st.nextToken(); !x.equals("#"); x = st.nextToken()) {
            if (isOperand(x) != 0) {
                System.out.print(x);
                result = result + x + ".";
            } else if (x.equals(")")) {
                for (y = s1.delete(); !y.equals("("); y = s1.delete()) {
                    System.out.print(y);
                    result = result + y + ".";
                }
            } else {
                for (y = s1.delete(); isp(y) <= icp(x); y = s1.delete()) {
                    System.out.print(y);
                    result = result + y + ".";
                }
                s1.add(y);
                s1.add(x);
            }

        }
        String s = "";
        while (!s.equals("#")) {
            s = s1.delete();
            if (s.equals("#"))
                break;
            System.out.print(s);
            result = result + s + ".";
        }

        return result;

    }


}
