package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsCaseModelDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseModelListResult;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseModelOrCatalogParam;
import com.neu.his.cloud.zuul.model.DmsCaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsCaseModelDistributionController", description = "病历模板管理")
@RequestMapping("/DmsCaseModel")
@CrossOrigin(allowCredentials = "true")
public class DmsCaseModelDistributionController {
    @Autowired
    ApiPcDmsCaseModelDistributionService apiPcDmsCaseModelDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation(value = "新增病历模板目录或模板")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam, BindingResult result) {
        return apiPcDmsCaseModelDistributionService.create(dmsCaseModelOrCatalogParam);
    }
    private CommonResult createFallbackInfo(DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam, BindingResult result) {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listModelCatTreeFallbackInfo")
    @ApiOperation(value = "显示病历模板目录树")
    @RequestMapping(value = "/listModelCatTree", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsCaseModelCatalogNode>> listModelCatTree(@RequestParam Long ownId, @RequestParam Integer scope) {
        return apiPcDmsCaseModelDistributionService.listModelCatTree(ownId,scope);
    }
    private CommonResult<List<DmsCaseModelCatalogNode>> listModelCatTreeFallbackInfo(Long ownId, Integer scope) {
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteModelOrCatFallbackInfo")
    @ApiOperation(value = "删除病历模版或目录")
    @RequestMapping(value = "/deleteModelOrCat", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModelOrCat(@RequestParam("id") Long id){
       return apiPcDmsCaseModelDistributionService.deleteModelOrCat(id);
    }
    private CommonResult deleteModelOrCatFallbackInfo(Long id){
        return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "updateModelFallbackInfo")
    @ApiOperation(value = "更新病历模版信息")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsCaseModel dmsCaseModel, BindingResult result){
       return apiPcDmsCaseModelDistributionService.updateModel(modelId,dmsCaseModel);
    }
    private CommonResult updateModelFallbackInfo(Long modelId, DmsCaseModel dmsCaseModel, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateNameFallbackInfo")
    @ApiOperation(value = "更新目录或模板的名字")
    @RequestMapping(value = "/updateModel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateName(@PathVariable("id") Long id, @RequestParam("name")String name){
       return apiPcDmsCaseModelDistributionService.updateName(id,name);
    }
    private CommonResult updateNameFallbackInfo(Long id, String name){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getModelDetailFallbackInfo")
    @ApiOperation(value = "根据模板id查询模板详细信息")
    @RequestMapping(value = "/getModelDetail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseModel> getModelDetail(@PathVariable("id") Long id){
        return apiPcDmsCaseModelDistributionService.getModelDetail(id);
    }
    private CommonResult<DmsCaseModel> getModelDetailFallbackInfo(Long id){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "getAllStaffModelFallbackInfo")
    @ApiOperation(value = "根据staffId获取所有病历模板")
    @RequestMapping(value = "/getAllStaffModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseModelListResult> getAllStaffModel(@RequestParam("staffId") Long staffId){
        return apiPcDmsCaseModelDistributionService.getAllStaffModel(staffId);
    }
    private CommonResult<DmsCaseModelListResult> getAllStaffModelFallbackInfo(Long staffId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
