package hust.soict.dsai.aims.disc;


public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private static int id_counter = 0;
	private int id;
    private String title;
    private String category;
    private String directory;
    private int length;
    private float cost;
    
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public String getDirectory() {
        return directory;
    }
    public int getLength() {
        return length;
    }
    public String getTitle() {
        return title;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        
        nbDigitalVideoDiscs++;
        id_counter ++;
        this.id = id_counter;
    }
    public DigitalVideoDisc(String title, String category, String directory) {
        this.title = title;
        this.category = category;
        this.directory = directory;
        
        nbDigitalVideoDiscs++;
        id_counter ++;
        this.id = id_counter;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        
        nbDigitalVideoDiscs++;
        id_counter ++;
        this.id = id_counter;
    }
    public DigitalVideoDisc(String title, String category, String directory, int length) {
        this.title = title;
        this.category = category;
        this.directory = directory;
        this.length = length;
        
        nbDigitalVideoDiscs++;
        id_counter ++;
        this.id = id_counter;
    }
    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        this.title = title;
        this.category = category;
        this.directory = directory;
        this.length = length;
        this.cost = cost;
        
        nbDigitalVideoDiscs++;
        id_counter ++;
        this.id = id_counter;
    }
	public void setTitle(String title2) {
		// TODO Auto-generated method stub
		this.title = title2;
	}
    public void setCategory (String category) {
    	this.category = category;
    }
    public void setCost (float cost) {
    	this.cost = cost;
    }
    public void setDirectory(String directory) {
    	this.directory = directory;
    }
    public void setLength(int length) {
    	this.length = length;
    }
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return title + " - " + category + " - " + directory + " - " + length + ": " + cost + "$";
    }

 }  