package com.neu.his.cloud.zuul.controller.bms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.bms.ApiPcBmsSettlementCatDistributionService;
import com.neu.his.cloud.zuul.dto.bms.BmsSettlementCatParam;
import com.neu.his.cloud.zuul.dto.bms.BmsSettlementCatResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "BmsSettlementCatDistributionController", description = "结算类别管理")
@RequestMapping("/settleCat")
@CrossOrigin(allowCredentials = "true")
public class BmsSettlementCatDistributionController {

    @Autowired
    private ApiPcBmsSettlementCatDistributionService apiPcBmsSettlementCatDistributionService;


    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation("新增一个结算类别")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody BmsSettlementCatParam bmsSettlementCatParam , BindingResult result){
        return apiPcBmsSettlementCatDistributionService.create(bmsSettlementCatParam);
    }
    private CommonResult createFallbackInfo(BmsSettlementCatParam bmsSettlementCatParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation("根据ids删除结算类别")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        return apiPcBmsSettlementCatDistributionService.delete(ids);
    }
    private CommonResult deleteFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation("更新一个结算类别信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody BmsSettlementCatParam bmsSettlementCatParam , BindingResult result){
      return apiPcBmsSettlementCatDistributionService.update(id,bmsSettlementCatParam);
    }
    private CommonResult updateFallbackInfo(Long id,BmsSettlementCatParam bmsSettlementCatParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation("模糊查询结算类别、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<BmsSettlementCatResult>> list(BmsSettlementCatParam queryParam,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return apiPcBmsSettlementCatDistributionService.list(queryParam,pageSize,pageNum);
    }
    private CommonResult<CommonPage<BmsSettlementCatResult>> listFallbackInfo(BmsSettlementCatParam queryParam, Integer pageSize,Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation("查询所有结算类别")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsSettlementCatResult >> listAll(){
        return apiPcBmsSettlementCatDistributionService.listAll();
    }
    private CommonResult<List<BmsSettlementCatResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }


}
