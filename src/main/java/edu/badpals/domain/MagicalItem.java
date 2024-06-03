package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table (name = "t_items")
public class MagicalItem extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "item_id")
    private long id = 0L;

    @Column (name = "item_name")
    private String name = "";

    @Column (name = "item_quality")
    private Integer quality = 0;

    @Column (name = "item_type")
    private String type = "";

    public MagicalItem(String name, Integer quality, String type) {
        this.name = name;
        this.quality = quality;
        this.type = type;
    }

    public MagicalItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MagicalItem{" +
                "name='" + name + '\'' +
                ", quality=" + quality +
                ", type='" + type + '\'' +
                '}';
    }
}
