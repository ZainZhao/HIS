package com.neu.his.cloud.zuul.controller.dms;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsDiseCatalogDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseCatalogParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseCatalogResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "DmsDiseCatalogDistributionController", description = "诊断目录管理")
@RequestMapping("/DmsDiseCatalog")
@CrossOrigin(allowCredentials = "true")
public class DmsDiseCatalogDistributionController {
    @Autowired
    ApiPcDmsDiseCatalogDistributionService apiPcDmsDiseCatalogDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation(value = "新增一个诊断目录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        return apiPcDmsDiseCatalogDistributionService.create(dmsDiseCatalogParam);
    }
    private CommonResult createFallbackInfo(DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation(value = "根据ids删除诊断目录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
       return apiPcDmsDiseCatalogDistributionService.delete(ids);
    }
    private CommonResult deleteFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation(value = "更新诊断目录信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        return apiPcDmsDiseCatalogDistributionService.update(id,dmsDiseCatalogParam);
    }
    private CommonResult updateFallbackInfo( Long id,  DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation(value = "查询所有诊断目录")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseCatalogResult>> listAll(){
        return apiPcDmsDiseCatalogDistributionService.listAll();
    }
    private CommonResult<List<DmsDiseCatalogResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
