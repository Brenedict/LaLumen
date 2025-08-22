package com.lalumen.backend.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    private Account account;

    public Work(Date workDate, Time timeStart, String logTitle, String logDescription, float productivityRating, Date lastModifiedAt, boolean isDeleted, Date deletedAt, Account account) {
        this.workDate = workDate;
        this.timeStart = timeStart;
        this.logTitle = logTitle;
        this.logDescription = logDescription;
        this.productivityRating = productivityRating;
        this.lastModifiedAt = lastModifiedAt;
        this.isDeleted = isDeleted;
        this.deletedAt = deletedAt;
        this.account = account;
    }
}
