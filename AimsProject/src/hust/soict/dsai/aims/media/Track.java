package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
	@Override
	public boolean equals(Object o) {
    	if(((Track) o).getTitle().equals(((Track) this).getTitle()) && ((Track) this).getLength() == ((Track) o).getLength()) {
			System.out.println("The media " + ((Track) this).getTitle() + " has already exists");
    		return true;
    	}
    	return false;
    }
}
