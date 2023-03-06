public class Treadmill extends Equipment{
  private double speed;

  public Treadmill(double speed){
    this.speed = speed;
  }

  @Override
  public String toString(){
    return String.format("%sTreadmill at speed %d", super.toString(), this.speed);
  }
}
