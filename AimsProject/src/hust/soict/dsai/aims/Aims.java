package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void main(String[] args) { 
    	Scanner scanner = new Scanner(System.in);
    	Store store = new Store();
        Cart anOrder = new Cart();
        
        showMenu(store, anOrder, scanner);
        scanner.close();
        
    }
    
    public static void showMenu(Store store, Cart cart, Scanner scanner) {
        System.out.println("AIMS: ");
        System.out.println("------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        switch(choice) {
            case 0:
                return;
            case 1:
                store.displayStore();
                storeMenu(store, cart, scanner);
                showMenu(store, cart, scanner);
                break;
            case 2:
                System.out.print("Enter action: add or remove: ");
                String action = scanner.nextLine();
                if (action.equals("add")) {
                    while (true) {
                        System.out.print("Add media? (1 for yes, 0 for no): ");
                        int ans = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        if (ans == 1) {
                            System.out.print("Enter type of media (CD, DVD, Book): ");
                            String type = scanner.nextLine();
                            if (type.equals("CD") || type.equals("DVD") || type.equals("Book") == false) {
                            	System.out.println("WRONG INPUT");
                            	System.out.println("Press any key to return menu");
                            	String c = scanner.nextLine();
                            	if (c != null) {
                            		break;
                            	}
                            }
                            System.out.print("Enter title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter category: ");
                            String category = scanner.nextLine();
                            System.out.print("Enter cost: ");
                            float cost = scanner.nextFloat();
                            scanner.nextLine(); // Consume newline character

                            if (type.equals("CD")) {
                                System.out.print("Enter director: ");
                                String director = scanner.nextLine();
                                System.out.print("Enter artist: ");
                                String artist = scanner.nextLine();
                                CompactDisc cd1 = new CompactDisc(title, category, director, cost, artist);
                                while (true) {
                                    System.out.print("Add track? (1 for yes, 0 for no): ");
                                    int b = scanner.nextInt();
                                    scanner.nextLine();
                                    if (b == 1) {
                                        System.out.print("Enter track's title: ");
                                        String track_title = scanner.nextLine();
                                        System.out.print("Enter track's length: ");
                                        int track_length = scanner.nextInt();
                                        scanner.nextLine();
                                        Track tr = new Track(track_title, track_length);
                                        cd1.addTrack(tr);
                                    }
                                    else if (b == 0) {
                                        break;
                                    }
                                }
                                store.addMedia(cd1);
                            } 
                            else if (type.equals("DVD")) {
                                System.out.print("Enter DVD's director: ");
                                String director1 = scanner.nextLine();
                                System.out.print("Enter DVD's length: ");
                                int dvdLength = scanner.nextInt();
                                scanner.nextLine();
                                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director1, dvdLength, cost);
                                store.addMedia(dvd);
                            } 
                            else if (type.equals("Book")) {
                                System.out.print("Enter author: ");
                                String author = scanner.nextLine();
                                Book book = new Book(title, category, cost);
                                book.addAuthor(author);
                                store.addMedia(book);
                            }
                        } 
                        else if (ans == 0) {
                            break; 
                        }
                    }
                } else if (action.equals("remove")) {
                    while (true) {
        				System.out.println("Remove media? (1 for yes, 0 for no)");
        				int a = scanner.nextInt();
        				scanner.nextLine();
        				if (a == 0) {
        					break;
        				}
        				if (a == 1) {
        					System.out.println("Enter title:");
        					String t = scanner.nextLine();
        					Media m = store.searchByTitle(t);
        					if (m != null) {
        						store.removeMedia(m);
        						System.out.println("Remove media successfully");
        					}
        				}
                    }
                }
                showMenu(store, cart, scanner); 
                break;
    	case 3:
    		cart.printCart();
    		cartMenu(store, cart, scanner);
            showMenu(store, cart, scanner); 
    		break;
    	default:
            System.out.println("Invalid choice. Please try again.");
            showMenu(store, cart, scanner);
        }
    	
    }
    
    public static void storeMenu(Store store, Cart cart, Scanner scanner) {
    	System.out.println("Options: ");
    	System.out.println("------------------");
    	System.out.println("1. See a media's details");
    	System.out.println("2. Add a media to cart");
    	System.out.println("3. Play a media");
    	System.out.println("4. See current cart");
    	System.out.println("0. Back");
    	System.out.println("------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4");
    	
    	switch(scanner.nextInt()) {
    	case 0:
    		return;
    	case 1:
    		System.out.println("Enter media's title: ");
    		String title = scanner.nextLine();
    		Media m = store.searchByTitle(title);
    		if (m != null) {
    			displayMediaDetailsMenu(m, cart, scanner);
    		}
    		
    		storeMenu(store, cart, scanner);
    		break;
    	case 2:
    		System.out.println("Enter media's title: ");
    		String title1 = scanner.nextLine();
    		Media m2 = store.searchByTitle(title1);
    		if (m2 != null) {
    			cart.addMedia(store.searchByTitle(title1));
    			if (m2 instanceof DigitalVideoDisc) {
    				((DigitalVideoDisc) m2).getNBDVD();
    			}
    		}
    		System.out.println();
    		System.out.println("Return to Store menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			scanner.nextLine();
    			storeMenu(store, cart, scanner);
    		}
    		break;
    	case 3:
    		System.out.println("Enter media's title: ");
    		String title2 = scanner.nextLine();
    		Media m1 = store.searchByTitle(title2);
    		if (m1 instanceof DigitalVideoDisc) {
    			((DigitalVideoDisc) m1).play();
    			
        		System.out.println();
    			System.out.println("Return to Store menu (Enter 0)");
        		if (scanner.nextInt() == 0) {
        			scanner.nextLine();
        			storeMenu(store, cart, scanner);
        		}
    		}
    		else if (m1 instanceof CompactDisc) {
    			((CompactDisc) m1).play();
    			
        		System.out.println();
    			System.out.println("Return to Store menu (Enter 0)");
        		if (scanner.nextInt() == 0) {
        			scanner.nextLine();
        			storeMenu(store, cart, scanner);
        		}
    		}
    		else {
    			if (m1 == null) {
    				System.out.println("No media exists");
    			}
    			else{
    				System.out.println("Can't play media");
    			}
    			
        		System.out.println();
    			System.out.println("Return to Store menu (Enter 0)");
        		if (scanner.nextInt() == 0) {
        			scanner.nextLine();
        			storeMenu(store, cart, scanner);
        		}
    		}
    		break;
    	case 4:
    		cart.printCart();
    		cartMenu(store, cart, scanner);
    		storeMenu(store, cart, scanner);
    		break;
    	default:
            System.out.println("Invalid choice. Please try again.");
            storeMenu(store, cart, scanner);
        
    	}
    		
    }
    
    public static void displayMediaDetailsMenu(Media m, Cart cart, Scanner scanner) {
    	System.out.println("Options: ");
    	System.out.println("------------------");
    	System.out.println("1. Add to cart");
    	System.out.println("2. Play");
    	System.out.println("0. Back");
    	System.out.println("------------------");
    	System.out.println("Please choose a number: 0-1-2");
    	
    	switch(scanner.nextInt()) {
    	case 0:
    		scanner.nextLine();
    		return;
    	case 1:
    		scanner.nextLine();
    		if (m != null) {
    			cart.addMedia(m);
    			if (m instanceof DigitalVideoDisc) {
    				((DigitalVideoDisc) m).getNBDVD();
    			}
    		}
    		
    		System.out.println();
			System.out.println("Return to Media menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			displayMediaDetailsMenu(m, cart, scanner);
    		}
    		break;
    	case 2:
    		scanner.nextLine();
    		if (m instanceof DigitalVideoDisc) {
    			((DigitalVideoDisc) m).play();
    		}
    		else if (m instanceof CompactDisc) {
    			((CompactDisc) m).play();
    		}
    		else {
    			if (m == null) {
    				System.out.println("No media exists");
    			}
    			else{
    				System.out.println("Can't play media");
    			}
    		}
    		
    		System.out.println();
			System.out.println("Return to Media menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			scanner.nextLine();
    			displayMediaDetailsMenu(m, cart, scanner);
    		}
    		break;
    	default:
            System.out.println("Invalid choice. Please try again.");
			displayMediaDetailsMenu(m, cart, scanner);
    	}
    }
    
    public static void cartMenu(Store store, Cart cart, Scanner scanner) {
    	System.out.println("Options: ");
    	System.out.println("------------------");
    	System.out.println("1. Filter medias in cart");
    	System.out.println("2. Sort medias in cart");
    	System.out.println("3. Remove media from cart");
    	System.out.println("4. Play a media");
    	System.out.println("5. Place order");
    	System.out.println("0. Back");
    	System.out.println("------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4-5");
    	
    	switch(scanner.nextInt()) {
    	case 0:
    		scanner.nextLine();
    		return;
    	case 1:
    		scanner.nextLine();
    		System.out.println("Choose filtering option (title or ID): ");
    		String filter = scanner.nextLine();
    		scanner.nextLine();
    		if (filter.equals("title")) {
    			System.out.println("Enter the title of the media: ");
    			cart.searchByTitle(scanner.nextLine());
    		}
    		else if (filter.equals("ID")) {
    			System.out.println("Enter the ID of the media: ");
    			cart.searchByID(scanner.nextInt());
    			scanner.nextLine();
    		}
    		
    		System.out.println();
			System.out.println("Return to Cart menu (Enter 0)");
			int back = scanner.nextInt();
			scanner.nextLine();
    		if (back == 0) {
    			cartMenu(store, cart, scanner);
    		}
    		break;
    	case 2:
    		scanner.nextLine();
    		System.out.println("Choose sorting option (cost or title): ");
    		if (scanner.nextLine().equals("cost")) {
    			cart.sortByCostThenTitle();
    			cart.printCart();
    		}
    		else if (scanner.nextLine().equals("title")) {
    			cart.sortByTitleThenCost();
    			cart.printCart();
    		}
    		
    		System.out.println();
			System.out.println("Return to Cart menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			scanner.nextLine();
    			cartMenu(store, cart, scanner);
    		}
    		break;
    	case 3:
    		scanner.nextLine();
    		System.out.println("Enter title of media: ");
    		Media m = cart.searchByTitle(scanner.nextLine());
    		if (m != null) {
    			cart.removeMedia(m);
        		System.out.println("Remove media successfully");
    		}
    		else {
    			System.out.println("No media exists");
    		}
    		
    		System.out.println();
			System.out.println("Return to Cart menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			scanner.nextLine();
    			cartMenu(store, cart, scanner);
    		}
    		break;
    	case 4:
    		scanner.nextLine();
    		System.out.println("Enter media's title: ");
    		String title2 = scanner.nextLine();
    		Media m1 = store.searchByTitle(title2);
    		if (m1 instanceof DigitalVideoDisc) {
    			((DigitalVideoDisc) m1).play();
    		}
    		else if (m1 instanceof CompactDisc) {
    			((CompactDisc) m1).play();
    		}
    		else {
    			if (m1 == null) {
    				System.out.println("No media exists");
    			}
    			else{
    				System.out.println("Can't play media");
    			}
    		}
    		
    		System.out.println();
			System.out.println("Return to Cart menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			scanner.nextLine();
    			cartMenu(store, cart, scanner);
    		}
    		break;
    	case 5:
    		scanner.nextLine();
    		System.out.println("Place order successfully!");
    		cart.clearCart();
    		
    		System.out.println();
			System.out.println("Return to Cart menu (Enter 0)");
    		if (scanner.nextInt() == 0) {
    			scanner.nextLine();
    			cartMenu(store, cart, scanner);
    		}
    		break;
    	default:
            System.out.println("Invalid choice. Please try again.");
			cartMenu(store, cart, scanner);

    	}
    }
}
