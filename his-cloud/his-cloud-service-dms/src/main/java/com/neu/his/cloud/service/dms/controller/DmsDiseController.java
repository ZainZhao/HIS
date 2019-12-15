package com.neu.his.cloud.service.dms.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.service.dms.common.CommonPage;
import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsDiseParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDiseResult;
import com.neu.his.cloud.service.dms.service.DmsDiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "DmsDiseController", description = "诊断管理")
@RequestMapping("/DmsDise")
@CrossOrigin(allowCredentials = "true")
public class DmsDiseController {
    @Autowired
    DmsDiseService dmsDiseService;

    @ApiOperation(value = "新增一个诊断")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDiseParam dmsDiseParam , BindingResult result){
        CommonResult commonResult;
        int count = dmsDiseService.create(dmsDiseParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "根据ids删除诊断")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = dmsDiseService.delete(ids);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseParam dmsDiseParam , BindingResult result){
        int count = dmsDiseService.update(id,dmsDiseParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "模糊查询诊断、且分页")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDiseResult>> list(@RequestBody DmsDiseParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<DmsDiseResult> list = dmsDiseService.select(queryParam, pageSize, pageNum);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

    @ApiOperation(value = "查询所有诊断")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseResult>> listAll(){
        return CommonResult.success(dmsDiseService.selectAll());
    }


    @ApiOperation(value = "根据id串获取诊断简单对象list")
    @RequestMapping(value = "/parseList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseResult>> parseList( @RequestParam(value = "idsStr") String idsStr){
        return CommonResult.success(dmsDiseService.parseList(idsStr));
    }

}
