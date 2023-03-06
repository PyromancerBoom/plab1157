public class Customer extends Person{
  private boolean isTraining = false;

  public Customer(String name){
    super(name);
  }

  public void train(){
    this.isTraining = true;
  }

  public void stopTraining() {
    this.isTraining = false;
  }

  @Override
  public String toString(){
    return String.format("Customer: " + super.toString());
  }
}
