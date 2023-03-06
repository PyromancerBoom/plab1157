public class Trainer extends Person{
  private boolean isTraining = false;

  public Trainer(String name){
    super(name);
  }

  public void train(){
    this.isTraining = true;
  }

  public void stopTraining(){
    this.isTraining = false;
  }

  public boolean isTraining(){
    return isTraining;
  }

  @Override
  public String toString(){
    return "Trainer: " + super.toString();
  }
}