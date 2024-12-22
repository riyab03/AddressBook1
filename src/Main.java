import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");
        AddressBook a1=new AddressBook();
        int loop=1;
        do {
            System.out.println("Enter 0}creating addressbook 1}creating a contact 2}editing the details 3}deleting contact detail 4}display the information 5}Search a person by city or state 6}Sort By name 7}Sort by city 8}Sort by state 9}Sort by Zip");
            int i = sc.nextInt();
            switch (i) {
                case 0-> a1.addAddressbook();
                case 1->
                    a1.CreateContact();
                case 2->
                    a1.editContact();
                case 3->
                    a1.deleteContact();
                case 4->
                    a1.display();
                case 5->
                    a1.searchByCityState();
                case 6->
                    a1.sortByName();
                case 7->
                        a1.sortByCity();
                case 8->
                        a1.sortByState();
                case 9->
                        a1.sortByZip();
                default -> {
                    break;
                }
            }
            System.out.println("Enter 0 to Exit or 1 to continue");
            loop=sc.nextInt();
        }while(loop!=0);
    }
}