package com.neu.his.api.controller.dms;

import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.dms.DmsDiseCatalogParam;
import com.neu.his.common.dto.dms.DmsDiseCatalogResult;
import com.neu.his.dms.service.DmsDiseCatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsDiseCatalogController", description = "诊断目录管理")
@RequestMapping("/DmsDiseCatalog")
@CrossOrigin(allowCredentials = "true")
public class DmsDiseCatalogController {
    @Autowired
    DmsDiseCatalogService dmsDiseCatalogService;

    @ApiOperation(value = "新增一个诊断目录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        CommonResult commonResult;
        int count = dmsDiseCatalogService.create(dmsDiseCatalogParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "根据ids删除诊断目录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = dmsDiseCatalogService.delete(ids);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
    @ApiOperation(value = "更新诊断目录信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        int count = dmsDiseCatalogService.update(id,dmsDiseCatalogParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
//    @ApiOperation(value = "模糊查询诊断目录、且分页")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<CommonPage<DmsDiseCatalogResult>> list(DmsDiseCatalogParam queryParam){
//        return null;
//    }

    @ApiOperation(value = "查询所有诊断目录")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseCatalogResult>> listAll(){
        return CommonResult.success(dmsDiseCatalogService.selectAll());
    }
}
