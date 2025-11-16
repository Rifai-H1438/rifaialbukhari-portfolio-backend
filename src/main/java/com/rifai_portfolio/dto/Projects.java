package com.rifai_portfolio.dto;

public class Projects {

    private String workSampleTitle;
    private String workSampleURL;
    private String workSampleCodeURL; // GitHub URL
    private String usedTools;
    private String workSampleDescription;
    private String projectImage;
    private String projectStatus; // "completed" or "in develop"

    // Getters and Setters
    public String getWorkSampleTitle() {
        return workSampleTitle;
    }

    public void setWorkSampleTitle(String workSampleTitle) {
        this.workSampleTitle = workSampleTitle;
    }

    public String getWorkSampleURL() {
        return workSampleURL;
    }

    public void setWorkSampleURL(String workSampleURL) {
        this.workSampleURL = workSampleURL;
    }

    public String getWorkSampleCodeURL() {
        return workSampleCodeURL;
    }

    public void setWorkSampleCodeURL(String workSampleCodeURL) {
        this.workSampleCodeURL = workSampleCodeURL;
    }

    public String getUsedTools() {
        return usedTools;
    }

    public void setUsedTools(String usedTools) {
        this.usedTools = usedTools;
    }

    public String getWorkSampleDescription() {
        return workSampleDescription;
    }

    public void setWorkSampleDescription(String workSampleDescription) {
        this.workSampleDescription = workSampleDescription;
    }

    public String getProjectImage() {
        return projectImage;
    }
    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

}
