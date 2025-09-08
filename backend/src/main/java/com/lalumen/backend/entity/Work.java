package com.lalumen.backend.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    @Id
    @GeneratedValue
    private int workId;
    
    private LocalDate workDate;

    private LocalTime timeStart;

    private Duration duration;

    @Column(length = 150)
    private String logTitle;

    @Column(length = 1000)
    private String logDescription;

    private float productivityRating;

    private LocalDate lastModifiedAt;

    private boolean isDeleted;

    private LocalDate deletedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    @JsonIgnore
    private Account account;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "workCategories", joinColumns = @JoinColumn(name = "workId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    @JsonManagedReference
    private List<Category> workCategories = new ArrayList<>();

    public Work(LocalDate workDate, LocalTime timeStart, Duration duration, String logTitle, String logDescription, float productivityRating, LocalDate lastModifiedAt, boolean isDeleted, LocalDate deletedAt) {
        this.workDate = workDate;
        this.timeStart = timeStart;
        this.duration = duration;
        this.logTitle = logTitle;
        this.logDescription = logDescription;
        this.productivityRating = productivityRating;
        this.lastModifiedAt = lastModifiedAt;
        this.isDeleted = isDeleted;
        this.deletedAt = deletedAt;
    }

    public void addWorkCategory(Category category) {
        this.workCategories.add(category);
    }

    @PreRemove
    public void beforeDelete() {
        for(Category category : workCategories) {
            category.getWorks().remove(this);
        }
    }
}
