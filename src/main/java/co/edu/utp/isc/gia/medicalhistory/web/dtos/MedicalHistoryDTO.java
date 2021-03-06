package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MedicalHistoryDTO implements Serializable {
    private Long historyId;
    private Long patientId;
    private String currentMedication;
    private boolean doExercise;
    private boolean alcoholConsumption;
    private boolean smoker;
    private double weight;
    private double height;
    private String additionalComment;
}
