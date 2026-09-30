package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal
{
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "arrival_time")
  private LocalDateTime arrivalTime;

  @Column(name = "weight")
  private int weight;

  @Column(name = "registered_at")
  private LocalDateTime registeredAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "supplier_id", nullable = false)
  private Supplier supplier;

  @OneToMany(mappedBy = "animal")
  private List<Part> parts = new ArrayList<>();

  public Animal(int id, LocalDateTime arrivalTime, int weight, Supplier supplier, LocalDateTime registeredAt)
  {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.weight = weight;
    this.supplier = supplier;
    this.registeredAt = registeredAt;
  }

  public Animal()
  {
  }

  public LocalDateTime getArrivalTime()
  {
    return arrivalTime;
  }

  public void setArrivalTime(LocalDateTime arrivalTime)
  {
    this.arrivalTime = arrivalTime;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public LocalDateTime getRegisteredAt()
  {
    return registeredAt;
  }

  public void setRegisteredAt(LocalDateTime registeredAt)
  {
    this.registeredAt = registeredAt;
  }

  public Supplier getSupplier()
  {
    return supplier;
  }

  public void setSupplier(Supplier supplier)
  {
    this.supplier = supplier;
  }

  public int getSupplierId()
  {
    return supplier != null ? supplier.getId() : 0;
  }

  public void setSupplierId(int supplierId)
  {
    if (supplier == null)
    {
      supplier = new Supplier();
    }
    supplier.setId(supplierId);
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }

  public List<Part> getParts()
  {
    return parts;
  }

  public void setParts(List<Part> parts)
  {
    this.parts = parts == null ? new ArrayList<>() : parts;
  }
}
