package com.lalumen.backend.entity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lalumen.backend.entity.Account;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private int categoryId;

    private String categoryName;

    private String categoryColor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    @JsonIgnore
    private Account account;

    @ManyToMany(mappedBy = "workCategories")
    @JsonBackReference
    private List<Work> works = new ArrayList<>();

    // Add account constructor

    public Category(String categoryName, String categoryColor) {
        this.categoryName = categoryName;
        this.categoryColor = categoryColor;
    }

    @PreRemove
    public void beforeDelete() {
        for(Work work : works) {
            Logger logger = LoggerFactory.getLogger(this.getClass()); 
            logger.info(categoryName);
            work.getWorkCategories().remove(this);
        }
    }
}
