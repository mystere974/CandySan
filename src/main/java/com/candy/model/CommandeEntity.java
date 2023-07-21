package com.candy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "commande", schema = "candy", catalog = "")
public class CommandeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idUtilisateur")
    private Integer idUtilisateur;
    @Basic
    @Column(name = "idCandytag")
    private Integer idCandytag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdCandytag() {
        return idCandytag;
    }

    public void setIdCandytag(Integer idCandytag) {
        this.idCandytag = idCandytag;
    }

    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "id")
    private UtilisateurEntity utilisateurEntity;

    @ManyToOne
    @JoinColumn(name = "idcandytag", referencedColumnName = "id")
    private CandyTagEntity candytagEntity;

    private int quantity;

    @OneToMany(mappedBy = "commandeEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandyBoxEntity> candyBoxEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandeEntity that = (CommandeEntity) o;

        if (id != that.id) return false;
        if (idUtilisateur != null ? !idUtilisateur.equals(that.idUtilisateur) : that.idUtilisateur != null)
            return false;
        if (idCandytag != null ? !idCandytag.equals(that.idCandytag) : that.idCandytag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        result = 31 * result + (idCandytag != null ? idCandytag.hashCode() : 0);
        return result;
    }
}
