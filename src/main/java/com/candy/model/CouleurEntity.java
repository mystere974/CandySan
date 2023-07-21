package com.candy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "couleur", schema = "candy", catalog = "")
public class CouleurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "couleur")
    private String couleur;

    public static final List<String> COULEURS = Arrays.asList(
            "rouge", "bleu", "vert", "jaune", "rose", "orange", "violet", "blanc", "noir", "argent",
            "cyan"
    );

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouleurEntity that = (CouleurEntity) o;

        if (id != that.id) return false;
        if (couleur != null ? !couleur.equals(that.couleur) : that.couleur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (couleur != null ? couleur.hashCode() : 0);
        return result;
    }
}
