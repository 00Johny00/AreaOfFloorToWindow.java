import javax.swing.*;
import javax.swing.plaf.SeparatorUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ObliczaniePolaPowierzchni extends JFrame {

    ObliczaniePolaPowierzchni()
    {
        this.setVisible(true);
        this.getContentPane().add(glownyPanel);
        glownyPanel.add(przyciskDodajOkno);
        glownyPanel.add(przyciskUsuńOkno);
        glownyPanel.add(Oblicz);
        glownyPanel.add(pobierzSzerokosc);
        glownyPanel.add(pobierzWysokosc);
        glownyPanel.add(wynikPowierzchni);
        this.setDefaultCloseOperation(3);
        this.setBounds(300,300,300,300);
        this.setLayout(new GridLayout(5,5));
        przyciskDodajOkno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szerokoscOkna.add(BigDecimal.valueOf(Double.valueOf(pobierzSzerokosc.getText())));
                wysokoscOkna.add(BigDecimal.valueOf(Double.valueOf(pobierzWysokosc.getText())));
                System.out.println(szerokoscOkna);
                int i = szerokoscOkna.size()-1;
                JLabel wyswietlOkno = new JLabel("Okno nr " + i + ":" + szerokoscOkna.get(i) + "m2 " + wysokoscOkna.get(i) + "m2 ");
                glownyPanel.add(wyswietlOkno);
                pack();
            }
        });
        przyciskUsuńOkno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int iloscOkien = szerokoscOkna.size()-1;
                System.out.println(iloscOkien);
                BigDecimal czyOstatniaToZero = szerokoscOkna.get(iloscOkien);
                System.out.println(czyOstatniaToZero);
                if (iloscOkien == 0)
                {
                    JOptionPane.showMessageDialog(null, "DAJ SPOKÓJ TYM OKNOM ICH JUŻ NIE MA!");
                }
                else {
                    if (!czyOstatniaToZero.equals(0)) {
                        szerokoscOkna.remove(iloscOkien);
                        wysokoscOkna.remove(iloscOkien);
                        iloscOkien--;
                        
                        } else czyOstatniaToZero.subtract(BigDecimal.ONE);
                    System.out.println(szerokoscOkna);
                }
            }
        });

    Oblicz.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            BigDecimal wynik = new BigDecimal(0);

           for(int i=0; i < szerokoscOkna.size(); i++)
            {
                wynik = szerokoscOkna.get(i).multiply(wysokoscOkna.get(i)).multiply(wartośćMnożeniaPowierzchni).add(wynik);
                System.out.println(wynik);
            }
           wynikPowierzchni.setText("Powierzchnia podłogi jaką możesz stworzyć to: " + wynik + "m2");
        }
    });

    }
    JPanel glownyPanel = new JPanel();
    JButton przyciskDodajOkno = new JButton("Dodaj Okno");
    JButton przyciskUsuńOkno = new JButton("Usuń Okno");
    JButton Oblicz = new JButton("Oblicz");
    JTextField pobierzSzerokosc = new JTextField(15);
    JTextField pobierzWysokosc = new JTextField(15);
    JTextArea wynikPowierzchni = new JTextArea();


   ArrayList<BigDecimal> szerokoscOkna = new ArrayList<>();
   ArrayList<BigDecimal> wysokoscOkna = new ArrayList<>();
   final BigDecimal wartośćMnożeniaPowierzchni = new BigDecimal(8);



    public static void main(String[] args) {
        new ObliczaniePolaPowierzchni();
    }
}
