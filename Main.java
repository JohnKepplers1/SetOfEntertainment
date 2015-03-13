import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

class Main {
    static int c = 0;


    public static void main(final String[] args) throws InterruptedException,
            InvocationTargetException, ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {


        // setNimbusLookAndFeel();
        Scanner sc = new Scanner(System.in);
        int k = 0;
        M m = new M();
        m.change3();
        //m.change2();
        if (m.b == 2) {
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    // создание главного окна
                    Window wnd = new Window();
                    wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    wnd.setTitle("Крестики-нолики");
                    wnd.setLocation(100, 100);
                    wnd.setResizable(false);
                    wnd.setVisible(true);
                }
            });
        } else {
            Player first = new Human(Cell.Type.X);
            Player second = new RandomComputer(Cell.Type.O);
            while (k < 1) {
                System.out.println("Выберите игру (введите соответствующее число):\n   1)FreeslyleGomoku(15Х15 или 19Х19).\n   2)Tick-tack-toe(3х3).");

                try {
                    k = Integer.parseInt(sc.next());
                } catch (NumberFormatException ex) {
                    System.out.println("Введено недопустимое значение.");

                }
                if (k > 2) {
                    System.out.println("Такого числа в наборе нет.");
                    k = 0;
                }
            }
            if (k == 1) {
                m.j = 16;
                while ((m.j != 15) && (m.j != 19)) {
                    m.change1();

                }
                Game game = new FreestyleGomoku(first, second, m.j);

                c = 1;
                game.startGame();

            }
            if (k == 2) {
                while (m.j != 3) {
                    m.change1();

                }
                Game game = new TickTackToe(first, second, m.j);

                c = 2;
                game.startGame();
            }
        }

    }


}

