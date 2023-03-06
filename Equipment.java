public abstract class Equipment{
  private boolean available = true;

  @Override
  public String toString(){
    return "Equipment: ";
  }

  public void setInUse(){
    this.available = false;
  }

  public void setAvailable () { this.available = true; }

  public boolean isAvailable(){ return this.available;}
}
