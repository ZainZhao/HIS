package com.neu.his.cloud.api.pc.controller.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugModelParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugModelResult;
import com.neu.his.cloud.api.pc.service.dms.DmsNonDrugModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsNonDrugModelController", description = "非药品模版管理")
@RequestMapping("/NonDrugModel")
@CrossOrigin(allowCredentials = "true")
public class DmsNonDrugModelController {

    @Autowired
    DmsNonDrugModelService dmsNonDrugModelService;

    @ApiOperation(value = "新增非药品模版")
    @RequestMapping(value = "/createModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result) {
      return dmsNonDrugModelService.create(dmsNonDrugModelParam);

    }


    @ApiOperation(value = "删除非药品模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
       return dmsNonDrugModelService.deleteModel(ids);
    }

    @ApiOperation(value = "删除非药品模版项")
    @RequestMapping(value = "/deleteModelItem", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModelItem(@RequestParam("modelId")Long modelId, @RequestParam("ids") List<Long> itemIds){
        return dmsNonDrugModelService.deleteModelItem(modelId,itemIds);
    }

    @ApiOperation(value = "更新非药品模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result){
        return dmsNonDrugModelService.updateModel(modelId,dmsNonDrugModelParam);
    }

    @ApiOperation(value = "模糊查询非药品模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsNonDrugModelResult>> list(@RequestBody DmsNonDrugModelParam queryParam,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin){

        return dmsNonDrugModelService.list(queryParam, pageSize, pageNum,isAdmin);

    }


}