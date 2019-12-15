package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseCatalogParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseCatalogResult;
import com.neu.his.cloud.api.pc.service.dms.DmsDiseCatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
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
        return dmsDiseCatalogService.create(dmsDiseCatalogParam);
    }

    @ApiOperation(value = "根据ids删除诊断目录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
       return dmsDiseCatalogService.delete(ids);
    }
    @ApiOperation(value = "更新诊断目录信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseCatalogParam dmsDiseCatalogParam , BindingResult result){
        return dmsDiseCatalogService.update(id,dmsDiseCatalogParam);
    }


    @ApiOperation(value = "查询所有诊断目录")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseCatalogResult>> listAll(){
        return dmsDiseCatalogService.listAll();
    }
}
