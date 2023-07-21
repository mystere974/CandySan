package com.candy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candybox", schema = "candy", catalog = "")
public class CandyBoxEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idCommande")
    private Integer idCommande;

    private int totalBonbons;

    private List<String> colors;

    @OneToMany(mappedBy = "candyboxEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemcandyboxEntity> itemCandyBoxEntities;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandyBoxEntity that = (CandyBoxEntity) o;

        if (id != that.id) return false;
        if (idCommande != null ? !idCommande.equals(that.idCommande) : that.idCommande != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idCommande != null ? idCommande.hashCode() : 0);
        return result;
    }
}
