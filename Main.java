
 class Main {


    public static void main(String[] args) {
        M m = new M();
        System.out.print("Поставьте 'X', если хотите играть крестиками, и 'О', если хотите играть ноликами. ");
        m.change2();
        System.out.print("Введите линейную размерность поля. Либо 15, либо 19.");
        Player first = new Human(Cell.Type.X);
        Player second = new RandomComputer(Cell.Type.O);
        Game game = new Game(first, second, m.change1());
        System.out.println();

        game.startGame();


    }
}
