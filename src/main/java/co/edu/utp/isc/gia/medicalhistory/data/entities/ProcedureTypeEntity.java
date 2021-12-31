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
@Table(name = "TIPO_PROCEDIMIENTO")
public class ProcedureTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TIPO")
    private Long typeId;

    @Column(name = "NOMBRE_TIPO")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedureTypeEntity")
    private List<ProcedureEntity> procedureEntities;
}
