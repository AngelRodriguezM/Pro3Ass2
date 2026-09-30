package dk.via.pro3.slaughterhouseserver.service;

import dk.via.pro3.slaughterhouseserver.repository.TraceabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceabilityService
{
  private final TraceabilityRepository repository;

  public TraceabilityService(TraceabilityRepository repository)
  {
    this.repository = repository;
  }

  public List<Integer> getAnimalsForProduct(int productId)
  {
    return repository.findAnimalIdsByProductId(productId);
  }

  public List<Integer> getProductsForAnimal(int animalId)
  {
    return repository.findProductIdsByAnimalId(animalId);
  }
}