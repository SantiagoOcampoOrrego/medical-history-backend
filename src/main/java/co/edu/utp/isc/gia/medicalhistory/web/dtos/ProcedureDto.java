package co.edu.utp.isc.gia.medicalhistory.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProcedureDto implements Serializable {
    private Long procedureId;
    private Long doctorId;
    private Long historyId;
    private Date procedureDate;
    private String diagnosis;
    private String treatment;
}
