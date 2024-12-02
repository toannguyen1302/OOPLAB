package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		for (Track tr : tracks) {
			if (tr.getTitle().equals(tr.getTitle())) {
				System.out.println("Track da ton tai");
				return;
			}
		}
		tracks.add(track);
		System.out.println("Them track thanh cong");
	}
	
	public void removeTrack(Track track) {
		for (Track tr : tracks) {
			if (tr.getTitle().equals(tr.getTitle())) {
				tracks.remove(tracks.indexOf(tr));
				System.out.println("Xoa track thanh cong");
				return;
			}
		}
		System.out.println("Track khong ton tai");
	}
	
	public int getLength() {
		int sum = 0;
		for (Track tr : tracks) {
			sum += tr.getLength();
		}
		return sum;
	}
	
	public String getArtist () {
		return artist;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD total length: " + this.getLength());
		for (Track tr : tracks) {
			tr.play();
		}
	}
	@Override
    public String toString() {
        return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - " + getArtist() +  ": " + getCost() + "$";
    }

}
