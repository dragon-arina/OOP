public class Run {
    public static void main(String[] args) {
        Item[] itemsArray = new Item[] {new Dish(14.3, "Fish"), new Drink(25.1, "Pibimpab"), new Dish(2.1, "Cheasecake"), new Drink(19.2, "Vodka")};
        InternetOrder order = new InternetOrder(itemsArray);
        order.show();
        order.add(new Drink(66.2, "Devil Mix"));
        order.show();

        System.out.println(order.size());

        Item [] itemsOrder = order.getItemsArray();
        for (int i = 0; i < order.size(); i++)
            System.out.print(itemsOrder[i] + " ");
        System.out.println(order.costTotal());
    }
}
