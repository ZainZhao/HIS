package com.neu.his.cloud.service.dms.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.service.dms.common.CommonPage;
import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsDosageResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugResult;
import com.neu.his.cloud.service.dms.service.DmsDrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsDrugController", description = "药品管理")
@RequestMapping("/drug")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugController {

    @Autowired
    private DmsDrugService dmsDrugService;

    /**
     * 描述:新增一个药品
     * <p>author: ma
     */
    @ApiOperation("新增一个药品")
    @RequestMapping(value = "/createDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDrug(@RequestBody DmsDrugParam dmsDrugParam  , BindingResult result){
        int count = dmsDrugService.createDrug(dmsDrugParam);
        if(count > 0){
            return CommonResult.success(count, "添加科室成功");
        }
        return CommonResult.failed("添加科室失败");
    }

    /**
     * 描述:根据ids删除药品
     * <p>author: ma
     */
    @ApiOperation("根据ids删除药品")
    @RequestMapping(value = "/deleteDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteDrug(@RequestParam("ids") List<Long> ids){
        int count = dmsDrugService.deleteDrug(ids);
        if(count > 0){
            return CommonResult.success(count,"删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    /**
     * 描述:更新一个药品的全部信息
     * <p>author: ma
     */
    @ApiOperation("更新一个药品的全部信息")
    @RequestMapping(value = "/updateDrug/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDrug(@PathVariable Long id, @RequestBody DmsDrugParam dmsDrugParam , BindingResult result){
        int count = dmsDrugService.updateDrug(id,dmsDrugParam);
        if(id > 0){
            return CommonResult.success(count,"更新成功");
        }
        return CommonResult.failed("更新失败");
    }

    /**
     * 描述:模糊查询药品、且分页
     * <p>author: ma
     */
    @ApiOperation("模糊查询药品、且分页")
    @RequestMapping(value = "/selectDrug", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugResult>> listDrug(@RequestBody DmsDrugParam queryParam,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page =PageHelper.startPage(pageNum, pageSize);
        List<DmsDrugResult> list = dmsDrugService.selectDrug(queryParam,pageSize,pageNum);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

    /**
     * 描述:查询所有药品
     * <p>author: ma
     */
    @ApiOperation("查询所有药品")
    @RequestMapping(value = "/selectAllDrug", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDrugResult>> listAllDrug(){
        List<DmsDrugResult> list = dmsDrugService.selectAllDrug();
        return CommonResult.success(list);
    }

    /**
     * 描述:查询所有药品剂型
     * <p>author: ma
     */
    @ApiOperation("查询所有药品剂型")
    @RequestMapping(value = "/selectAllDosage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDosageResult>> listAllDrugDosage(){
        List<DmsDosageResult> list = dmsDrugService.selectAllDosage();
        return CommonResult.success(list);
    }


    /**
     * 描述:根据id查询药品
     * <p>author: wang
     */
    @ApiOperation("根据id查询药品")
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsDrugResult> selectById(@RequestParam("id") Long id){
        DmsDrugResult dmsDrugResult = dmsDrugService.selectById(id);
        return CommonResult.success(dmsDrugResult);
    }

}
