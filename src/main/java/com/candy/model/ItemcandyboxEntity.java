package com.candy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "itemcandybox", schema = "candy", catalog = "")
public class ItemcandyboxEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idCandybox")
    private Integer idCandybox;
    @Basic
    @Column(name = "idCouleur")
    private Integer idCouleur;
    @Basic
    @Column(name = "quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "idcandybox", referencedColumnName = "id")
    private CandyBoxEntity candyboxEntity;

    @ManyToOne
    @JoinColumn(name = "idcouleur", referencedColumnName = "id")
    private CouleurEntity couleurEntity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemcandyboxEntity that = (ItemcandyboxEntity) o;

        if (id != that.id) return false;
        if (quantite != that.quantite) return false;
        if (idCandybox != null ? !idCandybox.equals(that.idCandybox) : that.idCandybox != null) return false;
        if (idCouleur != null ? !idCouleur.equals(that.idCouleur) : that.idCouleur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idCandybox != null ? idCandybox.hashCode() : 0);
        result = 31 * result + (idCouleur != null ? idCouleur.hashCode() : 0);
        result = 31 * result + quantite;
        return result;
    }
}
