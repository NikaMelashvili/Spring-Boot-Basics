package com.exam.nikolozmelashvili.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "flight_number")
    private String flightNumber;

    @OneToOne(mappedBy = "flights",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private City city;
}
