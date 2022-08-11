package produs.hw7croitoru.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produs {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    private Integer stock;
    private boolean deleted = false;
    private Type type;
}
