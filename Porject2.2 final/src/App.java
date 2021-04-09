import Garage.Garage;
import Zakazky.List;

public class App {
    public static void main(String[] args) throws Exception {
        Garage garage = new Garage();
        List list = new List();

        garage.add("testCar", "Car");
        garage.add("testTwo", "Car");
        garage.add("suki", "Van");

        list.add("a", 1, "suki", garage);
        list.add("d", 4, "suki", garage);
        list.add("c", 3, "suki", garage);
        list.add("e", 5, "suki", garage);
        list.add("b", 2, "suki", garage);

        list.done("c");
        list.done("a");

        list.sort();

        new MainFrame(garage, list);
    }
}