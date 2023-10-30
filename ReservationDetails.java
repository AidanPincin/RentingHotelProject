import java.util.*;
//ignore yellow underlines. nothing is wrong just vs code being picky.
public class ReservationDetails {

    public class RoomInformation {
        String roomType;
        int nights;
        int rooms;
        double totalCost;
        double discountedCost = 0.00;
    }

    public class CustomerInformation {
        String name;
        String adress;
        String phoneNumber;
    }

    double SelectRoom(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select your room type: 1 for Signature or 2 for Economy");
        int room = input.nextInt();
        if(room==1){
            System.out.println("You've selected Signature!\n");
            return 430.00;
        }
        else if(room==2){
            System.out.println("You've selected Economy!\n");
            return 300.00;
        }
        else{
            System.out.println("This room type is invalid, please try your selection again");
            return SelectRoom();
        }
    }

    int getNumberOfRooms(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many rooms would you like to reserve: 1 or 2");
        int rooms = input.nextInt();
        if(rooms>2 || rooms<1){
            System.out.println("Invalid input");
            return getNumberOfRooms();
        }
        return rooms;
    }

    Object getRoomInformation(){
        RoomInformation info = new RoomInformation();
        double costPerNight = SelectRoom();
        Scanner input = new Scanner(System.in);
        System.out.println("How many nights are you staying");
        info.nights = input.nextInt();
        info.rooms = getNumberOfRooms();
        if(costPerNight == 430.00){
            info.roomType = "Signature";
        }
        else{
            info.roomType = "Economy";
        }
        if(info.nights>5){
            info.discountedCost = info.rooms*costPerNight*info.nights*0.1;
            info.totalCost = info.rooms*costPerNight*info.nights*0.9;
        }
        return info;
    }

    Object getCustomerInformation(){
        Scanner input = new Scanner(System.in);
        CustomerInformation info = new CustomerInformation();
        System.out.println("Please enter your first and last name");
        info.name = input.nextLine();
        System.out.println("Please enter your adress");
        info.adress = input.nextLine();
        System.out.println("Please enter your phone number");
        info.phoneNumber = input.nextLine();
        return info;
    }

    void displayDetails(RoomInformation roomInformation, CustomerInformation cusomterInformation){
        System.out.println("Booking details:\n");
        System.out.println("Name of customer: "+cusomterInformation.name);
        System.out.println("Adress of customer: "+cusomterInformation.adress);
        System.out.println("Mobile Number: "+cusomterInformation.phoneNumber);
        System.out.println("You have chosen "+roomInformation.roomType+" room for "+roomInformation.nights+" nights");
        System.out.println("Number of rooms reserved: "+roomInformation.rooms);
        System.out.println("You need to pay: $"+roomInformation.totalCost+". You have been discounted $"+roomInformation.discountedCost);
    }

    public static void main(String[] args) {
        ReservationDetails reserve = new ReservationDetails();
        reserve.displayDetails((ReservationDetails.RoomInformation)reserve.getRoomInformation(), (ReservationDetails.CustomerInformation)reserve.getCustomerInformation());
    }
}
