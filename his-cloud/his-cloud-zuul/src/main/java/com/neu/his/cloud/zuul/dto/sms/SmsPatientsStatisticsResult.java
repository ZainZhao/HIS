package com.neu.his.cloud.zuul.dto.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class SmsPatientsStatisticsResult  implements Serializable {
    List<String> dateOfSevenDays;

    List<Long> numOfPatients;
}
