package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class DoctorDTO implements Serializable {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String specialty;
}
