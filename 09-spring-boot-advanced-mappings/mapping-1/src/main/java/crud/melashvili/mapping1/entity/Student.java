package crud.melashvili.mapping1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Address> addresses;

    public Student(String firstName) {
        this.firstName = firstName;
    }

    public Student() {}

    public void addAddress(Address address){
        if(addresses == null){
            addresses = new ArrayList<>();
        }
        addresses.add(address);
        address.setStudent(this);
    }
}
