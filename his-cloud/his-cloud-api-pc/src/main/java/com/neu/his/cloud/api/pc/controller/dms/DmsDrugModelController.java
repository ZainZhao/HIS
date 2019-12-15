package com.neu.his.cloud.api.pc.controller.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugModelParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugModelResult;
import com.neu.his.cloud.api.pc.service.dms.DmsDrugModelService;
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

    @ApiOperation(value = "新增药品模版")
    @RequestMapping(value = "/createModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result) {
        return dmsDrugModelService.createModel(dmsDrugModelParam);

    }


    @ApiOperation(value = "删除药品模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
       return dmsDrugModelService.deleteModel(ids);

    }

    @ApiOperation(value = "更新药品模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsDrugModelParam dmsDrugModelParam, BindingResult result){
        return dmsDrugModelService.updateModel(modelId,dmsDrugModelParam);
    }

    @ApiOperation(value = "模糊查询药品模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDrugModelResult>> listModel(@RequestBody DmsDrugModelParam queryParam,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){

       return dmsDrugModelService.listModel(queryParam, pageSize, pageNum,isAdmin);

    }

}
