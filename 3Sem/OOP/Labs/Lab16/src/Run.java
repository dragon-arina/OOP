public class Run {
    public static void main(String[] args) {
        Item[] itemsArray = new Item[] {new Dish(14.3, "Fish"), new Drink(25.1, "Hot_Spring"), new Dish(2.1, "Popcorn"), new Drink(19.2, "Hot_Spring")};
        InternetOrder order = new InternetOrder(itemsArray);
        order.show();
        order.add(new Drink(66.2, "Devil_Spice"));
        order.show();
        //order.removeAll("Hot_Spring");
        System.out.println(order.size());
        //order.show();
        Item [] itemsOrder = order.getItemsArray();
        for (int i = 0; i < order.size(); i++)
            System.out.print(itemsOrder[i] + " ");
        System.out.println(order.costTotal());
    }
}
