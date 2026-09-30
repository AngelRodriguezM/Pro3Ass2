package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductTypeRequirement
{
  @Id
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_type_id", nullable = false)
  private ProductType productType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "part_type_id", nullable = false)
  private PartType partType;

  private int requiredQuantity;

  public ProductTypeRequirement()
  {
  }

  public ProductTypeRequirement(int id, PartType partType, ProductType productType,
      int requiredQuantity)
  {
    this.id = id;
    this.partType = partType;
    this.productType = productType;
    this.requiredQuantity = requiredQuantity;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public PartType getPartType()
  {
    return partType;
  }

  public void setPartType(PartType partType)
  {
    this.partType = partType;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public void setProductType(ProductType productType)
  {
    this.productType = productType;
  }

  public int getRequiredQuantity()
  {
    return requiredQuantity;
  }

  public void setRequiredQuantity(int requiredQuantity)
  {
    this.requiredQuantity = requiredQuantity;
  }
}
