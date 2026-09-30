package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tray
{
  @Id
  private int trayId;
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
