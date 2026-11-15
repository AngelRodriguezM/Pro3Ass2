package dk.via.pro3.slaughterhouseserver.repository;

import dk.via.pro3.slaughterhouseserver.Entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>
{
  // All animals registered in the time window [start, end)
  List<Animal> findByRegisteredAtGreaterThanEqualAndRegisteredAtLessThan(
      LocalDateTime start, LocalDateTime end);

  // All animals delivered by a supplier, matched on the supplier's name (case-insensitive)
  List<Animal> findBySupplierNameIgnoreCase(String supplierName);

  // All animals delivered by a supplier, matched on the supplier's id
  List<Animal> findBySupplierId(int supplierId);

  @Query("SELECT COUNT(s) > 0 FROM Supplier s WHERE s.id = :supplierId")
  boolean supplierExists(@Param("supplierId") int supplierId);
}
