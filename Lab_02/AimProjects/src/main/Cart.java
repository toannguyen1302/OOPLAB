package main;

import java.util.ArrayList;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        itemsOrdered.add(disc);
        System.out.println("The disc has been added");
        if (itemsOrdered.size() == 20){
            System.out.println("The cart is almost full");
        }
    }
    public void removeDigitalVideoDisc (DigitalVideoDisc disc){
        for (DigitalVideoDisc d : itemsOrdered){
            if (d.getTitle() == disc.getTitle()){
                itemsOrdered.remove(disc);
            }
        }
        System.out.println("The disc has been removed");
    }
    public float totalCost(){
        float sum = 0;
        for (DigitalVideoDisc d : itemsOrdered){
            sum += d.getCost();
        }
        return sum;
    }
}
