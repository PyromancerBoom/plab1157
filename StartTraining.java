public class StartTraining implements Executable{
    Customer customer;
    Trainer trainer;
    Equipment equipment;

    public StartTraining(Customer customer, Trainer trainer, Equipment equipment){
        this.customer = customer;
        this.trainer = trainer;
        this.equipment = equipment;
    }

    @Override
    public void execute(){
        if (trainer.isTraining() || !equipment.isAvailable()) {
            System.out.println("Cannot Train!");
        } else {
            trainer.train();
            this.customer.train();
            equipment.setInUse();
            System.out.println(trainer.toString() + " training" + customer.toString() + " using " + equipment.toString());
        }
    }
}