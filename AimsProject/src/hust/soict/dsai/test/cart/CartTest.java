package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd7);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("Hell","Pop", "Taylor", 20.99f, "Toan");
        cart.addMedia(cd1);
        System.out.println(cd1.getCost());
        
        Book book1 = new Book("God", "Ton", 30.99f);
        book1.addAuthor("caa");
        cart.addMedia(book1);
        
        // Test the print method
        cart.printCart();

        // To-do: Test the search methods here
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Star Warssf");
        cart.searchByID(1);
        cart.searchByID(5);
        cart.sortByCostThenTitle();
        cart.printCart();
        cart.sortByTitleThenCost();
        cart.printCart();
    }
    
}

