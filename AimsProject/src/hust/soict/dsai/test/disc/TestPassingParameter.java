package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter { 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
//    public static void swap (DigitalVideoDisc o1, DigitalVideoDisc o2) {
//    	int len = o1.getLength();
//    	String title = o1.getTitle();
//    	String direc = o1.getDirectory();
//    	float cost = o1.getCost();
//    	String cate = o1.getCategory();
//    	
//    	o1.setCategory(o2.getCategory());
//    	o1.setCost(o2.getCost());
//    	o1.setDirectory(o2.getDirectory());
//    	o1.setLength(o2.getLength());
//    	o1.setTitle(o2.getTitle());
//    	
//    	o2.setCategory(cate);
//    	o2.setCost(cost);
//    	o2.setDirectory(direc);
//    	o2.setTitle(title);
//    	o2.setLength(len);
//    }



