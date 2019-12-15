package com.neu.his.cloud.api.pc.controller.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDosageResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugResult;
import com.neu.his.cloud.api.pc.service.dms.DmsDrugService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsDrugController", description = "药品管理")
@RequestMapping("/drug")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugController {

    @Autowired
    private DmsDrugService dmsDrugService;

    @ApiOperation("新增药品")
    @RequestMapping(value = "/createDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDrug(@RequestBody DmsDrugParam dmsDrugParam  , BindingResult result){
       return  dmsDrugService.createDrug(dmsDrugParam);
    }

    @ApiOperation("根据ids删除药品")
    @RequestMapping(value = "/deleteDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteDrug(@RequestParam("ids") List<Long> ids){
       return dmsDrugService.deleteDrug(ids);
    }

    @ApiOperation("更新药品信息")
    @RequestMapping(value = "/updateDrug/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDrug(@PathVariable Long id, @RequestBody DmsDrugParam dmsDrugParam , BindingResult result){
        return  dmsDrugService.updateDrug(id,dmsDrugParam);

    }

    @ApiOperation("模糊查询药品、且分页")
    @RequestMapping(value = "/selectDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugResult>> listDrug(@RequestBody DmsDrugParam queryParam,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

       return dmsDrugService.listDrug(queryParam,pageSize,pageNum);

    }
    @ApiOperation("查询所有药品")
    @RequestMapping(value = "/selectAllDrug", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDrugResult>> listAllDrug(){
        return dmsDrugService.listAllDrug();

    }

    @ApiOperation("查询所有药品剂型")
    @RequestMapping(value = "/selectAllDosage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDosageResult>> listAllDrugDosage(){
       return dmsDrugService.listAllDrugDosage();
    }


    @ApiOperation("根据id查询药品")
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsDrugResult> selectById(@RequestParam("id") Long id){

        return dmsDrugService.selectById(id);
    }

}
