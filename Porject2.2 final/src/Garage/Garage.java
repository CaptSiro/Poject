package Garage;

import java.util.Arrays;

public class Garage implements GarageInf {
  // vytvareni jednoducheho objektu typu Vehicle (public proto ze se typ Vehicle pouziva i v jinych tridach)
  public class Vehicle {
    public String sign;
    public String type;

    Vehicle(String sign, String type) {
      this.sign = sign;
      this.type = type;
    }
  }

  // hlavni datova struktura pole, ktera dynamicky meni pocet svych prvku
  public Vehicle[] garageInv = new Vehicle[0];

  @Override
  public String add(String sign, String type) {
    // 'sign' nesmi byt prazdny string, musi neco obsahovat
    if (!sign.equals("")) {
      boolean only = true;
  
      // prohledani hlavni pole jestli nejake vozidlo nema uz stejnou znacku (znacka musi byt jedinecna)
      for (int i = 0; i < garageInv.length; i++) {
        if (garageInv[i].sign.equals(sign)) {
          only = false;
        }
      }
  
      if (only == true) {
        // pokud je jedinecna

        int newLen = garageInv.length + 1;
        // vytvoreni kopie hlavniho pole, ale s delkou o jednou vetsi nez hlavni
        Vehicle[] newGarageInv = Arrays.copyOf(garageInv, newLen);
        // vytvoreni a pripsani noveho vozidla na konec kopie pole
        newGarageInv[garageInv.length] = new Vehicle(sign, type);
  
        // ulozeni kopie pole jako hlavni pole
        garageInv = Arrays.copyOf(newGarageInv, newLen);
  
        // vraceni 'null' pro znaceni "zadny error pri vytvareni noveho prvku"
        return null;
      } else {
        // pokud znacka neni jedinecna vraceni erroru
        return "Error A01: Vehicle with sign: '" + sign + "' is already assigned.";
      }
    } else {
      // vraceni erroru kdyz je 'sign' prazdne
      return "Error A02: Sign field is empty.";
    }
  }

  @Override
  public void remove(String sign) {
    // zjisteni pokud je garaz prazdna
    if (isEmpty() == false) {
      boolean exists = false;

      // vytvoreni kopie ale o jeden prvek kratsi
      Vehicle[] newGarInv = new Vehicle[garageInv.length - 1];
  
      int j = 0;
  
      for (int i = 0; i < garageInv.length; i++) {
        // pokud se nerovna hledanemu objektu tak pripis prvek ke kopii
        if (!garageInv[i].sign.equals(sign)) {
          // pokud je na poslednim prvku a hledany prvek nebyl nalezen tak preskoc, aby nebyl error "index out of bounds"
          if (!(exists == false && i == garageInv.length - 1)) {
            newGarInv[j] = garageInv[i];
            j++;
          }
        } else {
          // prvek nalezen a preskocen k pripisovani ke kopii
          exists = true;
        }
      }
  
      // pokud byl hledany prvek nalezen tak uloz kopii jako hlavni pole
      if (exists == true) {
        garageInv = Arrays.copyOf(newGarInv, garageInv.length - 1);
      }
    }
  }

  @Override
  public Vehicle find(String sign) {
    if (isEmpty() == false) {
      Vehicle el = null;

      // hledani prvku v hlavnim poli podle znacky
      for (int i = 0; i < garageInv.length; i++) {
        if (garageInv[i].sign.equals(sign)) {
          el = garageInv[i];
        }
      }
      
      return el;
    } else {

      // pokud se vrati null tak to znaci ze prvek nebyl nalezen
      return null;
    }
  }

  @Override
  public int findIndex(String sign) {
    if (isEmpty() == false) {
      int index = -1;

      // hledani prvku podle znacky, pokud nalezen tak se ulozi aktualni index
      for (int i = 0; i < garageInv.length; i++) {
        if (garageInv[i].sign.equals(sign)) {
          index = i;
        }
      }
      
      return index;
    } else {

      // vraceni -1 znaci ze prvek nebyl nalezen
      return -1;
    }
  }

  @Override
  public boolean isEmpty() {
    // pokud delka pole se rovna '0' tak vratit hodnotu true, jakakoliv jina hodnota vrati false
    if (garageInv.length == 0) {
      return true;
    }
    return false;
  }

  @Override
  public String[] stringify() {
    // vytvoreni pole o stejne delce jako hlavni pole ale s typem String
    String[] garageS = new String[garageInv.length];

    // skladani stringu stylem: "Sign" a ukladani do pole
    for (int i = 0; i < garageS.length; i++) {
      garageS[i] = garageInv[i].sign;
    }

    return garageS;
  }

  @Override
  public void debug() {
    // vypsani debug menu do konzole
    // debug menu obsahuje: delku hlavniho pole, jestli je prazdne, a obsah pole se vsemi atributy Vehicle objektu
    System.out.println("\nDebug center:\n1} Length: '" + garageInv.length + "'\n2} Garage Inventory: ");

    if (isEmpty() == true) {
      System.out.println("Garage is empty"); 
    }

    System.out.println();
    
    for (int i = 0; i < garageInv.length; i++) {
      System.out.println("Sign: '" + garageInv[i].sign + "'; Type: '" + garageInv[i].type + "';");
    }

    System.out.println();
  }
}