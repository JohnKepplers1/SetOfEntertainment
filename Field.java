public class Field {

    int n;
    // массив состояния поля
    Cell.Type[][] field;



    // конструктор поля
    Field(int n) {
        if ((n != 19) && (n !=15))  {
        System.out.println("Задано поле недопустимого размера");
        System.exit(1);}
        this.n = n;
        field = new Cell.Type[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                field[i][j] = Cell.Type.Null;
            }
        }
    }

    public int size() {
        return n;
    }

//методы:
    //Получение значения ячейки
    void setCell(Cell cell) {
        field[cell.i][cell.j] = cell.type;
    }

    // возвращает значение ячейки
    Cell.Type cellType(int i, int j) {
        return field[i][j];
    }
int five1 = 0;
    int five2 = 0;
    // проверка на выигрышную комбинацию
    boolean isWinner(Cell cell) {
        for (int i = 0; i < n; i++) {
            if ((five1 == 5)|(five2 == 5)){break;}
            five1 = 0;
            five2 = 0;
            for (int j = 0; j < n; j++) {
                if (field[j][i] == cell.type) {
                    five1++;
                } else {
                    five1 = 0;
                }
                if (field[i][j] == cell.type) {
                    five2++;
                } else {
                    five2 = 0;
                }
                if ((five1 == 5)|(five2 == 5)) {
                    return true;
                }
                if ((five1 == 5)|(five2 == 5)){break;}
            }
        }
        int z = 4;
        five1 = 0;
        five2 = 0;
        int five3 = 0;
        int five4 = 0;
        int k = 4;
            for(int i = k; i < n; i++) {
                if ((five1 == 5)|(five2 == 5)|(five3 == 5)|(five4 == 5)){break;}
                five1 = 0;
                five2 = 0;
                five3 = 0;
                five4 = 0;
                z=i;
                for ( int j = 0; j < n; j++){
                    if (field[z][j] == cell.type){
                      five1++;} else {
                        five1 = 0;
                    }
                    if (field[n-1-j][n-1-z] == cell.type){
                        five2++;} else {
                        five2 = 0;
                    }
                    if (field[n-1-j][z] == cell.type){
                        five3++;} else {
                        five3 = 0;
                    }
                    if (field[z][n-1-z] == cell.type){
                        five4++;} else {
                        five4 = 0;}
                    z--;
                    if ((five1 == 5)|(five2 == 5)|(five3 == 5)|(five4 == 5)){
                        return true;}
                    if ((five1 == 5)|(five2 == 5)|(z<0)|(five3 == 5)|(five4 == 5)){
                        break;}
                }





            }
        k=n;
        for(int i = k; i < n-1; i++) {
            if (five1 == 5){break;}
            five1 = 0;
            for ( int j = 0; j < k+1; j++){
                if (field[z][j] == cell.type){
                    five1++;
                    z--;
                }
            }
            z=i;



            if (five1 == 5)
                return true;
        }



        for(int i = n-1; i < n; i--)
        {
            if (field[i][n-1-i] != cell.type)
                break;
            if (i == 0)
                return true;
        }

       return false;
    }

    // проверка, на наличие свободных ячеек поля
    boolean isFieldFilled()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == Cell.Type.Null) {
                    return false;
                }
            }
        }

        return true;
    }

    // текущее поле
    void printField()
    {
        System.out.print("@  ");
        for(int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        String d;

        for(int i = 0; i < n; i++) {
            if (i<10) {
            System.out.print(i + "  ");}
            else {System.out.print(i + " ");}
            for(int j = 0; j < n; j++) {
                if (j<10){
                 d = ".";
                if (field[i][j] == Cell.Type.X){
                    d = "X";}
                else if (field[i][j] == Cell.Type.O){
                    d = "O";}} else {
                d = " .";
                if (field[i][j] == Cell.Type.X){
                    d = " X";}
                else if (field[i][j] == Cell.Type.O){
                    d = " O";}}

                System.out.print(d + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
