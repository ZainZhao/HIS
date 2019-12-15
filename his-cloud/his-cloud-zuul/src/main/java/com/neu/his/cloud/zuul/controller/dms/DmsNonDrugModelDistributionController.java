package com.neu.his.cloud.zuul.controller.dms;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsNonDrugModelDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugModelParam;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugModelResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsNonDrugModelDistributionController", description = "非药品模版管理")
@RequestMapping("/NonDrugModel")
@CrossOrigin(allowCredentials = "true")
public class DmsNonDrugModelDistributionController {

    @Autowired
    ApiPcDmsNonDrugModelDistributionService apiPcDmsNonDrugModelDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation(value = "新增非药品模版")
    @RequestMapping(value = "/createModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result) {
      return apiPcDmsNonDrugModelDistributionService.create(dmsNonDrugModelParam);
    }
    private CommonResult createFallbackInfo(DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result) {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteModelFallbackInfo")
    @ApiOperation(value = "删除非药品模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
       return apiPcDmsNonDrugModelDistributionService.deleteModel(ids);
    }
    private CommonResult deleteModelFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteModelItemFallbackInfo")
    @ApiOperation(value = "删除非药品模版项")
    @RequestMapping(value = "/deleteModelItem", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModelItem(@RequestParam("modelId")Long modelId, @RequestParam("ids") List<Long> itemIds){
        return apiPcDmsNonDrugModelDistributionService.deleteModelItem(modelId,itemIds);
    }
    private CommonResult deleteModelItemFallbackInfo(Long modelId, List<Long> itemIds){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateModelFallbackInfo")
    @ApiOperation(value = "更新非药品模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result){
        return apiPcDmsNonDrugModelDistributionService.updateModel(modelId,dmsNonDrugModelParam);
    }
    private CommonResult updateModelFallbackInfo(Long modelId,  DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation(value = "模糊查询非药品模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsNonDrugModelResult>> list(DmsNonDrugModelParam queryParam,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){

        return apiPcDmsNonDrugModelDistributionService.list(queryParam, pageSize, pageNum,isAdmin);
    }
    private CommonResult<CommonPage<DmsNonDrugModelResult>> listFallbackInfo(DmsNonDrugModelParam queryParam,
                                                                Integer pageSize,
                                                                Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){
        return CommonResult.success(null,"请检查您的网络") ;
    }


}