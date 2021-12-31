package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MedicalHistoryDTO implements Serializable {
    private Long historyId;
    private Long patientId;
    private String drugAllergies;
    private String operations;
    private String currentMedications;
    private boolean doExercise;
    private boolean alcoholConsumption;
    private boolean smoker;
    private double weight;
    private double height;
    private String additionalComment;
}
