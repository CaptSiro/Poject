package Zakazky;

import java.util.Arrays;
import Garage.Garage;
import Garage.Garage.Vehicle;

public class List implements ListInf {
  // vytvareni jednoducheho objektu typu Order
  private class Order {
    public String name;
    public int day;
    public Vehicle vehicle;
    public boolean done = false;

    Order(String name, int day, Vehicle vehicle) {
      this.name = name;
      this.day = day;
      this.vehicle = vehicle;
    }

    public void done() {
      this.done = !this.done;
    }
  }

  // hlavni datova struktura pole, ktera dynamicky meni pocet svych prvku
  public Order[] orders = new Order[0];

  @Override
  public String add(String name, int day, String sign, Garage garageNow) {
    if (garageNow.isEmpty() == false) {
      // pokud den neni v rozmezi roku
      if (day > 0 && day < 366) {
        boolean only = true;
    
        // zkouseni jedinosti nazvu zakazky
        for (int i = 0; i < orders.length; i++) {
          if (orders[i].name.equals(name)) {
            only = false;
          }
        }

        if (only == true) {
          // pokud je jedinecny nazev tak pripsani prvku stejnym principem jako u Garage.java
          int newLen = orders.length + 1;
          Order[] newOrders = Arrays.copyOf(orders, newLen);
  
          // najiti v aktualni verzi garaze podle znacky vozidla
          Vehicle vehicle = garageNow.find(sign);
  
          if (vehicle != null) {
            // pokud bylo vozidlo najito
            newOrders[orders.length] = new Order(name, day, vehicle);
            orders = Arrays.copyOf(newOrders, newLen);

            return "ok";
          } else {
            // pokud se vozidlo nepovedlo najit
            return "Error B03: 404 Vehicle not found.";
          }
        } else {
          // kdyz nazev neni originalni
          return "Error B02: Order with name '" + name + "' is already assigned";
        }
      } else {
        // kdyz den se neschoduje s intervalem
        return "Error B01: Incorrect day input. Day must be between 1 and 365.";
      }
    }

    return "Error B04: Garage is empty.";
  }

  @Override
  public boolean remove(String name) {
    if (isEmpty() == false) {
      boolean exists = false;
      // uplne stejny princip odebrani jako u Garage.java
      Order[] newOrders = new Order[orders.length - 1];
  
      int j = 0;
  
      for (int i = 0; i < orders.length; i++) {
        if (!orders[i].name.equals(name)) {
          if (!(exists == false && i == orders.length - 1)) {
            newOrders[j] = orders[i];
            j++;
          }
        } else {
          exists = true;
        }
      }
  
      if (exists == true) {
        orders = Arrays.copyOf(newOrders, orders.length - 1);
        return true;
      }
    }

    return false;
  }

  @Override
  public String stringify() {
    if (isEmpty() == false) {
      // poskladani pole podle dne
      sort();

      String string = "";
      boolean first = true;

      for (int i = 0; i < orders.length; i++) {
        // stringify() pozklada retezce pouze pokud nebyla zakazka dokoncena
        if (orders[i].done == false) {
          string += "Name: '" + orders[i].name + "' Day: '" + orders[i].day + "' Sign: '" + orders[i].vehicle.sign + "'\n";
        } else {
          if (first == true) {
            first = false;
            string += "----Hotové zakázky----\n";
          }

          string += "Name: '" + orders[i].name + "' Day: '" + orders[i].day + "' Sign: '" + orders[i].vehicle.sign + "'\n";
        }
      }

      return string;
    } else {
      // vraceni null kdyz je hlavni pole prazdne
      return null;
    }
  }

  @Override
  public String done(String name) {
    if (isEmpty() == false) {
      // hledani prvku v hlavnim poli a ukldani prvku
      Order el = null;
  
      for (int i = 0; i < orders.length; i++) {
        if (orders[i].name.equals(name)) {
          el = orders[i];
        }
      }
  
      if (el != null) {
        // pokud je nalezen tak obraceni polarity u atributu done
        el.done();
        return "ok";
      }
    }
    return "Error D01: List of Orders is empty.";
  }

  @Override
  public void sort() {
    if (isEmpty() == false) {
      // klasicky bubblesort
      for (int i = 0; i < orders.length; i++) {
        int k = 1;

        for (int j = 0; j < orders.length - 1; j++) {
          Order a = orders[j];  // prvni
          Order b = orders[k];  // druhy
          byte result;

          if (a.day > b.day) {
            result = -1;
          } else if (a.day < b.day) {
            result = 1;
          } else {
            result = 0;
          }

          if (result < 0) { // result == -1
            orders[j] = b;  // prohozeni
            orders[k] = a;
          }

          k++;
        }
      }

      // kvuli nejakemu problemu v Jave to musim udelat pres dva bubblesort algoritmy (ze dne na den nefungoval if() na radku 192 v prvnim bubblesortu)

      for (int i = 0; i < orders.length; i++) {
        int k = 1;

        for (int j = 0; j < orders.length - 1; j++) {
          Order a = orders[j];  // prvni
          Order b = orders[k];  // druhy
          byte result = 0;

          if (orders[j].done == true) {
            result = -1;
          }

          if (result < 0) { // result == -1
            orders[j] = b;  // prohozeni
            orders[k] = a;
          }

          k++;
        }
      }
    }
  }

  @Override
  public boolean isEmpty() {
    // pokud delka pole se rovna '0' tak vratit hodnotu true, jakakoliv jina hodnota vrati false
    if (orders.length == 0) {
      return true;
    }
    return false;
  }

  @Override
  public void debug() {
    // vypsani debug menu do konzole
    // debug menu obsahuje: delku hlavniho pole, jestli je prazdne, a obsah pole se vsemi atributy Vehicle objektu
    System.out.println("\nDebug center:\n1} Length: '" + orders.length + "'\n2} List Elements: ");

    if (isEmpty() == true) {
      System.out.println("List is empty"); 
    }

    System.out.println();
    
    for (int i = 0; i < orders.length; i++) {
      System.out.println("Name: '" + orders[i].name + "'; Day: '" + orders[i].day + "'; Done: '" + orders[i].done + "' Sign of vehicle: '" + orders[i].vehicle.sign + "';");
    }

    System.out.println();
  }
}