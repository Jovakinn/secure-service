package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "continents")
public class Continent extends AbstractEntity {
    private String name;
    private Planet planet;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planet_id")
    public Planet getPlanet() {
        return planet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Continent continent = (Continent) o;
        return getId() != null && Objects.equals(getId(), continent.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
