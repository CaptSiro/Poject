package Garage;

import java.util.Arrays;

public class Garage implements GarageInf {
  public class Vehicle {
    public String sign;
    public String type;

    Vehicle(String sign, String type) {
      this.sign = sign;
      this.type = type;
    }
  }

  public Vehicle[] garageInv = new Vehicle[0];

  @Override
  public void add(String sign, String type) {
    boolean only = false;

    for (int i = 0; i < garageInv.length; i++) {
      if (garageInv[i].sign.equals(sign)) {
        only = true;
      }
    }

    if (only == false) {
      int newLen = garageInv.length + 1;
      Vehicle[] newGarageInv = Arrays.copyOf(garageInv, newLen);
      newGarageInv[garageInv.length] = new Vehicle(sign, type);

      garageInv = Arrays.copyOf(newGarageInv, newLen);
    } else {
      System.out.println("Vehicle with sign: '" + sign + "' has already assigned!");
    }
  }

  @Override
  public void remove(String sign) {
    if (isEmpty() == false) {
      boolean exists = false;
      Vehicle[] newGarInv = new Vehicle[garageInv.length - 1];
  
      int j = 0;
  
      for (int i = 0; i < garageInv.length; i++) {
        if (!garageInv[i].sign.equals(sign)) {
          if (!(exists == false && i == garageInv.length - 1)) {
            newGarInv[j] = garageInv[i];
            j++;
          } else {
            System.out.println("Order not found!");
          }
        } else {
          exists = true;
        }
      }
  
      if (exists == true) {
        garageInv = Arrays.copyOf(newGarInv, garageInv.length - 1);
      }
    }
  }

  @Override
  public Vehicle find(String sign) {
    if (isEmpty() == false) {
      Vehicle el = null;

      for (int i = 0; i < garageInv.length; i++) {
        if (garageInv[i].sign.equals(sign)) {
          el = garageInv[i];
        }
      }
      
      return el;
    } else {
      return null;
    }
  }

  @Override
  public boolean isEmpty() {
    if (garageInv.length == 0) {
      return true;
    }
    return false;
  }

  @Override
  public void debug() {
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