public class EnterGym implements Executable{
    Customer customer;

    public EnterGym(Customer customer){
        this.customer = customer;
    }

    @Override
    public void execute() {
        if (gym.isFull()) {
            System.out.println(customer.toString() + " cannot enter");
        } else {
            gym.increasePerson();
            System.out.println(customer.toString() + " can enter");
        }
        System.out.println(gym.toString());
    }
}
