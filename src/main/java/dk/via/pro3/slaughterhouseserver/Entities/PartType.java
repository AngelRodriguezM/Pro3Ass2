package dk.via.pro3.slaughterhouseserver.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PartType
{
  @Id
  private int partTypeId;

  private String name;
  private String description;

  @OneToMany(mappedBy = "partType")
  private List<Part> parts = new ArrayList<>();

  @OneToMany(mappedBy = "partType")
  private List<ProductTypeRequirement> requirements = new ArrayList<>();

  public PartType()
  {
  }

  public PartType(String description, String name, int partTypeId)
  {
    this.description = description;
    this.name = name;
    this.partTypeId = partTypeId;
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

  public List<Part> getParts()
  {
    return parts;
  }

  public void setParts(List<Part> parts)
  {
    this.parts = parts == null ? new ArrayList<>() : parts;
  }

  public int getPartTypeId()
  {
    return partTypeId;
  }

  public void setPartTypeId(int partTypeId)
  {
    this.partTypeId = partTypeId;
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
