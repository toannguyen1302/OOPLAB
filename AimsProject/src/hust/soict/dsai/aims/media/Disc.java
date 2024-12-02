package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	private int length;
	public int getLength() {
		return length;
	}


	private String director;	
	public String getDirector() {
		return director;
	}


	public Disc(String title, String category, String director, float cost, int length) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title, String category,String directory, int length) {
		super(title, category);
		this.length = length;
		this.director = directory;
	}


	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String category, String director) {
		super(title, category);
		this.director = director;
	}


	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
}
