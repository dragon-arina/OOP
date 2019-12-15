package v5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        System.out.println("ArayList: add" );
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(1, 2, 3));
        long start = System.nanoTime();
        arrayList.add(5);
        long finish = System.nanoTime();
        long timeNanoTime = finish - start;
        System.out.println(timeNanoTime);


        System.out.println("LinkedList:add");
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(Arrays.asList(2,3,4));
        long startAdd = System.nanoTime();
        linkedList.add(5);
        long finishAdd = System.nanoTime();
        long timeConsumedMillis1 = finishAdd - startAdd;
        System.out.println(timeConsumedMillis1);



        System.out.println("ArayList: remove" );
        long startRemove = System.nanoTime();
        arrayList.remove(1);
        long finishRemove = System.nanoTime();
        long timeNanoTimeRemove = finishRemove - startRemove;
        System.out.println(timeNanoTimeRemove);


        System.out.println("LinkedList:remove");
        long startRemoveLink = System.nanoTime();
        arrayList.remove(1);
        long finishRemoveLink= System.nanoTime();
        long timeNanoTimeRemoveLink = finishRemoveLink - startRemoveLink;
        System.out.println(timeNanoTimeRemoveLink);



        System.out.println("ArayList: contains" );
        long startContains = System.nanoTime();
        arrayList.contains(5);
        long finishContains = System.nanoTime();
        long timeNanoTimeContains = finishContains - startContains;
        System.out.println(timeNanoTimeContains);

        System.out.println("LinkedList:contains");
        long startContainsLink = System.nanoTime();
        arrayList.contains(5);
        long finishContainsLink= System.nanoTime();
        long timeNanoTimeContLink = finishContainsLink - startContainsLink;
        System.out.println(timeNanoTimeContLink);
    }
}








