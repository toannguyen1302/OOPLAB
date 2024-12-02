package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	protected static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
    	super(title);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String directory) {
        super(title, category, directory);        
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String directory, int length) {
        super(title, category, directory, length);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        super(title, category, directory, cost, length);        
        nbDigitalVideoDiscs++;
    }
    
    
    @Override
    public String toString() {
        return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + "$";
    }
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
	
	public void getNBDVD() {
		System.out.println(nbDigitalVideoDiscs);
	}
 }  