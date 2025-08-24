package com.lalumen.backend.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    private Date workDate;

    private Time timeStart;

    private String logTitle;

    private String logDescription;

    private float productivityRating;

    private Date lastModifiedAt;

    private boolean isDeleted;

    private Date deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    @JsonIgnore
    private Account account;

    @ManyToMany
    @JoinTable(name = "workCategories", joinColumns = @JoinColumn(name = "workId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> workCategories = new ArrayList<>();

    public Work(Date workDate, Time timeStart, String logTitle, String logDescription, float productivityRating, Date lastModifiedAt, boolean isDeleted, Date deletedAt) {
        this.workDate = workDate;
        this.timeStart = timeStart;
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
}
