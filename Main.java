import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    Common Scanner Input
    Scanner sc = new Scanner(System.in);

    ArrayList<customer> customerObj = new ArrayList<customer>();

    public void createObj()
    {
        customerObj.add(new customer(1,"aaa","111",24,'F'));
        customerObj.add(new customer(2,"bbb","222",61,'M'));
        customerObj.add(new customer(3,"ccc","333",22,'M'));
        customerObj.add(new customer(4,"ddd","444",36,'F'));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Main m = new Main();
        m.createObj();
        System.out.println("Hi! Welcome to Bus Ticket Booking System\n---------------------------");
        int choice;
        while (true) {
            System.out.println("\n1.Login\n2.Register\n3.Exit\n");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Let us find you .....");
                    m.customerLogin();
                    break;
                }
                case 2: {
                    System.out.println("Lets create a space for you !");
                    m.customerRegister();
                    break;
                }
                case 3: {
                    System.out.println("Bye Bye!!");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Invalid Choice !!!");
                    break;
                }
            }
        }
    }

    void customerRegister() {
        int id = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\nPlease enter your details.");
            System.out.println("\nDetails needed: {id, name, pass, age, gender (M or F).");
            id = sc.nextInt();
            for (customer c : customerObj) {
                if (c.id == id) {
                    System.out.println("Oops! Id already exist. Try with another ID.");
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
        }
        String name = sc.next();
        String pass = sc.next();
        int age = sc.nextInt();
        char gender = sc.next().charAt(0);
        customerObj.add(new customer(id, name, pass, age, gender));
        System.out.println("Wow! Account Successfully created.");
    }

    void customerLogin() {
        if(customerObj.isEmpty()) {
            System.out.println("Nope! No Account found. Be a first customer.");

        } else {
            System.out.println("\nPlease enter your details.");
            System.out.println("\nDetails needed: {id, pass}");
            int id = sc.nextInt();
            String pass = sc.next();
            customer current_cust = null;
            int ok = 0;
            for(customer c : customerObj) {

                if(c.id == id && c.pass.equals(pass)) {
                    ok++;
                    current_cust = c;
                    break;
                }
            }
            if(ok != 0) {
                System.out.print("Success! Welcome "+ current_cust.name+ "\n");
                int loginchoice;
                int isLogin = 1;
                while(isLogin == 1) {
                    System.out.println("\n1.Wait\n2.Logout\n");
                    loginchoice = sc.nextInt();
                    switch (loginchoice) {
                        case 1: {
                            System.out.println("Waiting.....");
                            break;
                        }
                        case 2: {
                            System.out.println("Signed out Successfully. See you again.");
                            isLogin = 0;
                            break;
                        }
                        default: {
                            System.out.println("Invalid Choice !!!");
                            break;
                        }
                    }

                }
            } else {
                System.out.println("Oops! Login Failed. Correct your credentials.");
            }
        }
    }
}
