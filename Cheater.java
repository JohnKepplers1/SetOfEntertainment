import java.util.Random;


public class Cheater implements Player {
    M ghg1 = new M();
    // public String playerName = "Cheater";
    Cell.Type playerType;

    Cheater(Cell.Type type) {
        if (ghg1.y.equals("X")) {
            playerType = Cell.Type.O;
        } else {

            playerType = Cell.Type.X;
        }
    }

    public Cell.Type getType() {
        return playerType;
    }

    public String getPlayerName() {
        return "Cheater";
    }

    public Cell getTurn(Field field) {
        int size = field.size();

        Random random = new Random();


        int j = random.nextInt(size);
        int i = random.nextInt(size);

        System.out.println("Игрок Cheater(" + playerType + ") сделал ход на клетку (" + j + "," + i + ")");
        return new Cell(i, j, playerType);


    }
}
