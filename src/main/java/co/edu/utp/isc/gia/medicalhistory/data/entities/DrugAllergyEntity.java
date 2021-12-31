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
@Table(name = "ALERGIA_MEDICAMENTO")
public class DrugAllergyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALERGIA_ID")
    private Long drugAllergyId;

    @Column(name = "NOMBRE_MEDICAMENTO")
    private String drugName;

    @JoinTable(
            name = "REL_ALERGIA_MEDICAMENTOS_HISTORIA",
            joinColumns = @JoinColumn(name = "FK_ALERGIA_MEDICAMENTO"),
            inverseJoinColumns = @JoinColumn(name = "FK_HISTORIA_CLINICA")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<MedicalHistoryEntity> medicalHistoryEntityList;

}
