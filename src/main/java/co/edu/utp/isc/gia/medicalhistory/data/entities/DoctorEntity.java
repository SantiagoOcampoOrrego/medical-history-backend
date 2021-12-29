package co.edu.utp.isc.gia.medicalhistory.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "DOCTOR")
public class DoctorEntity implements Serializable {

    @Id
    @Column(name = "ID_DOCTOR")
    private Long doctorId;

    @Column(name = "NOMBRE")
    private String firstName;

    @Column(name = "APELLIDO")
    private String lastName;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private String phoneNumber;

    @Column(name = "ESPECIALIDAD")
    private String specialty;

    @OneToMany(mappedBy = "doctorEntity", cascade = CascadeType.ALL)
    private List<ProcedureEntity> procedureEntity;

}
