package dk.via.pro3.slaughterhouseserver.repository;

import dk.via.pro3.slaughterhouseserver.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TraceabilityRepository
    extends JpaRepository<Product, Integer>
{
  @Query("""
        SELECT DISTINCT a.id
        FROM Product p
        JOIN p.trays t
        JOIN t.parts part
        JOIN part.animal a
        WHERE p.productId = :productId
        """)
  List<Integer> findAnimalIdsByProductId(
      @Param("productId") int productId
  );

  @Query("""
        SELECT DISTINCT p.productId
        FROM Product p
        JOIN p.trays t
        JOIN t.parts part
        JOIN part.animal a
        WHERE a.id = :animalId
        """)
  List<Integer> findProductIdsByAnimalId(
      @Param("animalId") int animalId
  );
}