package Zakazky;

import java.util.Arrays;
import Garage.Garage;
import Garage.Garage.Vehicle;

public class List implements ListInf {
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

  public Order[] orders = new Order[0];

  @Override
  public void add(String name, int day, String sign, Garage garageNow) {
    if (garageNow.isEmpty() == false) {
      boolean only = false;
  
      for (int i = 0; i < orders.length; i++) {
        if (orders[i].name.equals(name)) {
          only = true;
        }
      }
  
      if (only == false) {
        int newLen = orders.length + 1;
        Order[] newOrders = Arrays.copyOf(orders, newLen);

        Vehicle vehicle = garageNow.find(sign);

        if (vehicle != null) {
          newOrders[orders.length] = new Order(name, day, vehicle);
          orders = Arrays.copyOf(newOrders, newLen);
        }
      }
    }
  }

  @Override
  public void remove(String name) {
    if (isEmpty() == false) {
      boolean exists = false;
      Order[] newOrders = new Order[orders.length - 1];
  
      int j = 0;
  
      for (int i = 0; i < orders.length; i++) {
        if (!orders[i].name.equals(name)) {
          if (!(exists == false && i == orders.length - 1)) {
            newOrders[j] = orders[i];
            j++;
          } else {
            System.out.println("Order not found!");
          }
        } else {
          exists = true;
        }
      }
  
      if (exists == true) {
        orders = Arrays.copyOf(newOrders, orders.length - 1);
      }
    }
  }

  @Override
  public void done(String name) {
    if (isEmpty() == false) {
      Order el = null;
  
      for (int i = 0; i < orders.length; i++) {
        if (orders[i].name.equals(name)) {
          el = orders[i];
        }
      }
  
      if (el != null) {
        el.done();
      }
    }
  }

  @Override
  public void sort() {
    if (isEmpty() == false) {
      for (int i = 0; i < orders.length; i++) {
        int k = 1;

        for (int j = 0; j < orders.length - 1; j++) {
          Order a = orders[j];
          Order b = orders[k];
          byte result;

          if (a.day < b.day) {
            result = 1;
          } else if (a.day > b.day) {
            result = -1;
          } else {
            result = 0;
          }

          if (result < 0) {
            orders[j] = b;
            orders[k] = a;
          }

          k++;
        }
      }
    }
  }

  @Override
  public boolean isEmpty() {
    if (orders.length == 0) {
      return true;
    }
    return false;
  }

  @Override
  public void debug() {
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