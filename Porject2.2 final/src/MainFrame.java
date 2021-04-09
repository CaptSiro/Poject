import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Garage.*;
import Garage.Garage.Vehicle;
import Zakazky.*;

public class MainFrame extends JFrame implements ActionListener {
  public Garage mainGarage;
  public List mainList;

  JPanel pravyPanel = new JPanel();
  JPanel levyPanel = new JPanel();
  JPanel hledaniVozidelPanel = new JPanel();
  JPanel vytvoritZakazkuPanel = new JPanel();
  JPanel nevyrizeneZakazkyPanel = new JPanel();
  JLabel konecZakazka= new JLabel("Z. výmaz: ");
  JLabel nazev = new JLabel("Evidence vozidel");
  JLabel nazevOb = new JLabel("Zakázka: ");
  JLabel hledaniLabel = new JLabel("Vyhledávání vozidel");
  JLabel nazevLabel = new JLabel("Název: ");
  JLabel detail = new JLabel("");
  JLabel nevyrizene = new JLabel("Nevyřízené zakázky");
  JLabel zakazkaNazev = new JLabel("Vytvořit zakázku");
  JLabel nazevE = new JLabel("Evidence zakázek");
  JLabel znacka = new JLabel("registrační značka: ");
  JLabel datum = new JLabel("Datum (1 - 365): ");
  JLabel znackaDva = new JLabel("registrační značka: ");
  JTextArea nevyrizeneLabel = new JTextArea("");
  JButton dokonceno = new JButton();
  JButton potvrdit;
  JButton konec = new JButton();
  JButton prvni = new JButton();
  JButton vyradit = new JButton();
  JButton noveVozidlo = new JButton();

  JTextField nazevObText = new JTextField();
  JTextField konecZakazkaText = new JTextField();
  JTextField nazevText = new JTextField();
  JTextField datumText = new JTextField();
  JTextField znackaText = new JTextField();
  public JComboBox<String> hledaniZnacky;

