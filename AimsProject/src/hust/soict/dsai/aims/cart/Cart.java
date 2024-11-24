package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        if (itemsOrdered.size() <20) {
            itemsOrdered.add(disc);
            System.out.println("The disc has been added");
        }
        else if (itemsOrdered.size() == 20){
            System.out.println("The cart is full");
        }
    }
    
    
// OVERLOADING (ADD dvdList to Cart)
    
//    public void addDigitalVideoDisc (DigitalVideoDisc[] dvdList){
//    	int i = 0;
//        for (DigitalVideoDisc D : dvdList) {
//        	itemsOrdered.add(D);
//        	System.out.println("The disc has been added");
//        	if (itemsOrdered.size() == 20){
//                System.out.println("The cart is full");
//                break;
//        	}
//        }
//        if (itemsOrdered.size() == 20){
//            System.out.println("The cart is full");
//        }
//    }
    
    
//  OVERLOADING (ADD an arbitrary numbers of dvds to Cart)
    public void addDigitalVideoDisc (DigitalVideoDisc... dvdList){
    	int i = 0;
        for (DigitalVideoDisc D : dvdList) {
        	itemsOrdered.add(D);
        	System.out.println("The disc has been added");
        	if (itemsOrdered.size() == 20){
                System.out.println("The cart is full");
                break;
        	}
        }
        if (itemsOrdered.size() == 20){
            System.out.println("The cart is full");
        }
    }
    
    public void addDigitalVideoDisc (DigitalVideoDisc d1, DigitalVideoDisc d2){
        if (itemsOrdered.size() + 2 <= 20) {
        	itemsOrdered.add(d1);
            System.out.println("The disc has been added");
            itemsOrdered.add(d2);
            System.out.println("The disc has been added");
        }
        else if (itemsOrdered.size() == 19) {
        	itemsOrdered.add(d1);
        	System.out.println("The disc has been added");
        }
        if (itemsOrdered.size() == 20){
            System.out.println("The cart is full");
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
    public String totalCost(){
        float sum = 0f;
        for (DigitalVideoDisc d : itemsOrdered){
            sum += d.getCost();
        }
        String formattedCost = String.format("%.2f", sum);
        return formattedCost;
    }
    public ArrayList<String> getItemsOrdered (){
        ArrayList<String> cart = new ArrayList<>();
        for (DigitalVideoDisc d : itemsOrdered){
            String title = d.getTitle();
            String category = d.getCategory();
            String directory = d.getDirectory();
            int length = d.getLength();
            float cost = d.getCost();
            String display = "TITLE: " + title + "  CATEGORY: " + category + "  DIRECTORY: " + directory + "  LENGTH: " + length +"  COST: " + cost;
            cart.add(display);
        }
        return cart;
    }
    
    
    public void printCart() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	int count = 1;
    	for (DigitalVideoDisc item : itemsOrdered) {
    		System.out.print(count + ". ");
    		System.out.println(item.toString());
    		count ++;
    	}
    	System.out.print("Total cost: ");
    	System.out.println(this.totalCost());
    }
    public void searchByID (int id) {
    	for (DigitalVideoDisc item : itemsOrdered) {
    		if (item.getId() == id) {
    			System.out.println(item.toString());
    			return;
    		}
    	}
    	System.out.println("No item found");
    }
    public void searchByTitle(String title) {
    	for (DigitalVideoDisc item : itemsOrdered) {
    		if (item.getTitle() == title) {
    			System.out.println(item.toString());
    			return;
    		}
    	}
    	System.out.println("No item found");
    }
}
