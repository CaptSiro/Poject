import Garage.Garage;
import Zakazky.List;

public class App {
    public static void main(String[] args) throws Exception {
        Garage garage = new Garage();
        List list = new List();

        garage.add("pog", "van");
        garage.add("nice", "truck");
        garage.add("cool", "truck");
        garage.add("works?", "truck");

        garage.debug();

        list.add("Kyoto Animation", 123, "nice", garage);
        list.add("New tools for MAPPA", 62, "works?", garage);
        list.add("I dunno", 1, "nice", garage);
        list.add("Dont kill me", 456, "cool", garage);
        list.add("Mr. program", 8, "nice", garage);

        list.done("New tools for MAPPA");
        list.done("I dunno");

        list.sort();

        list.debug();

        // list.sort();

        // System.out.println("\nAfter sort();\n");

        // list.debug();
    }
}
