public class Gym {
    private Person[] persons;
    private Equipment[] equipments;
    private int currentCap = 0;
    private int maxcap;

    public Gym(Person[] persons, Equipment[] equipments, int maxcap) {
        this.equipments = equipments;
        this.maxcap = maxcap;
        this.persons = persons;
    }

    public void printEquipment() {
        for (Equipment equipment : equipments) {
            System.out.println(equipment.toString());
        }
    }

    public void printPeople() {
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].toString());
        }
    }

    public void increasePerson() {
        currentCap += 1;
    }

    public boolean isFull() {
        return currentCap > maxcap;
    }

    @Override
    public String toString() {
        return String.format("Gym Capacity: %d/%d", this.currentCap, this.maxcap);
    }
}