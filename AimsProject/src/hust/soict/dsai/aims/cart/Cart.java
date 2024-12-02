package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    
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
    
    
    
    public void addMedia (Media... items) {
    	for (Media m : items) {
    		for (Media i : itemsOrdered) {
    			if (m.equals(i) == true) {
    				System.out.println("The media " + m.getTitle() + " has already exists");
    				return;
    			}
    		}
			itemsOrdered.add(m);
        	System.out.println("The media " + m.getTitle() + " has been added");
        	if (itemsOrdered.size() == 20){
                System.out.println("The cart is full");
                break;
        	}
        }
        if (itemsOrdered.size() == 20){
            System.out.println("The cart is full");
        }
    }

    
    public void removeMedia (Media media){
        for (Media m : itemsOrdered){
            if (m.getTitle() == media.getTitle()){
                itemsOrdered.remove(itemsOrdered.indexOf(m));
            }
        }
        System.out.println("The disc has been removed");
    }
    public String totalCost(){
        float sum = 0f;
        for (Media m : itemsOrdered){
            sum += m.getCost();
        }
        String formattedCost = String.format("%.2f", sum);
        return formattedCost;
    }
    public ArrayList<String> getItemsOrdered (){
        ArrayList<String> cart = new ArrayList<>();
        for (Media d : itemsOrdered){
            String title = d.getTitle();
            String category = d.getCategory();
            float cost = d.getCost();
            String display = "TITLE: " + title + "  CATEGORY: " + category + "  COST: " + cost;
            cart.add(display);
        }
        return cart;
    }
    
    
    public void printCart() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	int count = 1;
    	for (Media item : itemsOrdered) {
    		System.out.print(count + ". ");
    		System.out.println(item.toString());
    		count ++;
    	}
    	System.out.print("Total cost: ");
    	System.out.println(this.totalCost());
    }
    public Media searchByID (int id) {
    	for (Media item : itemsOrdered) {
    		if (item.getID() == id) {
    			System.out.println(item.toString());
    			return item;
    		}
    	}
    	System.out.println("No item found");
    	return null;
    }
    public Media searchByTitle(String title) {
    	for (Media item : itemsOrdered) {
    		if (item.getTitle() == title) {
    			System.out.println(item.toString());
    			return item;
    		}
    	}
    	System.out.println("No item found");
    	return null;
    }
    
 // Sort by title, then cost (descending)
    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    // Sort by cost, then title (alphabetical)
    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public void clearCart() {
    	itemsOrdered.clear();
    }
}
