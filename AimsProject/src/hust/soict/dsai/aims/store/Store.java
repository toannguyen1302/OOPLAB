package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;
    private int itemCount;

    public Store() {
        this.itemsInStore = new ArrayList<Media>(); // Assume max capacity is 100 DVDs
        this.itemCount = 0;
    }

    public void addMedia(Media m) {
        if (m == null) {
            System.out.println("Cannot add null DVD to the store.");
            return;
        }

        if (itemCount < 99) {
            itemsInStore.add(m);
            itemCount++;
            System.out.println(m.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeMedia(Media m) {
        if (m == null) {
            System.out.println("Cannot remove null DVD from the store.");
            return;
        }

        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(m.getTitle())) {
                itemsInStore.remove(itemsInStore.indexOf(m));
                itemCount--;
                System.out.println(m.getTitle() + " has been removed from the store.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(m.getTitle() + " is not found in the store.");
        }
    }

    public void displayStore() {
        System.out.println("Items currently in the store:");
        if (itemCount == 0) {
            System.out.println("The store is empty.");
        } else {
        	int i = 1;
            for (Media m : itemsInStore) {
                System.out.println(i + ". "+ m.toString());
                i++;
            }
        }
    }
    
    public Media searchByTitle(String title) {
    	for (Media item : itemsInStore) {
    		if (item.getTitle() == title) {
    			System.out.println(item.toString());
    			return item;
    		}
    	}
    	System.out.println("No item found");
    	return null;
    }

}
