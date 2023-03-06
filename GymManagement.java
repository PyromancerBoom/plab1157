import java.util.Scanner;

public class GymManagement {
    Gym gym;
    Person[] persons;
    private Equipment[] equipments;

    public static String[] types;
    public static boolean[] inUse;
    public static double[] weight;
    public static double[] speed;
    public static String[] kinds;
    public static String[] names;
    public static boolean[] isTraining;
    public static int[] customerTrained;
    public static int[] equipmentUsed;
    public static int capacity;
    public static int currentCapacity;

    private static final int TREADMILL = 0;
    private static final int DUMBBELL = 1;
    private static final int TRAINER = 0;
    private static final int CUSTOMER = 1;
    private static final int ENTER = 0;
    private static final int START = 1;
    private static final int FINISH = 2;


    public GymManagement() {
        Scanner scanner = new Scanner(System.in);


        // Read Equipment
        initEquipments(scanner);

        // Read Customers
        initPeople(scanner);

        gym = new Gym()

        // Read Gym Capacity
        capacity = scanner.nextInt();
        currentCapacity = 0;

        // Read Actions
        int numActions = scanner.nextInt();
        for (int i = 0; i < numActions; i++) {
            int action = scanner.nextInt();
            if (action == GymManagement.ENTER) {
                int customerNum = scanner.nextInt();
                return new EnterGym((Customer) persons[index]);

            } else if (action == GymManagementBackupFIle.START) {
                int trainer = scanner.nextInt();
                int customer = scanner.nextInt();
                int equipment = scanner.nextInt();
                if (isTraining[trainer] || inUse[equipment]) {
                    System.out.println("Cannot Train!");
                } else {
                    isTraining[trainer] = true;
                    isTraining[customer] = true;
                    inUse[equipment] = true;
                    equipmentUsed[trainer] = equipment;
                    customerTrained[trainer] = customer;
                    String equipmentStatus = "";
                    if (types[equipment] == "Treadmill") {
                        equipmentStatus = "Equipment: Treadmill at speed " + speed[equipment];
                    } else if (types[equipment] == "Dumbbell") {
                        equipmentStatus = "Equipment: Dumbbell with weight " + weight[equipment];
                    }
                    System.out.println("Trainer: " + names[trainer] + " training Customer: "
                            + names[customer] + " using " + equipmentStatus);
                }
            } else if (action == GymManagementBackupFIle.FINISH) {
                int trainer = scanner.nextInt();
                if (!isTraining[trainer]) {
                    System.out.println("Trainer: " + names[trainer] + " is not training");
                } else {
                    System.out.println("Trainer: " + names[trainer] + " has finished training");
                    isTraining[trainer] = false;
                    inUse[equipmentUsed[trainer]] = false;
                    customerTrained[trainer] = -1;
                    equipmentUsed[trainer] = -1;
                }
            }
        }
    }

    private void initPeople(Scanner scanner) {
        int numPeople = scanner.nextInt();
        persons = new Person[numPeople];

        for (int i = 0; i < numPeople; i++) {
            int peopleKind = scanner.nextInt();
            if (peopleKind == GymManagement.TRAINER) {
                names[i] = scanner.next();
                persons[i] = new Trainer(names[i]);
//                customerTrained[i] = -1;
//                equipmentUsed[i] = -1;
            } else if (peopleKind == GymManagement.CUSTOMER) {
                names[i] = scanner.next();
                persons[i] = new Customer(names[i]);
            }
        }
    }

    private void initEquipments(Scanner scanner) {
        int numEquipment = scanner.nextInt();
        equipments = new Equipment[numEquipment];
        for (int i = 0; i < numEquipment; i++) {
            int equipmentType = scanner.nextInt();
            if (equipmentType == GymManagement.TREADMILL) {
                double speed = scanner.nextDouble();
                equipments[i] = new Treadmill(speed);
            } else if (equipmentType == GymManagement.DUMBBELL) {
                double weight = scanner.nextDouble();
                equipments[i] = new Dumbbell(weight);
            }
        }
    }
}