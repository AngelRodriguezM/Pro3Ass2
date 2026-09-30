package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tray")
public class Tray
{
  @Id
  @Column(name = "id")
  private int trayId;

  @Column(name = "max_weight_capacity")
  private int maxWeightCapacity;

  @OneToMany(mappedBy = "tray")
  private List<Part> parts = new ArrayList<>();

  @ManyToMany(mappedBy = "trays")
  private List<Product> products = new ArrayList<>();

  public Tray()
  {
  }

  public Tray(int maxWeightCapacity, int trayId)
  {
    this.maxWeightCapacity = maxWeightCapacity;
    this.trayId = trayId;
  }

  public int getMaxWeightCapacity()
  {
    return maxWeightCapacity;
  }

  public void setMaxWeightCapacity(int maxWeightCapacity)
  {
    this.maxWeightCapacity = maxWeightCapacity;
  }

  public List<Part> getParts()
  {
    return parts;
  }

  public void setParts(List<Part> parts)
  {
    this.parts = parts == null ? new ArrayList<>() : parts;
  }

  public List<Product> getProducts()
  {
    return products;
  }

  public void setProducts(List<Product> products)
  {
    this.products = products == null ? new ArrayList<>() : products;
  }

  public int getTrayId()
  {
    return trayId;
  }

  public void setTrayId(int trayId)
  {
    this.trayId = trayId;
  }
}
