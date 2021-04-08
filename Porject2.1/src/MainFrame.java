import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Garage.*;
import Zakazky.*;

public class MainFrame extends JFrame implements ActionListener {
  public Garage mainGarage;
  public List mainList;

  JPanel pravyPanel = new JPanel();
  JPanel levyPanel = new JPanel();
  JPanel hledaniVozidelPanel = new JPanel();
  JPanel vytvoritZakazkuPanel = new JPanel();
  JPanel nevyrizeneZakazkyPanel = new JPanel();
  JLabel nazev = new JLabel("Evidence vozidel");
  JLabel hledaniLabel = new JLabel("Vyhledávání vozidel");
  JLabel detail = new JLabel("");
  JLabel nevyrizene = new JLabel("Nevyřízené zakázky");
  JLabel zakazkaNazev = new JLabel("Vytvořit zakázku");
  JLabel nazevE = new JLabel("Evidence zakázek");
  JLabel znacka = new JLabel("registrační značka: ");
  JLabel datum = new JLabel("Datum: ");
  JLabel znackaDva = new JLabel("registrační značka: ");
  JButton potvrdit;
  JButton prvni = new JButton();
  JButton vyradit = new JButton();
  JButton noveVozidlo = new JButton();

  String[] s = {"Co", "ja", "vim"};

  JTextField znackaText = new JTextField();
  public JComboBox<String> hledaniZnacky;

