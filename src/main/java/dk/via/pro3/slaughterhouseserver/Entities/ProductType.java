package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductType
{
  @Id
  private int productTypeId;
  private String name;
  private String description;

  @OneToMany(mappedBy = "productType")
  private List<Product> products = new ArrayList<>();

  @OneToMany(mappedBy = "productType")
  private List<ProductTypeRequirement> requirements = new ArrayList<>();

  public ProductType()
  {
  }

  public ProductType(String description, String name, int productTypeId)
  {
    this.description = description;
    this.name = name;
    this.productTypeId = productTypeId;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<Product> getProducts()
  {
    return products;
  }

  public void setProducts(List<Product> products)
  {
    this.products = products == null ? new ArrayList<>() : products;
  }

  public int getProductTypeId()
  {
    return productTypeId;
  }

  public void setProductTypeId(int productTypeId)
  {
    this.productTypeId = productTypeId;
  }

  public List<ProductTypeRequirement> getRequirements()
  {
    return requirements;
  }

  public void setRequirements(List<ProductTypeRequirement> requirements)
  {
    this.requirements = requirements == null ? new ArrayList<>() : requirements;
  }
}
