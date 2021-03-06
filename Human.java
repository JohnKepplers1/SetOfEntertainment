import java.util.Scanner;

public class Human implements Player {
    // final public String playerName = "Human";
    Cell.Type playerType;
    private M mm = new M();
    private int j = 0;
    private int i = 0;

    Human(Cell.Type type) {
        if (mm.change2().equals("X")) {
            playerType = Cell.Type.X;

        } else {
            playerType = Cell.Type.O;
        }
    }

    public Cell.Type getType() {
        return playerType;
    }

    public String getPlayerName() {
        return "Human";
    }

    public Cell getTurn(Field field) {
        Scanner sc = new Scanner(System.in);
        int size = field.size();

        while (true) {
            System.out.println("Введите координату X: ");
            try {
                j = Integer.parseInt(sc.next());
            } catch (NumberFormatException ex) {
                System.out.println("Введено не число!");
                continue;
            }
            System.out.println("Введите координату Y: ");
            try {
                i = Integer.parseInt(sc.next());
            } catch (NumberFormatException ex) {
                System.out.println("Введено не число!");
                continue;
            }
            if (i < 0 || i >= size) {
                System.out.println("Координата Y вне допустимого диапазона. Введите координату заново.");
                continue; // обрывает текущую итерацию цикла и запускает следующую
            }

            if (j < 0 || j >= size) {
                System.out.println("Координата X вне допустимого диапазона. Введите координату заново.");
                continue;
            }

            if (field.cellType(i, j) != Cell.Type.Null) {
                System.out.println("Поле (" + j + ";" + i + ") уже занято. Введите координаты заново. ");
                continue;
            }

            return new Cell(i, j, playerType);
        }
    }
}

