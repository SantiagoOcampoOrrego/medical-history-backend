package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PatientDTO implements Serializable {
    private Long patientId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String phoneNumber;
    private String gender;
}
