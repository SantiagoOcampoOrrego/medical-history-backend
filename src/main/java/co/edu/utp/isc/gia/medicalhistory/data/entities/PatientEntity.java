package co.edu.utp.isc.gia.medicalhistory.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "PACIENTE")
public class PatientEntity implements Serializable {

    @Id
    @Column(name = "ID_PACIENTE")
    private Long patientId;

    @Column(name = "NOMBRE")
    private String firstName;

    @Column(name = "APELLIDO")
    private String lastName;

    @Column(name = "FECHA_NACIMIENTO")
    private Date birthDate;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private String phoneNumber;

    @Column(name = "SEXO")
    private String gender;

    @OneToOne(mappedBy = "patientEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MedicalHistoryEntity medicalHistoryEntity;

}
