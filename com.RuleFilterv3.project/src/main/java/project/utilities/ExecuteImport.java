package project.utilities;




public class ExecuteImport {

	public static MongoDBUtils mngUtils = MongoDBUtils.getInstance();
	
	public static String filePath = null;
	public static String releaseStr = null;
	
	/*public static void main(String[] args) throws IOException {

		String projectName = "CPT_ICD_Links";
		String executionResultsFileName = "CPTICDLinks_Test_Execution.json";
		String priority = "1";
		
		//create the Master Test Plan
		//importMasterTestPlan(projectName);
		
		//create the Test Lab for the project
		//createTestLab(projectName, priority);
		
		//update the Test results for a project
		updateTestResults(projectName, executionResultsFileName);
	}*/
	
	/*public static boolean importMasterTestPlan(String projectName) {
		boolean flag = false;		
		
		switch (projectName) {
		case "Client_Profile":
			// filePath = "CP_Master_Test_Plan.json";
			filePath = "CP_Master_Test_Plan.csv";
			releaseStr = "April 2019";
			break;
		case "CPT_ICD_Links":
			// filePath = "CPT_ICD_Links_Master_Test_Plan.json";
			//filePath = "CPT_ICD_Links_Master_Test_Plan.csv";
			filePath = "CPTICDLinks_TestPlan.csv";
			releaseStr = "April 2019";
			break;
		default:
			System.out.println("Incorrect project name");
		}		
		
		try {
			// for json file format
			// mngUtils.createMasterTestPlan(filePath, "CPT_ICD_Links");

			// for csv file format
			mngUtils.importTestResultsWithPOJO(filePath, projectName);
		} catch (IOException e) {
			System.out.println("Error while importing the csv file");
			e.printStackTrace();
		}
				
		return flag;
	}*/
	
	public static boolean createTestLab(String projectName, String priority) {
		releaseStr = "April 2019 Software Release";
		return mngUtils.createTestLab(projectName, releaseStr, priority);
	}
	
	public static void updateTestResults(String projectName, String fileName) {
		if (mngUtils.importTestResultsWithJson(fileName)) {
			mngUtils.updateTestResults(projectName);
		}		
	}
}
