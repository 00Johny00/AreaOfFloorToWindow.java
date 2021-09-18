import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Obliczenia  extends JFrame{
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField3;
    private JButton button1;
    private JLabel wynik;
    private JPanel podlogaPanel;
    private JButton button2;
    private JPanel oknaPanel;
    private JPanel mainPanel;
    private JButton dodajOkno;
    private JLabel field;
    private JButton usuńOknoButton;
    private JTextArea textArea1;

    Obliczenia() {
        this.setVisible(true);
        this.getContentPane().add(mainPanel);
        pack();

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField1.getText()); //Sprawdzamy teksty na konsoli
                System.out.println(textField3.getText());
                BigDecimal a = new BigDecimal (Double.parseDouble(textField1.getText()));
                BigDecimal b = new BigDecimal (Double.parseDouble(textField3.getText()));
                BigDecimal FLOOR_TO_WINDOW_PARAMETER = new BigDecimal(8);
                BigDecimal powierzchniaPodlogi = a.multiply(b).multiply(FLOOR_TO_WINDOW_PARAMETER);  // wysokosc okna * szerokosc * wartość normowana
                wynik.setText(okrajanieZer.format(powierzchniaPodlogi) + "m2");  // ustawiamy wynik taki jak wyniczek
                System.out.println("WYNIK : " + wynik.getText()); // Wyrzucamy sobie wynik na konsole do wglądu

            }

        });

        ArrayList<String> oknoDodane = new ArrayList<>(20);

       // double[] oknoWysokosc = new double[10];
      //  double[] oknoSzerokosc = new double[10];
     //   dodajOkno.addKeyListener(new KeyAdapter() {
      //                           });
       dodajOkno.addActionListener(new

            ActionListener() {
                int i = 1;
                @Override
                public void actionPerformed (ActionEvent e){
                    oknoDodane.add(new String(textField1.getText()));
                    oknoDodane.add(new String(textField3.getText()));
                    JOptionPane.showMessageDialog(null,"Dodałeś okno");
                    System.out.println(oknoDodane);
                    System.out.println(oknoDodane.get(i));
               //     stworzoneOkna.setText(String.valueOf(oknoDodane));
                  wyświetlanieOkien(oknoDodane,i);
                    i++;
                 //   stworzoneOkna.setText(stworzoneOkna.getText() +
                //            "Okno nr " + (i-1)+ " Szerokość:" + (oknoDodane.get(i-1))  + "Wysokość :"+ (oknoDodane.get(i)) + System.lineSeparator()

                //    );

                }
            });

        }

    public void wyświetlanieOkien (ArrayList okienko,int i2)
    {
        if(i2>1) {
            textArea1.setText(textArea1.getText() + System.lineSeparator() +
                    "Okno nr " + (i2) + " Szerokość: " + (okienko.get((i2*2)-2)) + "m2" +"  Wysokość : " + (okienko.get((i2*2)-1)) + "m2"
            );
        } else {
            textArea1.setText(
                    "Okno nr " + (i2) + " Szerokość: " + (okienko.get(i2 - 1)) + "m2"+ "  Wysokość : " + (okienko.get(i2)) + "m2"
            );
        }
    }


    DecimalFormat okrajanieZer = new DecimalFormat("0.0#"); //Do zaokrąglenia do 2 znaczących

    public static void main(String[] args) {
        new Obliczenia();
    }
}