  MainFrame(Garage garage, List list) {
    this.hledaniZnacky = new JComboBox<String>(garage.stringify());
    
    this.mainGarage = garage;
    this.mainList = list;

    nevyrizeneLabel.setEditable(false);

    String snevy = mainList.stringify();
    nevyrizeneLabel.setText(snevy);
    
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

    detail.setFont(new Font("monospaced", Font.BOLD, 16));
    detail.setBounds(20, 90, 480, 30);

    // ---------------------- panel vozidla----------------------------------
    hledaniVozidelPanel.setBackground(new Color(250, 150, 100));
    hledaniVozidelPanel.setBounds(10, 70, 480, 300);

    hledaniLabel.setFont(new Font("monospaced", Font.BOLD, 20));
    hledaniLabel.setBounds(10, 10, 250, 30);

    znacka.setFont(new Font("monospaced", Font.BOLD, 16));
    znacka.setBounds(20, 60, 220, 30);

    znackaText.setBounds(230, 60, 220, 30);

    dokonceno.setBounds(340,220,120,50);
    dokonceno.addActionListener(this);
    dokonceno.setText("dokončeno");
    dokonceno.setFont(new Font("monospaced", Font.BOLD, 16));
    nevyrizeneZakazkyPanel.add(dokonceno);

    potvrdit = new JButton();
    potvrdit.setBounds(20, 230, 125, 50);
    potvrdit.setFont(new Font("monospaced", Font.BOLD, 16));
    potvrdit.addActionListener(this);

    potvrdit.setText("potvrdit");

    vyradit = new JButton();
    vyradit.setBounds(180, 230, 260, 50);
    vyradit.setFont(new Font("monospaced", Font.BOLD, 16));
    vyradit.addActionListener(this);
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

    nazevOb.setFont(new Font("monospaced", Font.BOLD, 16));
    nazevOb.setBounds(20, 230, 100, 30);
    nevyrizeneZakazkyPanel.add(nazevOb);

    nazevObText.setBounds(110, 230, 200, 30);
    nevyrizeneZakazkyPanel.add(nazevObText);

    zakazkaNazev.setFont(new Font("monospaced", Font.BOLD, 20));
    zakazkaNazev.setBounds(10, 10, 230, 30);

    znackaDva.setBounds(20, 60, 220, 30);
    znackaDva.setFont(new Font("monospaced", Font.BOLD, 16));

    datum.setFont(new Font("monospaced", Font.BOLD, 16));
    datum.setBounds(20, 100, 200, 30);
    hledaniZnacky.setBounds(230, 60, 230, 30);

    nazevLabel.setFont(new Font("monospaced", Font.BOLD, 16));
    nazevLabel.setBounds(20, 140, 200, 30);

    nazevText.setBounds(230, 140, 230, 30);

    datumText.setBounds(230, 100, 230, 30);
    vytvoritZakazkuPanel.add(datumText);
    vytvoritZakazkuPanel.add(nazevLabel);
    vytvoritZakazkuPanel.add(nazevText);
          
    prvni = new JButton();
    prvni.setBounds(340,230,120,50);
    prvni.addActionListener(this);
    prvni.setText("potvrdit");
    prvni.setFont(new Font("monospaced", Font.BOLD, 16));

    // -------------------panel nevvyrizene------------------------
    konecZakazka.setFont(new Font("monospaced", Font.BOLD, 16));
    konecZakazka.setBounds(20, 500, 100, 30);

    konecZakazkaText.setBounds(110, 500, 200, 30);

    nevyrizeneZakazkyPanel.setBackground(new Color(80, 250, 180));
    nevyrizeneZakazkyPanel.setBounds(10, 380, 480, 280);

    nevyrizene.setFont(new Font("monospaced", Font.BOLD, 20));
    nevyrizene.setBounds(10, 10, 260, 30);

    nevyrizeneLabel.setFont(new Font("monospaced", Font.BOLD, 16));

    JScrollPane scrollableTextArea = new JScrollPane(nevyrizeneLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollableTextArea.setBounds(10,50,460,150);

    nevyrizeneZakazkyPanel.add(scrollableTextArea);

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

    konec.setBounds(340,490,120,50);
    konec.addActionListener(this);
    konec.setText("odstranit");
    konec.setFont(new Font("monospaced", Font.BOLD, 16));
    levyPanel.add(konec);
    levyPanel.add(konecZakazka);
    levyPanel.add(konecZakazkaText);

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

      Vehicle res = mainGarage.find(s);
      
      if (res != null) {
        detail.setText(res.sign + " (" + res.type + ")");
        vyradit.setVisible(true);
        detail.setVisible(true);
      } else {
        detail.setText("");
        vyradit.setVisible(false);
        detail.setVisible(false);
      }
    }

    if (e.getSource() == vyradit) {
      String svyradit = znackaText.getText();

      Vehicle res = mainGarage.find(svyradit);

      if (res != null) {
        hledaniZnacky.removeItemAt(mainGarage.findIndex(res.sign));
        mainGarage.remove(svyradit);

        mainGarage.debug();

        detail.setText("");
        vyradit.setVisible(false);
        detail.setVisible(false);
      }
    }

    if (e.getSource() == prvni) {
      String name = nazevText.getText();
      boolean ok = true;
      int day = 0;

      try {
        day = Integer.parseInt(datumText.getText());
      } catch (Exception k) {
        if (datumText.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Error C03: 'Day' field is empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "Error C01: Value in input field 'Day' is not a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        ok = false;
      }
      
      String sign = hledaniZnacky.getSelectedItem().toString();

      if (ok == true) {
        Vehicle vehicle = mainGarage.find(sign);

        if (vehicle != null) {
          if (!name.equals("")) {
            String resadd = mainList.add(name, day, sign, mainGarage);
            
            if (!resadd.equals("ok")) {
              JOptionPane.showMessageDialog(null, resadd, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
              String stringnev = mainList.stringify();
              nevyrizeneLabel.setText(stringnev);
            }
          } else {
            JOptionPane.showMessageDialog(null, "Error C03: 'Name' field is empty.", "Error", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(null, "Error C02: Could not find vehicle that you are looking for.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }

    if (e.getSource() == dokonceno) {
      String sdone = nazevObText.getText();

      if (!sdone.equals("")) {
        String resdone = mainList.done(sdone);

        if (resdone.equals("ok")) {
          String snevyrizeneok = mainList.stringify();
        
          nevyrizeneLabel.setText(snevyrizeneok);
        }
      } else {
        JOptionPane.showMessageDialog(null, "Error C03: 'Done' field is empty.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    if (e.getSource() == konec) {
      String sText = konecZakazkaText.getText();

      if (sText.equals("")) {
        JOptionPane.showMessageDialog(null, "Error E02: Remove field is empty.", "Error", JOptionPane.ERROR_MESSAGE);
      } else {
        boolean res = mainList.remove(sText);
  
        if (res == false) {
          JOptionPane.showMessageDialog(null, "Error E01: Cloud not find Order with name '" + sText + "'.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          String restext = mainList.stringify();
          
          nevyrizeneLabel.setText(restext);
        }
      }
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
      String result = "error";
      String sign = znackaText.getText();
      String type = (String) combojumbo.getSelectedItem();

      if (e.getSource() == pridat) {
        result = mainGarage.add(sign, type);
      }

      if (result == null) {
        this.dispose();

        hledaniZnacky.addItem(sign);
        
        mainGarage.debug();
      } else {
        JOptionPane.showMessageDialog(null, result, "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}