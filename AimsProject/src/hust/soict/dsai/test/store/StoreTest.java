package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Create some DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Test adding DVDs
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Display items in store
        store.displayStore();

        // Test removing a DVD
        store.removeMedia(dvd2);

        // Display items in store after removal
        store.displayStore();

        // Try removing a non-existing DVD
        store.removeMedia(dvd2);
    }
}

