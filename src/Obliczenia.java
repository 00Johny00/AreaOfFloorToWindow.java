import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    private JLabel stworzoneOkna;
    double powierzchniaPodlogi;

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
                double a = Double.parseDouble(textField1.getText()); //Konwesrja Stringów na Double
                double b = Double.parseDouble(textField3.getText());
                powierzchniaPodlogi = a*b*8; // wysokosc okna * szerokosc * wartość normowana
                wynik.setText(okrajanieZer.format(powierzchniaPodlogi) + "m2");  // ustawiamy wynik taki jak wyniczek
                System.out.println("WYNIK : " + wynik.getText()); // Wyrzucamy sobie wynik na konsole do wglądu

            }

        });

        double[] oknoWysokosc = new double[10];
        double[] oknoSzerokosc = new double[10];
        dodajOkno.addKeyListener(new KeyAdapter() {
        });
        dodajOkno.addActionListener(new ActionListener() {
           int i=1;
            @Override
            public void actionPerformed(ActionEvent e) {
                oknoSzerokosc[i] = Double.parseDouble(textField1.getText()); //Konwesrja Stringów na Double
                System.out.println(oknoSzerokosc[i]);
                oknoWysokosc [i] = Double.parseDouble(textField3.getText());
                System.out.println(oknoWysokosc[i]);
                dodajOknoDoListy(oknoSzerokosc[i],oknoWysokosc[i]);
                 i++;
                    System.out.println(stworzoneOkna.getText());
            }

            public void dodajOknoDoListy(double szer, double wys)
            {
                JLabel noweOkno = new JLabel("Szerokość: " + oknoSzerokosc[i] + "m2" + "Wysokość: " + oknoWysokosc[i] + "m2");
                mainPanel.add(noweOkno);

            }

        });

    }
    DecimalFormat okrajanieZer = new DecimalFormat("0.0#"); //Do zaokrąglenia do 2 znaczących

    public static void main(String[] args) {
        new Obliczenia();
    }
}
