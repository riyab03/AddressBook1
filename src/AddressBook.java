import java.util.*;

public class AddressBook {
    Scanner sc = new Scanner(System.in);


    Map<String, Set<Contacts>> ad=new HashMap<>();


    public void CreateContact() {
        System.out.println("Enter the name of AddressBook where you want to create contact: ");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        if(a1==null){
            System.out.println("No such addressBook");return;
        }
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
        a1.add(c1);
        System.out.println("Created Contact successfully");
    }


    public void editContact() {
        System.out.println("Enter the name of AddressBook where you want to create contact: ");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        if(a1==null){
            System.out.println("No such addressBook");return;
        }
        System.out.println("Enter the first name of person whose detail you want to edit:");
        String fname=sc.next();
        System.out.println("Enter the last name of person whose detail you want to delete:");
        String lname=sc.next();

        a1.stream().filter(t->t.getFirstName().equalsIgnoreCase(fname) && t.getlastName().equalsIgnoreCase(lname))
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
                }).findFirst().orElse(null);
    }


    public void display(){
        System.out.println("Enter the name of AddressBook where you want to create contact: ");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        if(a1==null || a1.isEmpty()){
            System.out.println("NO Contact found in Addressbook:"+book);
            return;
        }
        System.out.println("Contacts in AddressBook"+book);
        System.out.println(a1);
    }


    public void deleteContact() {
        System.out.println("Enter the name of AddressBook where you want to create contact: ");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        if(a1==null){
            System.out.println("No such addressBook");
            return;
        }
        System.out.println("Enter the first name of person whose detail you want to delete:");
        String fname=sc.next();
        System.out.println("Enter the last name of person whose detail you want to delete:");
        String lname=sc.next();

        Contacts c=a1.stream().filter(t->t.getFirstName().equalsIgnoreCase(fname) && t.getlastName().equalsIgnoreCase(lname) ).findFirst().get();
        if(c==null){
            System.out.println("Contact not found");
        }
        else{
            a1.remove(c);
            System.out.println("Contact deleted");
        }
    }


    public void addAddressbook() {
        System.out.println("Enter Adressbook Name:");
        String name=sc.next();

        if(ad.containsKey(name)){
            System.out.println("AddressBook :"+name+" already exists.");
        }
        else{
            ad.put(name,new HashSet<>());
            System.out.println("AddressBook :"+name+" added.");
        }
    }


}
