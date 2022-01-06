package co.edu.utp.isc.gia.medicalhistory.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "ALERGIA_MEDICAMENTO")
public class DrugAllergyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALERGIA_ID")
    private Long drugAllergyId;

    @Column(name = "NOMBRE_MEDICAMENTO")
    private String drugName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_HISTORIA")
    private MedicalHistoryEntity medicalHistoryEntity;

}
