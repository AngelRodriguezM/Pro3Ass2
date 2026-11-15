package dk.via.pro3.slaughterhouseserver.service;

import dk.via.pro3.slaughterhouseserver.Entities.Animal;
import dk.via.pro3.slaughterhouseserver.repository.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService
{
  private final AnimalRepository animalRepository;

  public AnimalService(AnimalRepository animalRepository)
  {
    this.animalRepository = animalRepository;
  }


  @Transactional
  public ResponseEntity<Animal> createAnimal(Animal animal)
  {
    if (animal == null || animal.getId() <= 0 || animal.getWeight() <= 0)
    {
      return ResponseEntity.badRequest().build();
    }
    if (animalRepository.existsById(animal.getId()))
    {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    if (animal.getSupplierId() <= 0
        || !animalRepository.supplierExists(animal.getSupplierId()))
    {
      return ResponseEntity.badRequest().build();
    }
    if (animal.getRegisteredAt() == null)
    {
      animal.setRegisteredAt(LocalDateTime.now());
    }
    if (animal.getArrivalTime() == null)
    {
      animal.setArrivalTime(animal.getRegisteredAt());
    }

    Animal saved = animalRepository.save(animal);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  public Optional<Animal> getAnimalById(int id)
  {
    return animalRepository.findById(id);
  }

  // date must be ISO format, e.g. 2026-11-15. Returns every animal registered that day.
  public List<Animal> getDateRegistered(String date)
  {
    LocalDate day;
    try
    {
      day = LocalDate.parse(date);
    }
    catch (DateTimeParseException e)
    {
      throw new IllegalArgumentException("Date must be in format yyyy-MM-dd", e);
    }
    return animalRepository.findByRegisteredAtGreaterThanEqualAndRegisteredAtLessThan(
        day.atStartOfDay(), day.plusDays(1).atStartOfDay());
  }

  // supplier can be a supplier id (e.g. "3") or a supplier name (e.g. "Hansen Farm")
  public List<Animal> getAnimalBySupplier(String supplier)
  {
    try
    {
      return animalRepository.findBySupplierId(Integer.parseInt(supplier));
    }
    catch (NumberFormatException e)
    {
      return animalRepository.findBySupplierNameIgnoreCase(supplier);
    }
  }
}
