package Users.vpokemon.IdeaProjects.Hibernate.app;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private double total;

    @ManyToMany(mappedBy = "Item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cart> cart = new HashSet<>();

    public Item() {}

    public Item(double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }
}
