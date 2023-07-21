package com.candy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candytag", schema = "candy", catalog = "")
public class CandyTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "candytag")
    private String candytag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandytag() {
        return candytag;
    }

    public void setCandytag(String candytag) {
        this.candytag = candytag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandyTagEntity that = (CandyTagEntity) o;

        if (id != that.id) return false;
        if (candytag != null ? !candytag.equals(that.candytag) : that.candytag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (candytag != null ? candytag.hashCode() : 0);
        return result;
    }
}
