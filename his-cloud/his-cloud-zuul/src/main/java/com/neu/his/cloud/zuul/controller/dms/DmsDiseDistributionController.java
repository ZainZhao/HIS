package com.neu.his.cloud.zuul.controller.dms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsDiseDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsDiseDistributionController", description = "诊断管理")
@RequestMapping("/DmsDise")
@CrossOrigin(allowCredentials = "true")
public class DmsDiseDistributionController {
    @Autowired
    private ApiPcDmsDiseDistributionService apiPcDmsDiseDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation(value = "新增诊断")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDiseParam dmsDiseParam , BindingResult result){
       return  apiPcDmsDiseDistributionService.create(dmsDiseParam);
    }
    private CommonResult createFallbackInfo(DmsDiseParam dmsDiseParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation(value = "根据ids删除诊断")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        return apiPcDmsDiseDistributionService.delete(ids);
    }
    private CommonResult deleteFallbackInfo( List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation(value = "更新诊断信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseParam dmsDiseParam , BindingResult result){
       return apiPcDmsDiseDistributionService.update(id,dmsDiseParam);
    }
    private CommonResult updateFallbackInfo(Long id, DmsDiseParam dmsDiseParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation(value = "模糊查询诊断、且分页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsDiseResult>> list( DmsDiseParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

       return  apiPcDmsDiseDistributionService.list(queryParam, pageSize, pageNum);
    }
    private CommonResult<CommonPage<DmsDiseResult>> listFallbackInfo(DmsDiseParam queryParam, Integer pageSize,Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation(value = "查询所有诊断")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseResult>> listAll(){
        return apiPcDmsDiseDistributionService.listAll();
    }
    private CommonResult<List<DmsDiseResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "parseListFallbackInfo")
    @ApiOperation(value = "根据id串获取诊断简单对象list")
    @RequestMapping(value = "/parseList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseResult>> parseList( @RequestParam(value = "idsStr") String idsStr){
        return apiPcDmsDiseDistributionService.parseList(idsStr);
    }
    private CommonResult<List<DmsDiseResult>> parseListFallbackInfo(String idsStr){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}
