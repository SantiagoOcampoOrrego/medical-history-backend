package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class FamiliarDiseaseDTO implements Serializable {
    private Long familiarDiseaseId;
    private String diseaseName;
    private String relationship;
}
