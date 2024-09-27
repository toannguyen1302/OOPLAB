import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isBooked;

    public Room(int roomNumber, String roomType, double pricePerNight, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked; 
    }
    
    public void bookRoom() {
        if (isBooked) {
            System.out.println("Phong " + roomNumber +" da duoc dat truoc");
        } else {
            isBooked = true;
            System.out.println("Dat phong " + roomNumber +" thanh cong");
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Huy dat phong " + roomNumber +" thanh cong");
        }
        else {
            System.out.println("Phong chua co nguoi dat");
        }
    }
    
    public void displayInfo(){
        String formattedPrice = String.format("%,.2f", pricePerNight);
        System.out.println("---------THONG TIN PHONG "+ roomNumber + "--------");
        System.out.println("So phong: " + roomNumber);
        System.out.println("Loai phong: " + roomType);
        System.out.println("Gia mot dem: " + formattedPrice);
        if (isBooked){
            System.out.println("Trang thai: Phong da duoc dat ok");
        } else {
            System.out.println("Trang thai: Phong chua duoc dat" );
        }
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public String getRoomType(){
        return roomType;
    }
    
    public double getPricePerNight(){
        return pricePerNight;
    }
    public boolean getIsBooked(){
        return isBooked;
    }
}

class Guest{
    private String name;
    private String id;
    private String phoneNumber;

    public void inputInfo (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten khach: ");
        name = scanner.nextLine();
        System.out.print("Nhap so CCCD/CMND: ");
        id = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        phoneNumber = scanner.nextLine();
        System.out.println();
    }

    public void displayInfo(){
        System.out.println("---------THONG TIN KHACH HANG--------");
        System.out.println("Ten: " + name);
        System.out.println("So CCCD/CMND: " + id);
        System.out.println("So dien thoai: "+phoneNumber);
    }

    public String getName (){
        return name;
    }
    public String getID () {
        return id;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}

class Booking {
    private String bookingID;
    private Guest guest;
    private Room room;
    private int nights;

    public void totalPrice(){
        double total_price = nights * room.getPricePerNight();
        String formatted_price = String.format("%,.2f", total_price);
        System.out.println("So tien tong cong: "+ formatted_price);
    }

    public void displayBookingInfo(){
        System.out.println("--------THONG TIN DAT PHONG---------");
        System.out.println("ID: "+bookingID);
        System.out.println("Ten khach: " + guest.getName());
        System.out.println("So phong: "+ room.getRoomNumber());
        System.out.println("So ngay dat: "+nights);
        totalPrice();
    }

    public Booking(Guest guest, Room room, int nights){
        this.bookingID = generateBookingID();
        this.guest = guest;
        this.room = room;
        this.nights = nights;
    }

    private String generateBookingID() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return "BOOK" + formatter.format(date);
    }

    public String getID(){
        return bookingID;
    }
}

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public void addRoom (Room room) {
        rooms.add(room);
        System.out.println("Them phong " + room.getRoomNumber()+" thanh cong!");
    }

    public void removeRoom (int roomNumber){
        for (Room r : rooms){
            if (r.getRoomNumber() == roomNumber) {
                rooms.remove(r);
                System.out.println("Xoa phong thanh cong!");
                break;
            }
        }
    }

    public void findRoomByType (String roomType) {
        boolean found = false;
        System.out.print("Phong trong loai " + roomType + ": ");
        for (Room r : rooms) {
            if (r.getRoomType().equals(roomType)) {
                System.out.println(r.getRoomNumber());
                found = true;
                break;
            }
        }
        if (found == false){
            System.out.println("Khong co phong thoa man");
        }
        System.out.println();
    }

    public void bookRoom (Guest guest, String roomType, int nights){
        Room availableRoom = null;
        for (Room r : rooms) {
            if (r.getRoomType().equals(roomType) && r.getIsBooked() == false) {
               availableRoom = r;
               availableRoom.bookRoom();
               break;
            }
        }
        if (availableRoom != null) {
            Booking newBook = new Booking(guest, availableRoom, nights);
            bookings.add(newBook);
            System.out.println("DAT PHONG THANH CONG");
            newBook.displayBookingInfo();
        } else{
            System.out.println("Khong co phong " + roomType + " thoa man");
        }
    }

    public void displayAllBookings(){
        for (Booking b:bookings){
            b.displayBookingInfo();
            System.out.println("-------------");
        }
    }
}

public class exercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Add some rooms to the hotel
        hotel.addRoom(new Room(101, "Single", 100.0, false));
        hotel.addRoom(new Room(102, "Double", 150.0, false));
        hotel.addRoom(new Room(103, "Suite", 250.0, false));

        // Get guest information
        Guest guest = new Guest();
        guest.inputInfo();

        // Select room type and booking days
        System.out.print("Chon loai phong de dat (Single, Double, Suite): ");
        String roomType = scanner.nextLine();
        System.out.print("Nhap so ngay dat phong: ");
        int nights = scanner.nextInt();

        // Consume leftover newline character
        scanner.nextLine();  

        // Book the room
        hotel.bookRoom(guest, roomType, nights);

        // Display all rooms in the hotel
        System.out.println("Danh sach cac phong trong khach san:");
        for (Room room : hotel.rooms) {
            room.displayInfo();
            System.out.println("-------------");
        }

        // Cancel room booking
        System.out.print("Nhap so phong de huy dat: ");
        int roomNumberToCancel = scanner.nextInt();

        // Consume leftover newline character
        scanner.nextLine();  

        Room roomToCancel = null;
        for (Room r : hotel.rooms) {
            if (r.getRoomNumber() == roomNumberToCancel) {
                roomToCancel = r;
                break;
            }
        }

        if (roomToCancel != null) {
            roomToCancel.cancelBooking();
        } else {
            System.out.println("Phong voi so " + roomNumberToCancel + " khong ton tai.");
        }

        // Find room by type
        System.out.print("Nhap loai phong de tim: ");
        String searchRoomType = scanner.nextLine();
        hotel.findRoomByType(searchRoomType);

        // Display all bookings
        System.out.println("Danh sach dat phong hien tai:");
        hotel.displayAllBookings();
        scanner.close();
    }
}
