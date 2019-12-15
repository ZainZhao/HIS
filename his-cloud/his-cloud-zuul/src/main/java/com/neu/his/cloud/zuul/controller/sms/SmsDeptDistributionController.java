package com.neu.his.cloud.zuul.controller.sms;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.sms.ApiPcSmsDeptDistributionService;
import com.neu.his.cloud.zuul.dto.sms.SmsDeptParam;
import com.neu.his.cloud.zuul.dto.sms.SmsDeptResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "SmsDeptDistributionController", description = "科室管理")
@RequestMapping("/dept")
@CrossOrigin(allowCredentials = "true")
public class SmsDeptDistributionController {

    @Autowired
    private ApiPcSmsDeptDistributionService apiPcSmsDeptDistributionService;


    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation("新增科室")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsDeptParam smsDeptParam, BindingResult result){
            return apiPcSmsDeptDistributionService.create(smsDeptParam);
    }
   private CommonResult createFallbackInfo( SmsDeptParam smsDeptParam, BindingResult result){
       return CommonResult.success(null,"请检查您的网络") ;
    }


    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation("根据ids删除科室")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        return   apiPcSmsDeptDistributionService.delete(ids);
    }
    private  CommonResult deleteFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }



    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation("更新科室信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody SmsDeptParam smsDeptParam, BindingResult result){
        return  apiPcSmsDeptDistributionService.update(id,smsDeptParam);
    }
    private CommonResult updateFallbackInfo( Long id, SmsDeptParam smsDeptParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }



    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation("模糊查询科室、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsDeptResult>> list(@RequestBody SmsDeptParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        return apiPcSmsDeptDistributionService.list(queryParam,pageSize,pageNum);
    }
   private CommonResult<CommonPage<SmsDeptResult>> listFallbackInfo(SmsDeptParam queryParam,Integer pageSize,Integer pageNum){
       return CommonResult.success(null,"请检查您的网络") ;
   }




    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation("查询所有科室")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsDeptResult>> listAll(){
        return  apiPcSmsDeptDistributionService.listAll();
    }
    private CommonResult<List<SmsDeptResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }


}
