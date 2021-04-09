package Garage;

public interface GarageInf<E> {
  String add(String sign, String type);
  String[] stringify();
  void remove(String sign);
  E find(String sign);
  int findIndex(String sign);
  boolean isEmpty();
  void debug();
}