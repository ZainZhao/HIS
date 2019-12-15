package com.neu.his.cloud.api.pc.controller.dms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugResult;
import com.neu.his.cloud.api.pc.service.dms.DmsNonDrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
        return dmsNonDrugService.create(dmsNonDrugParam);
    }

    @ApiOperation(value = "根据ids删除非药品")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
      return dmsNonDrugService.delete(ids);
    }


    @ApiOperation(value = "更新非药品信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsNonDrugParam dmsNonDrugParam , BindingResult result){
       return dmsNonDrugService.update(id,dmsNonDrugParam);
    }

    @ApiOperation(value = "模糊查询非药品、且分页")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsNonDrugResult>> list(@RequestBody DmsNonDrugParam queryParam,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return  dmsNonDrugService.list(queryParam,pageSize,pageNum);
    }

    @ApiOperation(value = "查询所有非药品")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsNonDrugResult>> listAll(){
        return dmsNonDrugService.listAll();
    }
}
