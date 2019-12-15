package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsDrugModelDistributionService;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsNonDrugModelDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugModelParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugModelResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *药品模版
 */
@RestController
@Api(tags = "DmsDrugModelDistributionController", description = "药品模板管理")
@RequestMapping("/drugModel")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugModelDistributionController {

    @Autowired
    ApiPcDmsDrugModelDistributionService apiPcDmsDrugModelDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation(value = "新增药品模版")
    @RequestMapping(value = "/createModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result) {
        return apiPcDmsDrugModelDistributionService.createModel(dmsDrugModelParam);
    }
    private CommonResult createFallbackInfo(DmsDrugModelParam dmsDrugModelParam, BindingResult result) {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteModelFallbackInfo")
    @ApiOperation(value = "删除药品模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
       return apiPcDmsDrugModelDistributionService.deleteModel(ids);
    }
    public CommonResult deleteModelFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateModelFallbackInfo")
    @ApiOperation(value = "更新药品模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result){
        return apiPcDmsDrugModelDistributionService.updateModel(modelId,dmsDrugModelParam);
    }
    private CommonResult updateModelFallbackInfo(Long modelId,DmsDrugModelParam dmsDrugModelParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listModelFallbackInfo")
    @ApiOperation(value = "模糊查询药品模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugModelResult>> listModel(DmsDrugModelParam queryParam,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){
       return apiPcDmsDrugModelDistributionService.listModel(queryParam, pageSize, pageNum,isAdmin);
    }
    public CommonResult<CommonPage<DmsDrugModelResult>> listModelFallbackInfo(DmsDrugModelParam queryParam,Integer pageSize, Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){
        return CommonResult.success(null,"请检查您的网络") ;
    }


}
