public class EndTraining implements Executable{
    Trainer trainer;
    Customer customer;
    Equipment equipment;

    public EndTraining(Trainer trainer, Equipment equipment, Customer customer){
        this.trainer = trainer;
        this.equipment = equipment;
        this.customer = customer;
    }

    @Override
    public void execute(){
        if (!trainer.isTraining()) {
            System.out.println(trainer.toString() + " is not training");
        } else {
            System.out.println(trainer.toString() + " has finished training");
            trainer.stopTraining();
            this.customer.stopTraining();
            equipment.setAvailable();
        }
    }
}
