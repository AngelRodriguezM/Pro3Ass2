package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_type_requirement")
public class ProductTypeRequirement
{
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "required_quantity")
  private int requiredQuantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_type_id", nullable = false)
  private ProductType productType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "part_type_id", nullable = false)
  private PartType partType;

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
