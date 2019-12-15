package com.neu.his.cloud.service.sms.dto.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
public class SmsDeptAmountStatisticsResult  implements Serializable {
    List<String> dateOfSevenDays;

    List<String> amountCat;

    List<BigDecimal> medicineAmount;

    List<BigDecimal> herbalAmount;

    List<BigDecimal> checkAmount;

    List<BigDecimal> testAmount;

    List<BigDecimal> dispositionAmount;

    List<BigDecimal> executedAmount;
}
