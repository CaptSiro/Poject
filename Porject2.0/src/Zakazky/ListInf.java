package Zakazky;
import Garage.Garage;

public interface ListInf<E> {
  void add(String name, int day, String sign, Garage garageNow);
  void remove(String name);
  void done(String name);
  void sort();
  boolean isEmpty();
  void debug();
}