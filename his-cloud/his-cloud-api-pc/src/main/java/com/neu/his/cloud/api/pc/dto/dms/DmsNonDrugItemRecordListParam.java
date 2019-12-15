package com.neu.his.cloud.api.pc.dto.dms;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsNonDrugItemRecordListParam  implements Serializable {
    List<DmsNonDrugItemRecordParam> dmsNonDrugItemRecordParamList;

    Long registrationId;
    Long createStaffId;
    Integer type;


}
