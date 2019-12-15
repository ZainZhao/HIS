package com.neu.his.cloud.zuul.dto.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
public class SmsStaffAmountStatisticsResult  implements Serializable {
    List<String> amountCat;

    List<BigDecimal> amount;
}
