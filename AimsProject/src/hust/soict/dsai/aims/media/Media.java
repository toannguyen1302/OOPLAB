package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	
	private static int id_counter = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		id_counter++;
		this.id = id_counter;
	}
	
	public Media(String title) {
		this.title = title;
		id_counter++;
		this.id = id_counter;
	}
	
	public Media(String title, String category) {
		this.title = title;
		this.category = category;
		id_counter++;
		this.id = id_counter;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}

	public int getID() {
		return id; 
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
    public String toString() {
        return getTitle() + " - " + getCategory() + " - " + getCost() + "$";
    }
	
	@Override
	public boolean equals(Object o) {
    	if(((Media) o).getTitle().equals(((Media) this).getTitle()) == true) {
    		return true;
    	}
    	return false;
    }
	
//	@Override
//	public int compareTo (Media m) {
//		int titleComparison = this.title.compareTo(m.title);
//		if (titleComparison != 0) {
//			return titleComparison;
//		}
//		return Double.compare(m.cost, this.cost);
//	}
	
}
