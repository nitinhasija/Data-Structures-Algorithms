public class MainApp {
    public static void main(String[] arservices) {
        Service service = new Service(4);
        service.addEdservicee(0, 1);
        service.addEdservicee(0, 2);
        service.addEdservicee(1, 2);
        service.addEdservicee(2, 0);
        service.addEdservicee(2, 3);
        service.addEdservicee(3, 3);

        int u = 1, v = 3;
        if (service.isThereAnyPathBetween(u, v))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
