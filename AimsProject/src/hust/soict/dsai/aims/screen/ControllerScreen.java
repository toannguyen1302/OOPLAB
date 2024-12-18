package hust.soict.dsai.aims.screen;

//import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class ControllerScreen {
	private static JFrame currentScreen;
	
	public static JFrame storeScreen;
	public static JFrame cartScreen;
	public static JFrame addDVDScreen;
	public static JFrame addBookScreen;
	public static JFrame addCDScreen;
	private Cart cart;
	private Store store;
	
	public ControllerScreen() {
		cart= new Cart();
		store=new Store();
		
		addDVDScreen= new AddDigitalVideoDiscToStoreScreen(store, cart, this);
		addDVDScreen.setTitle("Add DVD");
		
		addBookScreen= new AddBookToStoreScreen(store, cart, this);
		addBookScreen.setTitle("Add Book");
		
		addCDScreen= new AddCompactDiscToStoreScreen(store, cart, this);
		addCDScreen.setTitle("Add CD");
		
		storeScreen= new StoreScreen(store, cart, this);	
		storeScreen.setTitle("Store");
		
		cartScreen= new CartScreen(cart, this);
		cartScreen.setTitle("Cart");
		
		showStoreScreen();
	}
	public static void main(String args[]) {
		new ControllerScreen();
	}
    
    public void showScreen(JFrame screen) {
        if (currentScreen != null) {
            currentScreen.setVisible(false);
        }
        currentScreen = screen;
        currentScreen.setVisible(true);
    }
	
	public void updateAddItem() {
	}
	public void showStoreScreen() {
		
		SwingUtilities.updateComponentTreeUI(storeScreen);
		storeScreen.dispose();
		storeScreen= new StoreScreen(store,cart,this);
		showScreen(storeScreen);

		
	}
	public void showCartScreen() {
		showScreen(cartScreen);

	}
	public void showAddDVDScreen() {
		showScreen(addDVDScreen);

	}
	public void showAddCDCreen() {
		showScreen(addCDScreen);

	}
	public void showAddBookScreen() {
		showScreen(addBookScreen);

	}
}