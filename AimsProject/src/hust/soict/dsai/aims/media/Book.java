package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor (String authorName) {
		for (String name : authors) {
			if (name.equals(authorName)){
				System.out.println("Error: Author has been added");
			}
			return;
		}
		authors.add(authorName);
		System.out.println("Author added successfully");
	}
	
	public void removeAuthor(String authorName) {
		int i = 0;
		for (String author : authors) {
			if (author.equals(authorName)) {
				authors.remove(i);
				System.out.println("Author removed successfully");
				return;
			}
			i+=1;
		}
		System.out.println("No author exists");
	}
	
	public String getAuthors() {
		String str = "";
		int i = 0;
		for (String a : authors) {
			if (i == 0) {
				str += a;
				continue;
			}
			str += " ";
			str += "a";
			i++;
		}
		return str;
	}
	
	@Override
    public String toString() {
        return getTitle() + " - " + getCategory() + " - " + getAuthors() +  ": " + getCost() + "$";
    }

	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

