package dk.via.pro3.slaughterhouseserver.Controllers;

import dk.via.pro3.slaughterhouseserver.Entities.Animal;
import dk.via.pro3.slaughterhouseserver.service.AnimalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController
{
  private final AnimalService animalService;

  public AnimalController(AnimalService animalService)
  {
    this.animalService = animalService;
  }
  //should include date, weight, reg num,

  @PostMapping
  public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal)
  {
    return animalService.createAnimal(animal);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Animal> getAnimalById(@PathVariable int id){
    return animalService.getAnimalById(id)
        .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/date/{date}")
  public ResponseEntity<List<Animal>> getDateRegistered(@PathVariable String date){
    try
    {
      return ResponseEntity.ok(animalService.getDateRegistered(date));
    }
    catch (IllegalArgumentException e)
    {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/origin/{origin}")
  public ResponseEntity<List<Animal>> getAnimalBySupplier(@PathVariable("origin") String supplier){
    return ResponseEntity.ok(animalService.getAnimalBySupplier(supplier));
  }
}
