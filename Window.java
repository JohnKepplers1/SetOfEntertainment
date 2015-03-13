import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {


    // размер игровой доски.
    private final int BOARD_SIZE = 15;
    // размер ячейки игровой доски, px.
    private final int FIELD_WIDTH = 34;
    // количество крестиков или ноликов в непрерывной линии, при котором засчитывается выигрыш.
    private final int WIN_COUNT = 5;
    // размеры окна, px
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGTH = 520;
    M m = new M();
    Field field = new Field(m.j);
    // если true - первыми начинают игру крестики
    private boolean playerIsX = true;
    private JPanel gamePanel;

    // счет игры
    private int xCount = 0;
    private int oCount = 0;

    private Field board;

    public Window() {

        board = new Field(m.j);

        // создание меню
        JMenuBar mainMenu = new JMenuBar();
        setJMenuBar(mainMenu);
        JMenu fileMenu = new JMenu("Файл");
        JMenu helpMenu = new JMenu("Справка");
        JMenuItem exitItem = new JMenuItem("Выход");
        JMenuItem clearItem = new JMenuItem("Новая игра");
        fileMenu.add(exitItem);
        fileMenu.add(clearItem);
        JMenuItem aboutItem = new JMenuItem("О программе");
        helpMenu.add(aboutItem);
        mainMenu.add(fileMenu);
        mainMenu.add(helpMenu);

        // панель на которой размещена игровая доска
        gamePanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        JScrollPane scrollFrame = new JScrollPane(gamePanel);
        gamePanel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGTH));

        for (int i = 0; i < board.size(); i++) {

            for (int j = 0; j < board.size(); j++) {

                JButton btn = new JButton(board.getItemAt(i, j).getName());
                btn.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_WIDTH));
                btn.setAction(new ButtonClickAction(i, j));
                gamePanel.add(btn);
            }
        }

        setContentPane(scrollFrame);
        pack();

        // события
        exitItem.addActionListener(new ExitActionListener());
        aboutItem.addActionListener(new AboutActionListener());
        clearItem.addActionListener(new ClearActionListener());

        SwingUtilities.updateComponentTreeUI(mainMenu);
        SwingUtilities.updateComponentTreeUI(gamePanel);
    }

    // Очистить игровую доску
    private void clearGamePanel() {

        playerIsX = true;
        int count = 0;

        //очистка элементов игровой доски - тех, которые были использованы
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {

                Cell.Type item = board.getItemAt(i, j);
                if (!item.equals(Cell.Type.Null)) {
                    JButton button = (JButton) gamePanel.getComponents()[count];
                    button.setText(new String());
                    button.setEnabled(true);
                    button.setBackground(null);
                    button.setForeground(null);
                }
                count++;
            }
        }

        board = new Field(m.j);
    }

    private void renderGameField() {
        int count = 0;
        for (int i = 0; i < board.size(); i++)
            for (int j = 0; j < board.size(); j++) {
                JButton buff = (JButton) gamePanel.getComponents()[count++];
                buff.setText(board.getItemAt(i, j).getName());

                if (board.getItemAt(i, j).equals(Cell.Type.O)
                        || board.getItemAt(i, j).equals(Cell.Type.X)) {
                    buff.setOpaque(true);
                    buff.setForeground(Color.BLACK);
                }
            }
    }

    // действие при нажатии на кнопку (игровую ячейку)
    private class ButtonClickAction extends AbstractAction {

        private static final long serialVersionUID = 1L;


        // индекс ячейки игровой доски
        private int i, j;

        public ButtonClickAction(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            JButton source = (JButton) e.getSource();

            // клик по пустому полю
            if (!board.getItemAt(i, j).equals(Cell.Type.Null))
                return;

            // установка крестика или нолика на поле
            board.setItemAt(playerIsX ? Cell.Type.X : Cell.Type.O, i, j);
            source.setText(board.getItemAt(i, j).getName());
            source.setEnabled(false);

            // меняем игрока
            playerIsX = !playerIsX;

            // проверка, есть ли победитель
            Cell.Type winner = board.getNextWinner(WIN_COUNT);

            if (winner != null && !winner.equals(Cell.Type.Null)) {

                String msg;

                if (winner.equals(Cell.Type.X)) {
                    msg = "крестиков";
                    xCount++;
                } else {
                    msg = "ноликов";
                    oCount++;
                }

                renderGameField();

                JOptionPane.showMessageDialog(Window.this, "Победа " + msg
                                + ", счет " + " - крестики (" + xCount + "): нолики ("
                                + oCount + ")", "Победа",
                        JOptionPane.INFORMATION_MESSAGE);

                clearGamePanel();

            }
        }
    }

    // выход из приложения
    private class ExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    // сброс игры
    private class ClearActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            clearGamePanel();
            xCount = 0;
            oCount = 0;
        }
    }

    // окно "о программе"
    private class AboutActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(Window.this, "Крестики-нолики "
                            + BOARD_SIZE + "x" + BOARD_SIZE
                            + ". \nДля победы составьте линию из " + WIN_COUNT
                            + " крестиков или ноликов.", "О программе",
                    JOptionPane.INFORMATION_MESSAGE);


        }
    }

}
