package Garage;

public interface GarageInf<E> {
  boolean add(String sign, String type);
  void remove(String sign);
  E find(String sign);
  boolean isEmpty();
  void debug();
}