package com.neu.his.cloud.service.dms.controller;


import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.cloud.service.dms.dto.dms.DmsCaseModelListResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsCaseModelOrCatalogParam;
import com.neu.his.cloud.service.dms.model.DmsCaseModel;
import com.neu.his.cloud.service.dms.service.DmsCaseModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsCaseModelController", description = "诊断目录管理")
@RequestMapping("/DmsCaseModel")
@CrossOrigin(allowCredentials = "true")
public class DmsCaseModelController {
    @Autowired
    DmsCaseModelService dmsCaseModelService;

    /**
     * 增加时需要传入{parentId，}
     * <p>author:赵煜
     */
    @ApiOperation(value = "新增模板目录或模板")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult listModelCatTree(@RequestBody DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam, BindingResult result) {
        int count = dmsCaseModelService.createCatOrModel(dmsCaseModelOrCatalogParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    //合并个人、科室、全院的模板查询
    @ApiOperation(value = "显示模板目录树")
    @RequestMapping(value = "/listModelCatTree", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsCaseModelCatalogNode>> listModelCatTree(@RequestParam Long ownId, @RequestParam Integer scope) {
        List<DmsCaseModelCatalogNode> dmsCaseModelCatalogTree = dmsCaseModelService.listModelCatTree(ownId,scope);
            return CommonResult.success(dmsCaseModelCatalogTree);
    }



    @ApiOperation(value = "删除模版或目录")
    @RequestMapping(value = "/deleteModelOrCat", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("id") Long id){
        int count = dmsCaseModelService.deleteModelOrCat(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "更新模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsCaseModel dmsCaseModel, BindingResult result){
        int count = dmsCaseModelService.updateModel(modelId,dmsCaseModel);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "更新目录或模板的名字")
    @RequestMapping(value = "/updateModel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateName(@PathVariable("id") Long id, @RequestParam("name")String name){
        int count = dmsCaseModelService.updateName(id,name);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "根据模板id获取模板详细信息")
    @RequestMapping(value = "/getModelDetail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseModel> getModelDetail(@PathVariable("id") Long id){
        DmsCaseModel dmsCaseModel = dmsCaseModelService.getModelDetail(id);
        if(null!=dmsCaseModel){
            return CommonResult.success(dmsCaseModel);
        }else{
            return CommonResult.failed("获取模板详细信息失败");
        }
    }

    @ApiOperation(value = "根据staffId获取所有病历模板")
    @RequestMapping(value = "/getAllStaffModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseModelListResult> getAllStaffModel(@RequestParam("staffId") Long staffId){
        return CommonResult.success(dmsCaseModelService.getAllStaffModel(staffId));
    }
}
