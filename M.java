import java.util.Scanner;

public class M {
    String y;
    Scanner sc = new Scanner(System.in);
    public int change1() {
       return sc.nextInt();
    }
    public void change2(){
         y = sc.next();

    }
    public String change3() {
        if ((y == "Х") || (y == "X")) {
            return "X";
        } else {
            return "O";
        }
    }


}

