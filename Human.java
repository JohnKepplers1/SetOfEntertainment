import java.util.Scanner;

public class Human implements Player {
    M ghg = new M();
    //public String playerName = "Human";
    Cell.Type playerType;

    Human(Cell.Type type) {
        if (ghg.change3() == "X"){
        playerType = Cell.Type.X;} else {
            playerType = Cell.Type.O;
        }
    }

    public Cell.Type getType() {
        return playerType;
    }

    public String getPlayerName() {
        return "Human";
    }

    // считываем координаты
    public Cell getTurn(Field field)
    {
        Scanner sc = new Scanner(System.in);
        int size = field.size();

        while(true)
        {
            System.out.println("Введите координату X: ");
            int j = sc.nextInt();
            System.out.println("Введите координату Y: ");
            int i = sc.nextInt();
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
