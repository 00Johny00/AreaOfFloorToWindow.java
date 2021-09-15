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
                BigDecimal a = new BigDecimal (Double.parseDouble(textField1.getText())); //Konwesrja Stringów na Double
                BigDecimal b = new BigDecimal (Double.parseDouble(textField3.getText())); //Konwesrja Stringów na Double
                BigDecimal powierzchniaPodlogi = a.mulitply(b).multiply(8);   //a*b*8; wysokosc okna * szerokosc * wartość normowana
                wynik.setText(okrajanieZer.format(powierzchniaPodlogi) + "m2");  // ustawiamy wynik taki jak wyniczek // Sprawdzić czy po zmianie na Big formatujez zer nie potrzebnych tak samo
                System.out.println("WYNIK : " + wynik.getText()); // Wyrzucamy sobie wynik na konsole do wglądu

            }

        });

        double[] oknoWysokosc = new double[10]; // Zrobić ArrayList  : List<String> oknoWysokosc = new ArrayList<>(100);
        double[] oknoSzerokosc = new double[10]; //List<String> oknoSzerokosc = new ArrayList<>(100);
        dodajOkno.addKeyListener(new KeyAdapter() {
        });
        dodajOkno.addActionListener(new ActionListener() {
           int i=1;
            @Override
            public void actionPerformed(ActionEvent e) {
                oknoSzerokosc[i] = Double.parseDouble(textField1.getText()); //Tutaj teraz nie potrzebne dodawanie do indeksu tylko .add(oknoWysokosc(textField1.getText());
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
