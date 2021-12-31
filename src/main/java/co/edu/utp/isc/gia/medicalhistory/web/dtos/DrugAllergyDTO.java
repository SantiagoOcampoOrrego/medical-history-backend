package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class DrugAllergyDTO {
    private Long drugAllergyId;
    private String drugName;
}
