import styles from "../styles/Records.module.css"

import { useState, useContext } from "react";

import { WorkContext, useWorkContext } from "../contexts/WorkContextProvider";
import { type WorkCategoryInterface} from "../services/recordService";

type WorkEntryProps = {
    workDate: string,
    timeStart: string,
    duration: string,
    logTitle: string,
    logDescription: string,
    productivityRating: number,
    lastModifiedAt: string,
    workCategories: WorkCategoryInterface[]
}

function parseDate(date: string) {
  return new Date(date).toLocaleDateString("en-US", {
    year: "numeric",
    month: "long",
    day: "numeric",
  });
}

function parseTime(time: string) {
  return new Date(`1970-01-01T${time}`).toLocaleTimeString("en-US", {
    hour: "numeric",
    minute: "2-digit",
  });
}

function parseDuration(duration: string) {
    let durationFormat = duration.split("PT");

    return durationFormat;
}

function WorkEntry(
    {   workDate, timeStart, duration, 
        logTitle, logDescription, productivityRating, 
        lastModifiedAt, workCategories}: WorkEntryProps
    ) {

    return (
        <div className={styles.entryContainer}>
            <div className={styles.entryPrimaryDetailsContainer}>
                <h4 className={styles.entryDateDetails}>{parseDate(workDate)} at {parseTime(timeStart)} {workDate === lastModifiedAt ? "" : "  |  Updated: " + parseDate(lastModifiedAt)}</h4>
                <h2 className={styles.entryTitle}>{logTitle}</h2>
                <p>{logDescription}</p>
            </div>

            <div className={styles.entrySecondaryDetailsContainer}>
                <div className={styles.entryDurationContainer}>
                    <p>Duration</p>
                    <h3>{parseDuration(duration)}</h3>
                </div>
                <div className={styles.entryProductivityContainer}>
                    <p>Productivity</p>
                    <h3>{productivityRating}/10</h3>
                </div>
                <div className={styles.entryGradeContainer}>
                    <p>Relative</p>
                    <h3>Grade: 👍</h3>
                </div>
            </div>

            <hr />
            <div className={styles.workCategoriesContainer}>
                <p id={styles.workCategoriesText}>Work Categories:</p>
                <div className={styles.categoriesListingContainer}>
                    {workCategories.map((category) => (
                        <p style={{backgroundColor: category.categoryColor}}>{category.categoryName}</p>
                    ))}
                </div>
            </div>
        </div>
    )
}

function Records() { 
    const {accountWorkRecords, setAccountWorkRecords} = useWorkContext();

    return (
        <div className={styles.recordsContainer}>
            <h1>Study Records</h1>
            <div className={styles.recordsButtonsContainer}>
                <p>insert filter</p>
                <p>insert add record</p>
            </div>
            <div className={styles.recordsEntriesContainer}>
                {accountWorkRecords.length === 0 ? (
                    <p>Nothing to see here...</p>
                ) : (
                    accountWorkRecords.map((work, idx) => (
                        <WorkEntry 
                            workDate = {work.workDate} 
                            timeStart = {work.timeStart} 
                            duration = {work.duration} 
                            logTitle = {work.logTitle} 
                            logDescription = {work.logDescription} 
                            productivityRating = {work.productivityRating} 
                            lastModifiedAt = {work.lastModifiedAt} 
                            workCategories = {work.workCategories} 
                        />
                    ))
                )}
            </div>
        </div>
    );
}

export default Records;