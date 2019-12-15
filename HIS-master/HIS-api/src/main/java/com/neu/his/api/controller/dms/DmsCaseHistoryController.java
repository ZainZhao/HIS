package com.neu.his.api.controller.dms;

import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsCaseHistoryParam;
import com.neu.his.common.dto.dms.DmsCaseHistoryResult;
import com.neu.his.dms.service.DmsCaseHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "DmsCaseHistoryController", description = "病历管理")
@RequestMapping("/caseHistory")
@CrossOrigin(allowCredentials = "true")
public class DmsCaseHistoryController {
    @Autowired
    DmsCaseHistoryService dmsCaseHistoryService;

    //1.调用DmsCaseHistoryService的insertPriliminaryDise
    @ApiOperation(value = "提交初诊信息")
    @RequestMapping(value = "/submitPriliminaryDise", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitPriliminaryDise(DmsCaseHistoryParam dmsCaseHistoryParam){
        int returnResult = dmsCaseHistoryService.insertPriliminaryDise(dmsCaseHistoryParam);
        if (returnResult == 1){
            return CommonResult.success(returnResult);
        }
        else{
            return CommonResult.failed();
        }
    }
    //根据挂号id查询历史病历
    //1.调用DmsCaseHistoryService的selectCaseHistoryByReg
    @ApiOperation(value = "根据挂号Id查询未结束就诊的历史病历（只含有初诊信息）")
    @RequestMapping(value = "/selectNotEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseHistoryResult> selectNotEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId){
        DmsCaseHistoryResult dmsCaseHistoryResult = null;
        dmsCaseHistoryResult = dmsCaseHistoryService.selectCaseHistoryByReg(registrationId,1);

        if(dmsCaseHistoryResult.getDmsCaseHistoryList()==null || dmsCaseHistoryResult.getDmsCaseHistoryList().size()==0){
            dmsCaseHistoryResult=dmsCaseHistoryService.selectCaseHistoryByReg(registrationId,2);
        }
        return CommonResult.success(dmsCaseHistoryResult);

    }


    /**
     * 描述：根据挂号id查询已结束就诊的历史病历（病历首页显示各种串）
     * <p>author:赵煜
     */
    @ApiOperation(value = "根据挂号id查询已结束就诊的历史病历（病历首页显示各种串）")
    @RequestMapping(value = "/selectEndCaseHistoryByReg/{registrationId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseHistoryResult> selectEndCaseHistoryByReg(@PathVariable("registrationId") Long registrationId){
        DmsCaseHistoryResult dmsCaseHistoryResult = new DmsCaseHistoryResult();
        dmsCaseHistoryResult = dmsCaseHistoryService.selectCaseHistoryByReg(registrationId,3);
        return CommonResult.success(dmsCaseHistoryResult);
    }


    //门诊确诊
    //1.调用DmsCaseHistoryService的submitDefiniteDise
    @ApiOperation(value = "确诊")
    @RequestMapping(value = "/submitDefiniteDise", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitDefiniteDise(DmsCaseHistoryParam dmsCaseHistoryParam){
        int returnResult = dmsCaseHistoryService.submitDefiniteDise(dmsCaseHistoryParam);
        if (returnResult == 1){
            return CommonResult.success(returnResult);
        }
        else{
            return CommonResult.failed();
        }
    }
    //诊毕
    //1.调用DmsCaseHistoryService的endDiagnosis
    @ApiOperation(value = "诊毕")
    @RequestMapping(value = "/endDiagnosis", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult endDiagnosis(DmsCaseHistoryParam dmsCaseHistoryParam){
        int returnResult = dmsCaseHistoryService.endDiagnosis(dmsCaseHistoryParam);
        if (returnResult == 1){
            return CommonResult.success(returnResult);
        }
        else{
            return CommonResult.failed();
        }
    }
}
