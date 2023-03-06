import java.util.Scanner;

class GymManagementBackupFIle {
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
  
  public void printEquipment() {
    for (int i = 0; i < types.length; i++) {
      if (types[i] == "Treadmill") {
        System.out.println("Equipment: Treadmill at speed " + speed[i]);
      } else if (types[i] == "Dumbbell") {
        System.out.println("Equipment: Dumbbell with weight " + weight[i]);
      }
    }
  }

  public void printPeople() {
    for (int i = 0; i < names.length; i++) {
      if (kinds[i] == "Trainer") {
        System.out.println("Trainer: " + names[i]);
      } else if (kinds[i] == "Customer") {
        System.out.println("Customer: " + names[i]);
      }
    }
  }

  public GymManagementBackupFIle() {
    Scanner scanner = new Scanner(System.in);
    
    // Read Equipment
    int numEquipment = scanner.nextInt();
    types = new String[numEquipment];
    inUse = new boolean[numEquipment];
    weight = new double[numEquipment];
    speed = new double[numEquipment];
    
    for (int i = 0; i < numEquipment; i++) {
      int equipmentType = scanner.nextInt();
      if (equipmentType == GymManagementBackupFIle.TREADMILL) {
        types[i] = "Treadmill";
        speed[i] = scanner.nextDouble();
      } else if (equipmentType == GymManagementBackupFIle.DUMBBELL) {
        types[i] = "Dumbbell";
        weight[i] = scanner.nextDouble();
      }
    }
    
    // Read Customers
    int numPeople = scanner.nextInt();
    kinds = new String[numPeople];
    names = new String[numPeople];
    isTraining = new boolean[numPeople];
    customerTrained = new int[numPeople];
    equipmentUsed = new int[numPeople];
    
    for (int i = 0; i < numPeople; i++) {
      int peopleKind = scanner.nextInt();
      if (peopleKind == GymManagementBackupFIle.TRAINER) {
        kinds[i] = "Trainer";
        names[i] = scanner.next();
        customerTrained[i] = -1;
        equipmentUsed[i] = -1;
      } else if (peopleKind == GymManagementBackupFIle.CUSTOMER) {
        kinds[i] = "Customer";
        names[i] = scanner.next();
      }
    }
    
    // Read Gym Capacity
    capacity = scanner.nextInt();
    currentCapacity = 0;
    
    // Read Actions
    int numActions = scanner.nextInt();
    for (int i = 0; i < numActions; i++) {
      int action = scanner.nextInt();
      if (action == GymManagementBackupFIle.ENTER) {
        int customer = scanner.nextInt();
        if (currentCapacity == capacity) {
          System.out.println("Customer: " + names[customer] + " cannot enter");
        } else {
          currentCapacity = currentCapacity + 1;
          System.out.println("Customer: " + names[customer] + " can enter");
        }
        System.out.println("Gym Capacity: " + currentCapacity + "/" + capacity);
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
}