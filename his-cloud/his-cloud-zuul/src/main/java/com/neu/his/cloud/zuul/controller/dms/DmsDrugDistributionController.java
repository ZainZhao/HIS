package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsDrugDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsDosageResult;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsDrugDistributionController", description = "药品管理")
@RequestMapping("/drug")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugDistributionController {

    @Autowired
    private ApiPcDmsDrugDistributionService apiPcDmsDrugDistributionService;

    @HystrixCommand(fallbackMethod = "createDrugFallbackInfo")
    @ApiOperation("新增药品")
    @RequestMapping(value = "/createDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDrug(@RequestBody DmsDrugParam dmsDrugParam  , BindingResult result){
       return  apiPcDmsDrugDistributionService.createDrug(dmsDrugParam);
    }
    private CommonResult createDrugFallbackInfo(DmsDrugParam dmsDrugParam  , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteDrugFallbackInfo")
    @ApiOperation("根据ids删除药品")
    @RequestMapping(value = "/deleteDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteDrug(@RequestParam("ids") List<Long> ids){
       return apiPcDmsDrugDistributionService.deleteDrug(ids);
    }
    private CommonResult deleteDrugFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateDrugFallbackInfo")
    @ApiOperation("更新药品信息")
    @RequestMapping(value = "/updateDrug/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDrug(@PathVariable Long id, @RequestBody DmsDrugParam dmsDrugParam , BindingResult result){
        return  apiPcDmsDrugDistributionService.updateDrug(id,dmsDrugParam);
    }
    private CommonResult updateDrugFallbackInfo(Long id, DmsDrugParam dmsDrugParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listDrugFallbackInfo")
    @ApiOperation("模糊查询药品、且分页")
    @RequestMapping(value = "/selectDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugResult>> listDrug(DmsDrugParam queryParam,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

       return apiPcDmsDrugDistributionService.listDrug(queryParam,pageSize,pageNum);
    }
    private CommonResult<CommonPage<DmsDrugResult>> listDrugFallbackInfo(DmsDrugParam queryParam, Integer pageSize,Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

//    @HystrixCommand(fallbackMethod = "listAllDrugFallbackInfo")
    @ApiOperation("查询所有药品")
    @RequestMapping(value = "/selectAllDrug", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDrugResult>> listAllDrug(){
        return apiPcDmsDrugDistributionService.listAllDrug();
    }
    private CommonResult<List<DmsDrugResult>> listAllDrugFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllDrugDosageFallbackInfo")
    @ApiOperation("查询所有药品剂型")
    @RequestMapping(value = "/selectAllDosage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDosageResult>> listAllDrugDosage(){
       return apiPcDmsDrugDistributionService.listAllDrugDosage();
    }
    private CommonResult<List<DmsDosageResult>> listAllDrugDosageFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    /**
     * 描述:根据id查询药品
     * <p>author: wang
     */
    @ApiOperation("根据id查询药品")
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsDrugResult> selectById(@RequestParam("id") Long id){
        return apiPcDmsDrugDistributionService.selectById(id);
    }

}
