package es.zed.api.match.infrastructure.riot.dto;

public class ObjectivesDto {

  private ObjectiveDto baron;
  private ObjectiveDto champion;
  private ObjectiveDto dragon;
  private ObjectiveDto horde;
  private ObjectiveDto inhibitor;
  private ObjectiveDto riftHerald;
  private ObjectiveDto tower;

  public ObjectivesDto() {
  }

  public ObjectiveDto getBaron() {
    return baron;
  }

  public void setBaron(ObjectiveDto baron) {
    this.baron = baron;
  }

  public ObjectiveDto getChampion() {
    return champion;
  }

  public void setChampion(ObjectiveDto champion) {
    this.champion = champion;
  }

  public ObjectiveDto getDragon() {
    return dragon;
  }

  public void setDragon(ObjectiveDto dragon) {
    this.dragon = dragon;
  }

  public ObjectiveDto getHorde() {
    return horde;
  }

  public void setHorde(ObjectiveDto horde) {
    this.horde = horde;
  }

  public ObjectiveDto getInhibitor() {
    return inhibitor;
  }

  public void setInhibitor(ObjectiveDto inhibitor) {
    this.inhibitor = inhibitor;
  }

  public ObjectiveDto getRiftHerald() {
    return riftHerald;
  }

  public void setRiftHerald(ObjectiveDto riftHerald) {
    this.riftHerald = riftHerald;
  }

  public ObjectiveDto getTower() {
    return tower;
  }

  public void setTower(ObjectiveDto tower) {
    this.tower = tower;
  }
}
