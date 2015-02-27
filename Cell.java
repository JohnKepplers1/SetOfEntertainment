// тип для ячейки
public class Cell {

    // тип для значения ячейки
    public enum Type {Null, X, O}

    Cell(int i, int j, Type type) {
        this.i  = i;
        this.j = j;
        this.type = type;
    }

    public int i;
    public int j;
    public Type type;
}
