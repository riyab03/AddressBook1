import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contacts>adbook1=new ArrayList<>();
    public void CreateContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name:");
        String f_name = sc.next();
        System.out.println("Enter Last name:");
        String l_name = sc.next();
        System.out.println("Enter Address:");
        String address = sc.next();
        System.out.println("Enter city:");
        String city = sc.next();
        System.out.println("Enter state:");
        String state = sc.next();
        System.out.println("Enter zip number:");
        int zip = sc.nextInt();
        System.out.println("Enter Phone number:");
        int phn_no = sc.nextInt();
        System.out.println("Enter Email:");
        String email = sc.next();
        Contacts c1 = new Contacts(f_name, l_name, address, city, state, zip, phn_no, email);
        adbook1.add(c1);
    }
    

}