  MainFrame(Garage garage, List list) {
      this.hledaniZnacky = new JComboBox<String>(garage.stringify());

      this.mainGarage = garage;
      this.mainList = list;

          this.setTitle("lol");
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(1010, 720);
          // this.setResizable(false);
          this.setLocationRelativeTo(null);
          this.setLayout(null);
          levyPanel.setLayout(null);
          pravyPanel.setLayout(null);
          hledaniVozidelPanel.setLayout(null);
          vytvoritZakazkuPanel.setLayout(null);
          nevyrizeneZakazkyPanel.setLayout(null);

          levyPanel.setBackground(new Color(0, 150, 100, 150));
          levyPanel.setBounds(0, 0, 500, 700);
          pravyPanel.setBackground(new Color(160, 0, 30, 140));
          pravyPanel.setBounds(500, 0, 500, 700);

          nazev.setFont(new Font("monospaced", Font.BOLD, 21));
          nazev.setBounds(130, 15, 250, 35);
          nazevE.setFont(new Font("monospaced", Font.BOLD, 21));
          nazevE.setBounds(130, 15, 250, 35);

          // ---------------------- panel vozidla----------------------------------
          hledaniVozidelPanel.setBackground(new Color(250, 150, 100));
          hledaniVozidelPanel.setBounds(10, 70, 480, 300);

          hledaniLabel.setFont(new Font("monospaced", Font.BOLD, 20));
          hledaniLabel.setBounds(10, 10, 250, 30);

          znacka.setFont(new Font("monospaced", Font.BOLD, 16));
          znacka.setBounds(20, 60, 220, 30);

          znackaText.setBounds(230, 60, 220, 30);

          // detail.setFont(new Font("monospaced", Font.BOLD, 15));
          // detail.setBounds(20, 100, 250, 30);
          // detail.setText("Zakázky vozidla " + znackaText.getText());
          // detail.setVisible(false);

          potvrdit = new JButton();
          potvrdit.setBounds(20, 230, 125, 50);
          potvrdit.setFont(new Font("monospaced", Font.BOLD, 16));
          potvrdit.addActionListener(this);

          potvrdit.setText("potvrdit");

          vyradit = new JButton();
          vyradit.setBounds(180, 230, 260, 50);
          vyradit.setFont(new Font("monospaced", Font.BOLD, 16));
          vyradit.addActionListener(e -> System.out.println("zmenit"));
          vyradit.setText("vyřadit toto vozidlo");
          vyradit.setVisible(false);

          noveVozidlo = new JButton();
          noveVozidlo.setBounds(10, 400, 170, 55);
          noveVozidlo.setFont(new Font("monospaced", Font.BOLD, 16));
          noveVozidlo.addActionListener(e -> new newCarWindow());
          noveVozidlo.setText("nové vozidlo");

          // ----------------------panel zakazky------------------------------
          vytvoritZakazkuPanel.setBackground(new Color(220, 255, 0));
          vytvoritZakazkuPanel.setBounds(10, 70, 480, 300);

          zakazkaNazev.setFont(new Font("monospaced", Font.BOLD, 20));
          zakazkaNazev.setBounds(10, 10, 230, 30);

          znackaDva.setBounds(20, 60, 220, 30);
          znackaDva.setFont(new Font("monospaced", Font.BOLD, 16));

          datum.setFont(new Font("monospaced", Font.BOLD, 16));
          datum.setBounds(20, 100, 200, 30);
          hledaniZnacky.setBounds(230, 60, 230, 30);
          
          prvni = new JButton();
          prvni.setBounds(340,230,120,50);
          prvni.addActionListener(e -> JOptionPane.showMessageDialog(null, "zakázka byla úspěšně přidána", "děkujeme", JOptionPane.INFORMATION_MESSAGE));
          prvni.setText("potvrdit");
          prvni.setFont(new Font("monospaced", Font.BOLD, 16));

          // -------------------panel nevvyrizene------------------------
          nevyrizeneZakazkyPanel.setBackground(new Color(80, 250, 180));
          nevyrizeneZakazkyPanel.setBounds(10, 380, 480, 280);

          nevyrizene.setFont(new Font("monospaced", Font.BOLD, 20));
          nevyrizene.setBounds(10, 10, 260, 30);


          levyPanel.add(hledaniVozidelPanel);
          levyPanel.add(nazev);

          levyPanel.add(noveVozidlo);

          hledaniVozidelPanel.add(hledaniLabel);
          hledaniVozidelPanel.add(znacka);
          hledaniVozidelPanel.add(potvrdit);
          hledaniVozidelPanel.add(znackaText);
          hledaniVozidelPanel.add(vyradit);
          hledaniVozidelPanel.add(detail);

          pravyPanel.add(nazevE);
          pravyPanel.add(nevyrizeneZakazkyPanel);
          pravyPanel.add(vytvoritZakazkuPanel);

          vytvoritZakazkuPanel.add(zakazkaNazev);
          vytvoritZakazkuPanel.add(znackaDva);
          vytvoritZakazkuPanel.add(hledaniZnacky);
          vytvoritZakazkuPanel.add(datum);
          vytvoritZakazkuPanel.add(prvni);


          nevyrizeneZakazkyPanel.add(nevyrizene);

    this.add(levyPanel);
    this.add(pravyPanel);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == potvrdit) {
      String s = znackaText.getText();
      

      vyradit.setVisible(true);
      detail.setVisible(true);

      System.out.println(s);
    }
  }

  public class newCarWindow extends JFrame implements ActionListener{
      JLabel nazev = new JLabel("Nové vozidlo");
      JLabel znacka = new JLabel("registrační značka: ");
      JTextField znackaText = new JTextField();
      JButton pridat = new JButton();
      JButton zrusit= new JButton();
      JLabel typ = new JLabel("typ: ");
      JTextField typText = new JTextField();

      String[] cjstrings = {"Car", "Van", "Truck"};
      JComboBox combojumbo = new JComboBox<String>(cjstrings);

      newCarWindow(){
          this.setTitle("nové vozidlo");
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       this.setSize(700, 500);
       //this.setResizable(false);
       this.setLocationRelativeTo(null);
       this.setLayout(null);

       nazev.setFont(new Font("monospaced", Font.BOLD, 21));
       nazev.setBounds(260, 20, 200, 40);

       znacka.setFont(new Font("monospaced", Font.BOLD, 16));
       znacka.setBounds(30, 120, 220, 30);

       znackaText.setBounds(240, 120, 250, 30);

       pridat = new JButton();
       pridat.setBounds(350,400,120,50);
       pridat.setFont(new Font("monospaced", Font.BOLD, 16));
       pridat.addActionListener(this);
       pridat.setText("přidat");

       zrusit.setBounds(220,400,120,50);
       zrusit.setFont(new Font("monospaced", Font.BOLD, 16));
       zrusit.addActionListener(e -> this.dispose());
       zrusit.setText("zrušit");

       typ.setFont(new Font("monospaced", Font.BOLD, 16));
      typ.setBounds(30, 150, 220, 30);
      combojumbo.setBounds(240, 150, 250, 30);
        this.add(combojumbo);
      this.add(typ);

       this.add(nazev);
       this.add(znacka);
       this.add(znackaText);
       this.add(pridat);
       this.add(zrusit);

       this.setVisible(true);
      
      }

    @Override
    public void actionPerformed(ActionEvent e) {
      boolean result = false;
      String sign = znackaText.getText();
      String type = (String) combojumbo.getSelectedItem();

      if (e.getSource() == pridat) {
        result = mainGarage.add(sign, type);
      }

      if (result == true) {
        this.dispose();

        hledaniZnacky.addItem(sign);
        
        mainGarage.debug();
      }
    }
  }
}