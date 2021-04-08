import Garage.Garage;
import Zakazky.List;

public class App {
    public static void main(String[] args) throws Exception {
        Garage garage = new Garage();
        List list = new List();

        garage.add("ok", "nice");
        garage.add("pog", "nice");
        garage.add("this is hell", "nice");

        new MainFrame(garage, list);
    }
}