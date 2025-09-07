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

function WorkEntry(
    {   workDate, timeStart, duration, 
        logTitle, logDescription, productivityRating, 
        lastModifiedAt, workCategories}: WorkEntryProps
    ) {
    return (
        <div className={styles.entryContainer}>
            <h4 className={styles.entryDateDetails}>{workDate} at {timeStart} {workDate === lastModifiedAt ? "" : "  |  Updated:" + lastModifiedAt}</h4>
            <h2 className={styles.entryTitle}>{logTitle}</h2>
            <p>{logDescription}</p>

            <div className={styles.entrySecondaryDetailsContainer}>
                <div className={styles.entryDurationContainer}>
                    <p>Duration</p>
                    <h3>{duration}</h3>
                </div>
                <div className={styles.entryProductivityContainer}>
                    <p>Productivity</p>
                    <h3>{productivityRating}/10</h3>
                </div>
                <div className={styles.entryGradeContainer}>
                    <p>Relative</p>
                    <h3>temp</h3>
                </div>
            </div>

            <hr />
            <p id={styles.workCategoriesText}>Work Categories:</p>
            <div className={styles.workCategoriesContainer}>
                {workCategories.map((category) => (
                    <p>{category.categoryName}</p>
                ))}
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