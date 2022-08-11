package produs.hw7croitoru.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import produs.hw7croitoru.Model.Produs;
import produs.hw7croitoru.Service.ProdusService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("produse")
public class ProdusController {

    private final ProdusService produsService;

    @GetMapping("/all")
    public List<Produs> getAll(){
        return produsService.getAll();
    }

    @GetMapping
    public List<Produs> getAllNoDeleted(){
        return produsService.getAllNoDeleted();
    }

    @PostMapping
    public void addProdus(@RequestBody Produs produs){
        produsService.insert(produs);
    }

    @PutMapping("increment/{id}")
    public void increment(@PathVariable Integer id){
        produsService.increment(id);
    }
    @PutMapping("decrement/{id}")
    public void decrement(@PathVariable Integer id){
        produsService.decrement(id);
    }
    @DeleteMapping("{id}")
    public void deleteProdus(@PathVariable Integer id){
        produsService.delete(id);
    }
    @PutMapping("/updateStock/{id}/{stock}")
    public void updateStock(@PathVariable Integer id,@PathVariable Integer stock){
        produsService.updateStock(id, stock);
    }
}