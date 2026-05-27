package models;

import java.util.Arrays;

public class Tournament {
  private String name;
  private Club[] clubs;
  public Tournament(String name, Club[] clubs) {
    this.name = name;
    this.clubs = clubs;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Club[] getClubs() {
    return clubs;
  }
  public void setClubs(Club[] clubs) {
    this.clubs = clubs;
  }
  public int getTotalStarterPoints(){
    int total =0;
    for(Club c : clubs){
      for(Athlete a : c.getAthletes()){
        if (a.isStarter()){
          total++;
        }
      }
    }
    return total;
  }
  @Override
  public String toString() {
    return "Tournament [name=" + name + ", clubs=" + Arrays.toString(clubs) + "]";
  }
  
}
