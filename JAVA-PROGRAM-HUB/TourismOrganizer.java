import java.util.*;

// Base class to handle user input and store tour details
class TourDetails {
    protected String destination;
    protected int duration;
    protected double price;

    @SuppressWarnings("resource")
    // Method to get details of the tour from user
    public void getTourDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter destination: ");
        destination = scanner.nextLine();
        System.out.print("Enter duration (in days): ");
        duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price: ");
        price = Double.parseDouble(scanner.nextLine());
    }

    // Method to display tour details
    public void displayTourDetails() {
        System.out.println("Destination: " + destination);
        System.out.println("Duration: " + duration + " days");
        System.out.println("Price: $" + price);
    }
}

// Derived class for Tour 1
class Tour1 extends TourDetails implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing Tour 1...");
        displayTourDetails();
    }
}

// Derived class for Tour 2
class Tour2 extends TourDetails implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing Tour 2...");
        displayTourDetails();
    }
}

// Derived class for Tour 3
class Tour3 extends TourDetails implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing Tour 3...");
        displayTourDetails();
    }
}

// Derived class for Tour 4
class Tour4 extends TourDetails implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing Tour 4...");
        displayTourDetails();
    }
}

// Derived class for Tour 5
class Tour5 extends TourDetails implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing Tour 5...");
        displayTourDetails();
    }
}

// Main class to handle the user interface and run the program
public class TourismOrganizer {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;

        TourDetails[] tours = new TourDetails[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Tour " + (i + 1) + ":");
            tours[i] = new TourDetails();
            tours[i].getTourDetails();
        }

        do {
            System.out.println("Select a tour to process:");
            System.out.println("1. Tour 1");
            System.out.println("2. Tour 2");
            System.out.println("3. Tour 3");
            System.out.println("4. Tour 4");
            System.out.println("5. Tour 5");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    Tour1 tour1 = new Tour1();
                    tour1.destination = tours[0].destination;
                    tour1.duration = tours[0].duration;
                    tour1.price = tours[0].price;
                    Thread thread1 = new Thread(tour1);
                    thread1.start();
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted.");
                    }
                }
                case 2 -> {
                    Tour2 tour2 = new Tour2();
                    tour2.destination = tours[1].destination;
                    tour2.duration = tours[1].duration;
                    tour2.price = tours[1].price;
                    Thread thread2 = new Thread(tour2);
                    thread2.start();
                    try {
                        thread2.join();
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted.");
                    }
                }
                case 3 -> {
                    Tour3 tour3 = new Tour3();
                    tour3.destination = tours[2].destination;
                    tour3.duration = tours[2].duration;
                    tour3.price = tours[2].price;
                    Thread thread3 = new Thread(tour3);
                    thread3.start();
                    try {
                        thread3.join();
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted.");
                    }
                }
                case 4 -> {
                    Tour4 tour4 = new Tour4();
                    tour4.destination = tours[3].destination;
                    tour4.duration = tours[3].duration;
                    tour4.price = tours[3].price;
                    Thread thread4 = new Thread(tour4);
                    thread4.start();
                    try {
                        thread4.join();
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted.");
                    }
                }
                case 5 -> {
                    Tour5 tour5 = new Tour5();
                    tour5.destination = tours[4].destination;
                    tour5.duration = tours[4].duration;
                    tour5.price = tours[4].price;
                    Thread thread5 = new Thread(tour5);
                    thread5.start();
                    try {
                        thread5.join();
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted.");
                    }
                }
                default -> System.out.println("Invalid choice. Please select a valid tour number.");
            }            
            System.out.print("Do you want to process another tour? (Yes/No): ");
            continueChoice = scanner.nextLine();
        } while (continueChoice.equalsIgnoreCase("Yes"));

        scanner.close();
        System.out.println("Thank you for using the Tourism Organizer!");
    }
}