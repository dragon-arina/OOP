import java.util.HashMap;

public class OrderManager {
    //private CycleDoubleLinkedList<Order> orders;
    private HashMap<Integer, Order> restaurantMap = new HashMap<>();
    private HashMap<String, Order> internetMap = new HashMap<>();
    public void add(int tableNumber, Order order) {
        checkOrderIsNew(tableNumber);
        restaurantMap.put(tableNumber, order);
    }
    public void add(String address, Order order) {
        checkOrderIsNew(address);
        internetMap.put(address, order);
    }
    public Order getOrder(int tableNumber) {
        checkOrderExist(tableNumber);
        return restaurantMap.get(tableNumber);
    }
    public Order getOrder(String address) {
        checkOrderExist(address);
        return internetMap.get(address);
    }
    public void addItem(int tableNumber, Item item) {
        checkOrderExist(tableNumber);
        restaurantMap.get(tableNumber).add(item);
    }
    public void addItem(String address, Item item) {
        checkOrderExist(address);
        internetMap.get(address).add(item);
    }
    public void removeOrder(int tableNumber) {
        checkOrderExist(tableNumber);
        restaurantMap.remove(tableNumber);
    }
    public void removeOrder(String address) {
        checkOrderExist(address);
        internetMap.remove(address);
    }
    /*public int freeTableNumber() {

    }
    public int [] freeTableNumbers() {

    }*/
    public Order [] getOrders() {
        return internetMap.values().toArray(new Order[internetMap.values().size()]);
    }
    public double ordersCostSummary() {
        double summaryCost = 0;
        Order [] orders = getOrders();
        for (int i = 0; i < orders.length; i++)
            summaryCost = summaryCost + orders[i].costTotal();
        return summaryCost;
    }
    public int itemQuantity(String itemName) {
        int itemQuantity = 0;
        Order [] orders = getOrders();
        for (int i = 0; i < orders.length; i++)
            itemQuantity = itemQuantity + orders[i].itemQuantity(itemName);
        return itemQuantity;
    }
    private void checkOrderExist(int tableNumber) {
        try {
            if (!restaurantMap.containsKey(tableNumber))
                throw new IllegalTableNumber("Заказа для этого столика не существует");
        } catch (IllegalTableNumber e) {
            System.out.println(e.getMessage());
        }
    }
    private void checkOrderExist(String address) {
        try {
            if (!internetMap.containsKey(address))
                throw new IllegalTableNumber("Заказа по этому адресу не существует");
        } catch (IllegalTableNumber e) {
            System.out.println(e.getMessage());
        }
    }
    private void checkOrderIsNew(int tableNumber) {
        try {
            if (restaurantMap.containsKey(tableNumber)) {
                throw new OrderAlreadyAddedException("Заказ для этого столика уже существует");
            }
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
    }
    private void checkOrderIsNew(String address) {
        try {
            if (internetMap.containsKey(address)) {
                throw new OrderAlreadyAddedException("Заказ по этому адресу уже существует");
            }
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
    }
}
