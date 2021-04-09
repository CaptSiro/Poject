package Zakazky;
import Garage.Garage;

public interface ListInf<E> {
  String add(String name, int day, String sign, Garage garageNow);
  boolean remove(String name);
  String done(String name);
  String stringify();
  void sort();
  boolean isEmpty();
  void debug();
}