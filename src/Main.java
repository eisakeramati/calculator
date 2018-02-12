import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //String a = scanner.nextLine();
        postfixHandler p = new postfixHandler();
//
//        String s = p.postFixMaker(a);
        resultHandler r = new resultHandler(p.postFixMaker("a"));

   //     System.out.println(r.resultMaker());


        p.res(true, true , true , true , false);


    }


}

