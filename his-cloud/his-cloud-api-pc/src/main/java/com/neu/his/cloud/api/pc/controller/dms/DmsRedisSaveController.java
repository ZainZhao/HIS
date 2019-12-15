package com.neu.his.cloud.api.pc.controller.dms;



import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseHistoryParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugRedisParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugRedisParam;
import com.neu.his.cloud.api.pc.service.dms.DmsRedisSaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsRedisSaveController", description = "redis暂存管理")
@RequestMapping("/redisSave")
@CrossOrigin(allowCredentials = "true")
public class DmsRedisSaveController {

    @Autowired
    DmsRedisSaveService dmsRedisSaveService;
    @ApiOperation(value = "暂存病历首页（根据挂号号）")
    @RequestMapping(value = "/saveCasePage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveCasePage(@RequestBody DmsCaseHistoryParam dmsCaseHistoryParam,
                                     @RequestParam("registrationId") Long registrationId){

        return dmsRedisSaveService.saveCasePage(dmsCaseHistoryParam,registrationId);
    }

    @ApiOperation(value = "取出病历首页（根据挂号号）")
    @RequestMapping(value = "/getCasePage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<DmsCaseHistoryParam> getCasePage(@RequestParam("registrationId") Long registrationId){

        return dmsRedisSaveService.getCasePage(registrationId);
    }



    @ApiOperation(value = "暂存药方（根据挂号号和类型（4成药、5草药））")
    @RequestMapping(value = "/saveDrugPrescription", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveDrugPrescription(@RequestBody List<DmsDrugRedisParam> dmsDrugRedisParam,
                                             @RequestParam("registrationId") Long registrationId,
                                             @RequestParam("type") int type){

        return dmsRedisSaveService.saveDrugPrescription(dmsDrugRedisParam,registrationId,type);
    }

    @ApiOperation(value = "取出药方（根据挂号号和类型（4成药、5草药））")
    @RequestMapping(value = "/getDrugPrescription", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDrugRedisParam>> getDrugPrescription(@RequestParam("registrationId") Long registrationId,
                                                                     @RequestParam("type") int type){

        return dmsRedisSaveService.getDrugPrescription(registrationId,type);
    }


    @ApiOperation(value = "暂存开立非药品项目（根据挂号号和类型（0检查、1检验、2处置））")
    @RequestMapping(value = "/saveNonDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveNonDrug(@RequestBody DmsNonDrugRedisParam dmsNonDrugRedisParam,
                                    @RequestParam("registrationId") Long registrationId,
                                    @RequestParam("type") int type){

        return dmsRedisSaveService.saveNonDrug(dmsNonDrugRedisParam,registrationId,type);
    }

    @ApiOperation(value = "取出开立非药品项目（根据挂号号和类型（0检查、1检验、2处置））")
    @RequestMapping(value = "/getNonDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<DmsNonDrugRedisParam> getNonDrug(@RequestParam("registrationId") Long registrationId,
                                                         @RequestParam("type") int type){

        return dmsRedisSaveService.getNonDrug(registrationId,type);
    }
}
