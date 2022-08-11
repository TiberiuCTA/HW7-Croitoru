package produs.hw7croitoru.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import produs.hw7croitoru.Model.Produs;
import produs.hw7croitoru.Repository.ProdusRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdusService {
    private final ProdusRepository produsRepository;

    public List<Produs> getAll(){
        return produsRepository.findAll();
    }
    public List<Produs> getAllNoDeleted(){
        return getAll().stream().filter(produs -> !produs.isDeleted()).collect(Collectors.toList());
    }

    public void insert(Produs produs){
        produsRepository.save(produs);
    }

    public void increment(Integer id){
        produsRepository.increment(id);
    }

    public void decrement(Integer id){
        produsRepository.decrement(id);
    }

    public void delete(Integer id){
        Produs produs = produsRepository.findById(id).get();
        produs.setDeleted(true);
        produsRepository.save(produs);
    }

    public void updateStock(Integer id, Integer stock){
        Produs produs = produsRepository.findById(id).get();
        produs.setStock(stock);
        produsRepository.save(produs);
    }
}