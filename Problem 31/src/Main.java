public class Main {
    public static void main(String[] args) {
        VIPRestaurantManager manager = new VIPRestaurantManager();

        manager.arrive("A");
        manager.arrive("B");
        manager.showLine();

        manager.arriveVIP("V1");
        manager.showLine();

        manager.leave("A");
        manager.showLine();

        manager.seat();
        manager.showLine();
    }
}
