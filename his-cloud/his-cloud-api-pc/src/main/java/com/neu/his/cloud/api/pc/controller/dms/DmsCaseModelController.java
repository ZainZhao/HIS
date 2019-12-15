package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseModelListResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseModelOrCatalogParam;
import com.neu.his.cloud.api.pc.model.DmsCaseModel;
import com.neu.his.cloud.api.pc.service.dms.DmsCaseModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsCaseModelController", description = "病历模板管理")
@RequestMapping("/DmsCaseModel")
@CrossOrigin(allowCredentials = "true")
public class DmsCaseModelController {
    @Autowired
    DmsCaseModelService dmsCaseModelService;


    @ApiOperation(value = "新增病历模板目录或模板")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam, BindingResult result) {
        return dmsCaseModelService.createCatOrModel(dmsCaseModelOrCatalogParam);
    }

    @ApiOperation(value = "显示病历模板目录树")
    @RequestMapping(value = "/listModelCatTree", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsCaseModelCatalogNode>> listModelCatTree(@RequestParam Long ownId, @RequestParam Integer scope) {
        return dmsCaseModelService.listModelCatTree(ownId,scope);
    }

    @ApiOperation(value = "删除病历模版或目录")
    @RequestMapping(value = "/deleteModelOrCat", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("id") Long id){
       return dmsCaseModelService.deleteModelOrCat(id);

    }


    @ApiOperation(value = "更新病历模版信息")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsCaseModel dmsCaseModel, BindingResult result){
       return dmsCaseModelService.updateModel(modelId,dmsCaseModel);
    }


    @ApiOperation(value = "更新目录或模板的名字")
    @RequestMapping(value = "/updateModel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateName(@PathVariable("id") Long id, @RequestParam("name")String name){
       return dmsCaseModelService.updateName(id,name);
    }


    @ApiOperation(value = "根据模板id查询模板详细信息")
    @RequestMapping(value = "/getModelDetail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseModel> getModelDetail(@PathVariable("id") Long id){
        return dmsCaseModelService.getModelDetail(id);
    }

    @ApiOperation(value = "根据staffId获取所有病历模板")
    @RequestMapping(value = "/getAllStaffModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsCaseModelListResult> getAllStaffModel(@RequestParam("staffId") Long staffId){
        return dmsCaseModelService.getAllStaffModel(staffId);
    }

}
