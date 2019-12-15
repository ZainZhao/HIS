package com.neu.his.api.controller.dms;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsNonDrugModelParam;
import com.neu.his.common.dto.dms.DmsNonDrugModelResult;
import com.neu.his.common.dto.dms.DmsNonDrugResult;
import com.neu.his.dms.service.DmsNonDrugModelService;
import com.neu.his.mbg.model.DmsNonDrugModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
        System.err.println("create");
        int count = dmsNonDrugModelService.createModel(dmsNonDrugModelParam);
        System.err.println("created=="+count);

        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "删除非药品模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModel(@RequestParam("ids") List<Long> ids){
        int count = dmsNonDrugModelService.deleteModel(ids);
            if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "删除非药品模版项")
    @RequestMapping(value = "/deleteModelItem", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteModelItem( @RequestParam("modelId")Long modelId, @RequestParam("ids") List<Long> itemIds){
        int count = dmsNonDrugModelService.deleteModelItem(modelId,itemIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新非药品模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateModel(@RequestParam("modelId") Long modelId,@RequestBody DmsNonDrugModelParam dmsNonDrugModelParam, BindingResult result){
        int count = dmsNonDrugModelService.updateModel(modelId,dmsNonDrugModelParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "模糊查询非药品模版、且分页")
    @RequestMapping(value = "/listModel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsNonDrugModelResult>> list(DmsNonDrugModelParam queryParam,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,@RequestParam(value = "isAdmin") Integer isAdmin){
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<DmsNonDrugModelResult> list = dmsNonDrugModelService.selectModel(isAdmin,queryParam, pageSize, pageNum);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }


}