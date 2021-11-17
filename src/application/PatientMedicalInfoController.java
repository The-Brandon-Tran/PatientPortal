package application;

import java.io.IOException;

import JavaCode.Patient;
import JavaCode.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class PatientMedicalInfoController {
	
	@FXML // fx:id="tfPatientName"
	private TextField tfPatientName;
	
	@FXML // fx:id="tfVisitDate"
	private TextField tfVisitDate;

	@FXML // fx:id="tfWeight"
	private TextField tfWeight;

	@FXML // fx:id="tfHeight"
	private TextField tfHeight;
	
	@FXML // fx:id="tfBodyTemperature"
	private TextField tfBodyTemperature;
	
	@FXML // fx:id="tfBloodPressure"
	private TextField tfBloodPressure;
	
	@FXML // fx:id="tfKnownAllergies"
	private TextField tfKnownAllergies;
	
	@FXML // fx:id="tfHealthConcerns"
	private TextField tfHealthConcerns;
	
	@FXML // fx:id="tfPhysicalTest"
	private TextField tfPhysicalTest;
	
	@FXML // fx:id="tfAssignedDoctor"
	private TextField tfAssignedDoctor;
	
	@FXML // fx:id="tfAssignedNurse"
	private TextField tfAssignedNurse;
	
	@FXML // fx:id="tfHealthIssues"
	private TextField tfHealthIssues;
	
	@FXML // fx:id="tfPatientMedication"
	private TextField tfPatientMedication;
	
	@FXML // fx:id="tfImmunizationHistory"
	private TextField tfImmunizationHistory;
	
	@FXML // fx:id="buttonUpdateInfo"
	private Button buttonUpdateInfo;
	
	@FXML
    private void switchToHomePage(ActionEvent event) throws IOException {
		event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        
        // Sets information into Patient Class
        String[] name = tfPatientName.getText().split("\\s+");
        String visit = tfVisitDate.getText();
        String weight = tfWeight.getText();
    	String height = tfHeight.getText();
    	String temperature = tfBodyTemperature.getText();
    	String bloodPressure = tfBloodPressure.getText();
    	String allergies = tfKnownAllergies.getText();
    	String healthConcerns = tfHealthConcerns.getText();
    	String physicalTest = tfPhysicalTest.getText();
    	String[] doc = tfAssignedDoctor.getText().split("\\s+");
    	String[] nurse = tfAssignedNurse.getText().split("\\s+");
    	String healthIssues = tfHealthIssues.getText();
    	String immunizationHistory = tfImmunizationHistory.getText();
    	
    	Patient a = Storage.searchPatient(name[0], name[1]);
    	
    	a.setWeight(weight);
    	a.setHeight(height);
    	a.setTemp(temperature);
    	a.setBloodPres(bloodPressure);
    	a.setAllergies(allergies);
    	a.setHealthConcerns(healthConcerns);
    	a.setPhysicalTestResults(physicalTest);
    	a.setDoctor(Storage.searchDoc(doc[0], doc[1]));
    	a.setNurse(Storage.searchNurse(nurse[0], nurse[1]));
    	a.setHealthConcerns(healthConcerns);
    	a.setImmunizationRecord(immunizationHistory);
    	
        switch(Storage.getCurrentUser().getRole()) {
        case "Doctor":
        	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../DoctorHomePage.fxml")));
        	break;
        case "Nurse":
        	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../NurseHomePage.fxml")));
        	break;
        case "Patient":
        	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../PatientHomePage.fxml")));
        	break;
        default: break; // Should never get here
        }
	}
	
	
}
