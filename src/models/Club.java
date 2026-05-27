package models;

import java.util.Arrays;

public class Club {
  private String name;
  private Athlete[] athletes;
  public Club(String name, Athlete[] athletes) {
    this.name = name;
    this.athletes = athletes;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Athlete[] getAthletes() {
    return athletes;
  }
  public void setAthletes(Athlete[] athletes) {
    this.athletes = athletes;
  }
  @Override
  public String toString() {
    return "Club [name=" + name + ", athletes=" + Arrays.toString(athletes) + "]";
  }
  
}
