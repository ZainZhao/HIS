package com.neu.his.api.controller.dms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsNonDrugParam;
import com.neu.his.common.dto.dms.DmsNonDrugResult;
import com.neu.his.dms.service.DmsNonDrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@Api(tags = "DmsNonDrugController", description = "非药品项目管理")
@RequestMapping("/DmsNonDrug")
@CrossOrigin(allowCredentials = "true")
public class DmsNonDrugController {
    @Autowired
    DmsNonDrugService dmsNonDrugService;

    @ApiOperation(value = "新增非药品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsNonDrugParam dmsNonDrugParam , BindingResult result){
        CommonResult commonResult;
        int count = dmsNonDrugService.create(dmsNonDrugParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "根据ids删除非药品")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = dmsNonDrugService.delete(ids);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
    @ApiOperation(value = "更新非药品信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsNonDrugParam dmsNonDrugParam , BindingResult result){
        int count = dmsNonDrugService.update(id,dmsNonDrugParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "模糊查询非药品、且分页")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsNonDrugResult>> list(DmsNonDrugParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<DmsNonDrugResult> list = dmsNonDrugService.select(queryParam);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }
    @ApiOperation(value = "查询所有非药品")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsNonDrugResult>> listAll(){
        return CommonResult.success(dmsNonDrugService.selectAll());
    }
}
