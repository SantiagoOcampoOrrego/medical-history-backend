package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProcedureTypeDTO implements Serializable {
    private Long typeId;
    private String typeName;
}
