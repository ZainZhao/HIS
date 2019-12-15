package com.neu.his.cloud.zuul.controller.dms;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.distribution.api.pc.dms.ApiPcDmsNonDrugDistributionService;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugParam;
import com.neu.his.cloud.zuul.dto.dms.DmsNonDrugResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsNonDrugDistributionController", description = "非药品项目管理")
@RequestMapping("/DmsNonDrug")
@CrossOrigin(allowCredentials = "true")
public class DmsNonDrugDistributionController {
    @Autowired
    ApiPcDmsNonDrugDistributionService apiPcDmsNonDrugDistributionService;

    @HystrixCommand(fallbackMethod = "createFallbackInfo")
    @ApiOperation(value = "新增非药品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsNonDrugParam dmsNonDrugParam , BindingResult result){
        return apiPcDmsNonDrugDistributionService.create(dmsNonDrugParam);
    }
    private CommonResult createFallbackInfo( DmsNonDrugParam dmsNonDrugParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "deleteFallbackInfo")
    @ApiOperation(value = "根据ids删除非药品")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
      return apiPcDmsNonDrugDistributionService.delete(ids);
    }
    private CommonResult deleteFallbackInfo(List<Long> ids){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "updateFallbackInfo")
    @ApiOperation(value = "更新非药品信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsNonDrugParam dmsNonDrugParam , BindingResult result){
       return apiPcDmsNonDrugDistributionService.update(id,dmsNonDrugParam);
    }
    private CommonResult updateFallbackInfo(Long id,  DmsNonDrugParam dmsNonDrugParam , BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listFallbackInfo")
    @ApiOperation(value = "模糊查询非药品、且分页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsNonDrugResult>> list(DmsNonDrugParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return  apiPcDmsNonDrugDistributionService.list(queryParam,pageSize,pageNum);
    }
    private CommonResult<CommonPage<DmsNonDrugResult>> listFallbackInfo(DmsNonDrugParam queryParam, Integer pageSize, Integer pageNum){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllFallbackInfo")
    @ApiOperation(value = "查询所有非药品")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsNonDrugResult>> listAll(){
        return apiPcDmsNonDrugDistributionService.listAll();
    }
    private CommonResult<List<DmsNonDrugResult>> listAllFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络") ;
    }
}
