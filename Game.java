

public class Game {

    public Player firstPlayer;
    public Player secondPlayer;
    public Field gameField;

    Game(Player first, Player second, int size)
    {
        if (first.getType() == second.getType())  {
            System.out.println("Игроки имеют одинаковый тип.");
            System.exit(1);
        }

        firstPlayer = first;
        secondPlayer = second;
        gameField = new Field(size);
    }

    void startGame()
    {
        Player currentPlayer = firstPlayer;
        Cell turn; // ход игрока
        while(true)
        {
            gameField.printField();

            turn = currentPlayer.getTurn(gameField);

            if (gameField.cellType(turn.i, turn.j) == Cell.Type.Null)
                gameField.setCell(turn);


            // проверка на победителя
            if (gameField.isWinner(turn))
            {
                gameField.printField();
                System.out.println("Выиграл "+ currentPlayer.getPlayerName() + "("+ currentPlayer.getType() +")!");
                return;
            }

            // проверка на ничью
            if (gameField.isFieldFilled())
            {
                gameField.printField();
                System.out.println("Ничья.");
                return;
            }

            // смена хода
            if (currentPlayer == firstPlayer)
                currentPlayer = secondPlayer;
            else
                currentPlayer = firstPlayer;

        }

    }
}
