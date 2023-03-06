public class Dumbbell extends Equipment{
  private double weight;

  public Dumbbell(double weight){
    this.weight = weight;
  }

  @Override
  public String toString(){
    return String.format("%sDumbbell with weight %d", super.toString(), this.weight);
  }
}
