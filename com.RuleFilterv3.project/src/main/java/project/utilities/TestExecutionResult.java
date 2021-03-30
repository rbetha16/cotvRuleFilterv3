package project.utilities;

public class TestExecutionResult {
	
	private String tcStatus;
	private String featureName;
	private String tagName;
	private String executionTime;
	private String tcName;
	private String reasonCode;	
	private String failureReason;
	private String releaseName;
	private String description;
	private String failureScreenshot;	
	
	public TestExecutionResult() 
	{
		
	}

	public TestExecutionResult( String arg_testcaseStatus, String arg_featureName,String arg_tagName,String arg_exetime,String arg_testscriptName,String arg_failureReason,String arg_reasonCode,String arg_releaseName,String arg_Description,String arg_flScreenshot) {
		
		this.tcName = arg_testscriptName;
		this.executionTime = arg_exetime;
		this.tcStatus = arg_testcaseStatus;		
		this.featureName = arg_featureName;
		this.failureReason = arg_failureReason;
		this.reasonCode = arg_reasonCode;		
		this.tagName = arg_tagName;	
		this.releaseName =  arg_releaseName;
		this.description  = arg_Description;
		this.failureScreenshot = arg_flScreenshot;
	
		//this.priority = arg_priority;
	}
	
	
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getTcName() {
		return tcName;
	}
	public void setTcName(String testscriptName) {
		this.tcName = testscriptName;
	}
	public String getTcStatus() {
		return tcStatus;
	}
	public void setTcStatus(String status) {
		this.tcStatus = status;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void  setDescription(String sDesc) {
		this.description = sDesc ;
	}

	public String getFailureScreenshot() {
		return failureScreenshot;
	}
	
	public void  setFailureScreenshot(String sScreenshot) {
		this.failureScreenshot = sScreenshot ;
	}

	/*public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}*/

	//public void setTestcaseStatus(String testcaseStatus) {
	//	this.tcStatus = testcaseStatus;
//	}
/*
	public String getFeatureNo() {
		return featureNo;
	}

	public void setFeatureNo(String featureNo) {
		this.featureNo = featureNo;
	}

	public String getUserstoryNo() {
		return userstoryNo;
	}

	public void setUserstoryNo(String userstoryNo) {
		this.userstoryNo = userstoryNo;
	}*/
/*
	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}*/

	public String getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}
}
