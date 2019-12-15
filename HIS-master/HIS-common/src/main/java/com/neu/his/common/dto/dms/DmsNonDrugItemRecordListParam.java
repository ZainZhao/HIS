package com.neu.his.common.dto.dms;


import com.neu.his.mbg.model.DmsNonDrugItemRecord;
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
