package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier
{
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "supplier")
  private List<Animal> animals = new ArrayList<>();

  public Supplier(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public Supplier()
  {
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public List<Animal> getAnimals()
  {
    return animals;
  }

  public void addAnimal(Animal animal)
  {
    if (animal == null)
    {
      return;
    }
    animals.add(animal);
    if (animal.getSupplier() != this)
    {
      animal.setSupplier(this);
    }
  }

  public void setAnimals(List<Animal> animals)
  {
    this.animals = animals == null ? new ArrayList<>() : animals;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}