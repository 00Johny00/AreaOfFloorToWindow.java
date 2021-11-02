import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class AreaOfFloorToWindow extends JFrame {

    AreaOfFloorToWindow() {
        this.setVisible(true);
        this.setBounds(300, 600, 1000, 400);
        this.setLayout(new GridLayout(3, 3));
        this.getContentPane().add(buttonAddWindow, BorderLayout.SOUTH);
        this.getContentPane().add(buttonDeleteWindow, BorderLayout.SOUTH);
        this.getContentPane().add(buttonCalculate, BorderLayout.SOUTH);
        this.getContentPane().add(getWidth, BorderLayout.NORTH);
        this.getContentPane().add(getHeight, BorderLayout.NORTH);
        this.getContentPane().add(result, BorderLayout.CENTER);
        this.getContentPane().add(mainPanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.setDefaultCloseOperation(3);

        getWidth.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char zn = e.getKeyChar();
                if (!(zn >= '0' && zn <= '9' || zn == '.'))
                    e.consume();
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        getHeight.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char zn = e.getKeyChar();
                if (!(zn >= '0' && zn <= '9' || zn == '.'))
                    e.consume();
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        buttonAddWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                widthWindow.add(BigDecimal.valueOf(Double.valueOf(getWidth.getText())));
                heightWindow.add(BigDecimal.valueOf(Double.valueOf(getHeight.getText())));
                System.out.println(widthWindow);
                showWindows();
                applicationRefresh();

            }

        });


        buttonDeleteWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int windowNumber = widthWindow.size();
                int windowIndex = windowNumber - 1;
                if (windowNumber == 0) {
                    JOptionPane.showMessageDialog(null, "You can not delete more windows");
                } else {
                    mainPanel.removeAll();
                    widthWindow.remove(windowIndex);
                    heightWindow.remove(windowIndex);
                    showWindows();
                    applicationRefresh();
                }
            }
        });

        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BigDecimal resultParameter = new BigDecimal(0);

                for (int i = 0; i < widthWindow.size(); i++) {
                    resultParameter = widthWindow.get(i).multiply(heightWindow.get(i)).multiply((PARAMETER_OF_MULIPLY_SQUARE).add(resultParameter));
                    System.out.println(resultParameter);
                }
                result.setText("Floor square availve is : " + twoNumbersAfterCommaFormat.format(resultParameter) + "m2");
            }
        });


    }
    public void showWindows()
    {
        for (int i = 0; i < (widthWindow.size()); i++) {
            JLabel showWindows = new JLabel("Window number " + i + "  Width: " + widthWindow.get(i) + "m  Heigh: " + heightWindow.get(i) + "m");
            mainPanel.setVisible(true);
            mainPanel.add(showWindows);
        }
    }
    public void applicationRefresh()
    {
        SwingUtilities.updateComponentTreeUI(this);
    }
    JPanel mainPanel = new JPanel();
    JButton buttonAddWindow = new JButton("ADD WINDOW");
    JButton buttonDeleteWindow = new JButton("DELETE WINDOW");
    JButton buttonCalculate = new JButton("CALCULATE");
    JTextField getWidth = new JTextField(15);
    JTextField getHeight = new JTextField(15);
    JTextArea result = new JTextArea();
    ArrayList<BigDecimal> widthWindow = new ArrayList<>();
    ArrayList<BigDecimal> heightWindow = new ArrayList<>();
    final BigDecimal PARAMETER_OF_MULIPLY_SQUARE = new BigDecimal(8);
    DecimalFormat twoNumbersAfterCommaFormat = new DecimalFormat("0.0#"); //Do zaokrąglenia do 2 znaczących

    public static void main(String[] args) {
        new AreaOfFloorToWindow();
    }
}
