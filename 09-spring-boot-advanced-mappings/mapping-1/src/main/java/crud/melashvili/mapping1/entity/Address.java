package crud.melashvili.mapping1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @ManyToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public Address(String address) {
        this.address = address;
    }

    public Address() {}
}
