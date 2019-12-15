package com.neu.his.common.dto.dms;

import com.neu.his.mbg.model.DmsCaseHistory;
import io.swagger.annotations.ApiModelProperty;
import javafx.scene.chart.ValueAxis;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsCaseHistoryResult  implements Serializable {
    @ApiModelProperty(value = "历史病历列表")
    List<DmsCaseHistory> dmsCaseHistoryList;
}
