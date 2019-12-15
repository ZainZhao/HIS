package com.neu.his.cloud.api.pc.service.dms;


import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseHistoryParam;

import com.neu.his.cloud.api.pc.dto.dms.DmsDrugRedisParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugRedisParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsRedisSaveService {

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