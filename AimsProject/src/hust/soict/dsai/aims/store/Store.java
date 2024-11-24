package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int itemCount;

    public Store() {
        this.itemsInStore = new DigitalVideoDisc[100]; // Assume max capacity is 100 DVDs
        this.itemCount = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("Cannot add null DVD to the store.");
            return;
        }

        if (itemCount < itemsInStore.length) {
            itemsInStore[itemCount] = dvd;
            itemCount++;
            System.out.println(dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("Cannot remove null DVD from the store.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i].equals(dvd)) {
                for (int j = i; j < itemCount - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[itemCount - 1] = null;
                itemCount--;
                System.out.println(dvd.getTitle() + " has been removed from the store.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(dvd.getTitle() + " is not found in the store.");
        }
    }

    public void displayStore() {
        System.out.println("Items currently in the store:");
        if (itemCount == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 1; i <= itemCount; i++) {
                System.out.println(i + ". "+ itemsInStore[i-1].toString());
            }
        }
    }
}
