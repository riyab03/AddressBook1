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
            System.out.println("Enter 1}creating a contact 2}editing the details 3}deleting contact detail 4}display the information");
            int i = sc.nextInt();
            switch (i) {
                case 1->
                    a1.CreateContact();
                case 2->
                    a1.editContact();
                case 3->
                    a1.deleteContact();
                case 4->
                    a1.display();
                default -> {
                    break;
                }
            }
            System.out.println("Enter 0 to Exit or 1 to continue");
            loop=sc.nextInt();
        }while(loop!=0);
    }
}