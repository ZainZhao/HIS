package com.neu.his.cloud.service.dms.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.service.dms.common.CommonPage;
import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugModelParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugModelResult;
import com.neu.his.cloud.service.dms.service.DmsDrugModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *药品模版
 */

@RestController
@Api(tags = "DmsDrugModelController", description = "药品模板管理")
@RequestMapping("/drugModel")
@CrossOrigin(allowCredentials = "true")
public class DmsDrugModelController {

    @Autowired
    DmsDrugModelService dmsDrugModelService;

    @ApiOperation(value = "创建模版")
    @RequestMapping(value = "/createModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result) {
        int count = dmsDrugModelService.createModel(dmsDrugModelParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "删除模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
        int count = dmsDrugModelService.deleteModel(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
//
//    @ApiOperation(value = "删除模版项")
//    @RequestMapping(value = "/deleteModelItem", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult deleteModelItem( @RequestParam("modelId")Long modelId, @RequestParam("ids") List<Long> itemIds){
//        int count = dmsNonDrugModelService.deleteModelItem(modelId,itemIds);
//        if (count >= 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
    @ApiOperation(value = "更新模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result){
        int count = dmsDrugModelService.updateModel(modelId,dmsDrugModelParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "模糊查询模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugModelResult>> list(@RequestBody DmsDrugModelParam queryParam,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<DmsDrugModelResult>  list = dmsDrugModelService.selectModel(isAdmin,queryParam, pageSize, pageNum);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }
}
