package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugRedisParam;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugRedisParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsRedisSaveDistributionService {
    @RequestMapping(value = "/redisSave/saveCasePage", method = RequestMethod.POST)
    public CommonResult saveCasePage(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam,
                                     @RequestParam("registrationId") Long registrationId);

    @RequestMapping(value = "/redisSave/getCasePage", method = RequestMethod.POST)
    public CommonResult<DmsCaseHistoryParam> getCasePage(@RequestParam("registrationId") Long registrationId);


    @RequestMapping(value = "/redisSave/saveDrugPrescription", method = RequestMethod.POST)
    public CommonResult saveDrugPrescription(@RequestBody List<DmsDrugRedisParam> dmsDrugRedisParam,
                                             @RequestParam("registrationId") Long registrationId,
                                             @RequestParam("type") int type);

    @RequestMapping(value = "/redisSave/getDrugPrescription", method = RequestMethod.POST)
    public CommonResult<List<DmsDrugRedisParam>> getDrugPrescription(@RequestParam("registrationId") Long registrationId,
                                                                     @RequestParam("type") int type);


    @RequestMapping(value = "/redisSave/saveNonDrug", method = RequestMethod.POST)
    public CommonResult saveNonDrug(@RequestBody DmsNonDrugRedisParam dmsNonDrugRedisParam,
                                    @RequestParam("registrationId") Long registrationId,
                                    @RequestParam("type") int type);

    @RequestMapping(value = "/redisSave/getNonDrug", method = RequestMethod.POST)
    CommonResult<DmsNonDrugRedisParam> getNonDrug(@RequestParam("registrationId") Long registrationId,
                                                  @RequestParam("type") int type);
}
