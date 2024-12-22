import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    Scanner sc = new Scanner(System.in);


    Map<String, Set<Contacts>> ad=new HashMap<>();
    Map<String,Set<Contacts>>cityStore=new HashMap<>();
    Map<String,Set<Contacts>>stateStore=new HashMap<>();

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
        storeCityState(c1);
        System.out.println("Created Contact successfully");
    }

    private void storeCityState(Contacts c) {
        cityStore.computeIfAbsent(c.getcity(),k->new HashSet<>()).add(c);
        stateStore.computeIfAbsent(c.getstate(),k->new HashSet<>()).add(c);
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

    public void searchByCityState(){
        System.out.println("Enter 1 for city and 2 for state");
        int c=sc.nextInt();
        if(c==1){
            System.out.println("Enter the city you want to search for: ");
            String city=sc.next();
            cityStore.getOrDefault(city,Collections.emptySet()).stream().forEach(System.out::println);
            System.out.println("number of contacts having city as "+city+" are :"+cityStore.get(city).stream().count());
        }else if(c==2){
            System.out.println("Enter the state you want to search for: ");
            String state=sc.next();
            stateStore.getOrDefault(state,Collections.emptySet()).stream().forEach(System.out::println);
            System.out.println("number of contacts having state as "+state+" are :"+stateStore.get(state).stream().count());
        }else{
            System.out.println("Invalid Choice");
        }
    }

    public void sortByName() {
        System.out.println("Enter Addressbook Name:");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        List<Contacts> sortedByName=a1.stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList());
        System.out.println("Sorted By Name:");
        sortedByName.forEach(System.out::println);
    }

    public void sortByCity() {
        System.out.println("Enter Addressbook Name:");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        List<Contacts> sortedByCity=a1.stream().sorted(Comparator.comparing(Contacts::getcity)).collect(Collectors.toList());
        System.out.println("Sorted By City:");
        sortedByCity.forEach(System.out::println);
    }

    public void sortByState() {
        System.out.println("Enter Addressbook Name:");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        List<Contacts> sortedByState=a1.stream().sorted(Comparator.comparing(Contacts::getstate)).collect(Collectors.toList());
        System.out.println("Sorted By State:");
        sortedByState.forEach(System.out::println);
    }
    public void sortByZip() {
        System.out.println("Enter Addressbook Name:");
        String book=sc.next();
        Set<Contacts>a1=ad.get(book);
        List<Contacts> sortedByZip=a1.stream().sorted(Comparator.comparing(Contacts::getZip)).collect(Collectors.toList());
        System.out.println("Sorted By Zip:");
        sortedByZip.forEach(System.out::println);
    }
}
