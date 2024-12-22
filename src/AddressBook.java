import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contacts>adbook1=new ArrayList<>();
    public void CreateContact() {

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
        System.out.println("Created Contact successfully");
    }


    public void editContact() {
        System.out.println("Enter the first name of person whose detail you want to edit:");
        String name=sc.next();
        adbook1.stream().filter(t->t.getFirstName().equalsIgnoreCase(name))
                .map(t->{
                    System.out.println("Contact Found");
                    System.out.println("What would you like to edit? Press 1) first name \\n2) for last name \\n 3) for city \\n 4) for state \\n 5) for email \\n 6)Phone \\n 7) zip code");
                    int c=sc.nextInt();
                    switch (c){
                        case 1-> t.setFirstname(sc.next());
                        case 2-> t.setLastname(sc.next());
                        case 3-> t.setCity(sc.next());
                        case 4-> t.setState(sc.next());
                        case 5-> t.setEmail(sc.next());
                        case 6-> t.setPhone(sc.nextInt());
                        case 7-> t.setZip(sc.nextInt());
                        default -> System.out.println("Invalid");
                    }
                    System.out.println("Contact Updated");
                    return true;
                }).findFirst();
        return;
    }

    public void display(){
        System.out.println(adbook1);
    }

}
