package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product
{
  @Id
  @Column(name = "id")
  private int productId;

  @Column(name = "packed_at")
  private LocalDateTime packedAt;

  @Column(name = "registered_at")
  private LocalDateTime registeredAt;

  @ManyToMany
  @JoinTable(
      name = "product_tray",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "tray_id")
  )
  private List<Tray> trays = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_type_id", nullable = false)
  private ProductType productType;

  public Product()
  {
  }

  public Product(LocalDateTime packedAt, int productId, ProductType productType,
      LocalDateTime registeredAt, List<Tray> trays)
  {
    this.packedAt = packedAt;
    this.productId = productId;
    this.productType = productType;
    this.registeredAt = registeredAt;
    this.trays = trays == null ? new ArrayList<>() : trays;
  }

  public LocalDateTime getPackedAt()
  {
    return packedAt;
  }

  public void setPackedAt(LocalDateTime packedAt)
  {
    this.packedAt = packedAt;
  }

  public int getProductId()
  {
    return productId;
  }

  public void setProductId(int productId)
  {
    this.productId = productId;
  }

  public ProductType getProductType()
  {
    return productType;
  }

  public void setProductType(ProductType productType)
  {
    this.productType = productType;
  }

  public LocalDateTime getRegisteredAt()
  {
    return registeredAt;
  }

  public void setRegisteredAt(LocalDateTime registeredAt)
  {
    this.registeredAt = registeredAt;
  }

  public List<Tray> getTrays()
  {
    return trays;
  }

  public void setTrays(List<Tray> trays)
  {
    this.trays = trays == null ? new ArrayList<>() : trays;
  }

}
