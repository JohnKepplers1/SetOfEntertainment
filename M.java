import java.util.Scanner;

public class M {
    int j = 15;
    int i = 0;
    byte b;
    String y = "♥";
    Scanner sc = new Scanner(System.in);

    public void change1() {
        if (i > 0) {
            System.out.println("Выбран недопустимый размер игрового поля.");
        }
        System.out.println("Введите линейную характеристику квадратного игрового поля ");
        while (1 < 2) {
            try {
                j = Integer.parseInt(sc.next());
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка!");
                break;
            }

            i++;
            break;


        }
    }

    public String change2() {
        System.out.println("Поставьте 'X', если хотите играть крестиками, и 'О', если хотите играть ноликами.(английская раскладка на клавиатуре) ");

        while (1 < 2) {

            y = sc.next();
            if ((y.equals("X")) || (y.equals("O"))) {
                break;

            } else {
                System.out.println("Вы ввели недопустимое значение. Попробуйте ещё раз.");
            }

        }
        return y;
    }

    public void change3() {
        System.out.println("Введите '1', если хотите играть  с консоли, и '2', если хотите играть в отдельном окошке. ");
        while (1 < 2) {
            b = sc.nextByte();
            if ((b == 1) || (b == 2)) {
                break;
            } else {
                System.out.println("Вы ввели недопустимое значение. Попробуйте ещё раз.");
            }
        }
    }

}


