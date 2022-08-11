package produs.hw7croitoru.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import produs.hw7croitoru.Model.Produs;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Integer> {
    List<Produs> findAll();
    @Transactional
    @Modifying
    @Query(value = "UPDATE Produs p set p.stock = p.stock + 1 WHERE p.id = :id")
    void increment(@Param("id") Integer id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Produs p set p.stock = p.stock - 1 WHERE p.id = :id")
    void decrement(@Param("id") Integer id);
}
