package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "part")
public class Part
{
  @Id
  @Column(name = "id")
  private int partId;

  @Column(name = "weight")
  private int weight;

  @Column(name = "registered_at")
  private LocalDateTime registeredAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "animal_id", nullable = false)
  private Animal animal;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "part_type_id", nullable = false)
  private PartType partType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tray_id", nullable = false)
  private Tray tray;

  public Part()
  {
  }

  public Part(Animal animal, int partId, PartType partType,
      LocalDateTime registeredAt, Tray tray, int weight)
  {
    this.animal = animal;
    this.partId = partId;
    this.partType = partType;
    this.registeredAt = registeredAt;
    this.tray = tray;
    this.weight = weight;
  }

  public Animal getAnimal()
  {
    return animal;
  }

  public void setAnimal(Animal animal)
  {
    this.animal = animal;
  }

  public int getPartId()
  {
    return partId;
  }

  public void setPartId(int partId)
  {
    this.partId = partId;
  }

  public PartType getPartType()
  {
    return partType;
  }

  public void setPartType(PartType partType)
  {
    this.partType = partType;
  }

  public LocalDateTime getRegisteredAt()
  {
    return registeredAt;
  }

  public void setRegisteredAt(LocalDateTime registeredAt)
  {
    this.registeredAt = registeredAt;
  }

  public Tray getTray()
  {
    return tray;
  }

  public void setTray(Tray tray)
  {
    this.tray = tray;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }
}
