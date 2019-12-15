package com.neu.his.cloud.api.pc.controller.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseResult;
import com.neu.his.cloud.api.pc.service.dms.DmsDiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsDiseController", description = "诊断管理")
@RequestMapping("/DmsDise")
@CrossOrigin(allowCredentials = "true")
public class DmsDiseController {
    @Autowired
    DmsDiseService dmsDiseService;

    @ApiOperation(value = "新增诊断")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDiseParam dmsDiseParam , BindingResult result){

       return  dmsDiseService.create(dmsDiseParam);

    }

    @ApiOperation(value = "根据ids删除诊断")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        return dmsDiseService.delete(ids);
    }

    @ApiOperation(value = "更新诊断信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseParam dmsDiseParam , BindingResult result){
       return dmsDiseService.update(id,dmsDiseParam);
    }

    @ApiOperation(value = "模糊查询诊断、且分页")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DmsDiseResult>> list(@RequestBody DmsDiseParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

       return  dmsDiseService.list(queryParam, pageSize, pageNum);

    }

    @ApiOperation(value = "查询所有诊断")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseResult>> listAll(){
        return dmsDiseService.listAll();
    }


    @ApiOperation(value = "根据id串获取诊断简单对象list")
    @RequestMapping(value = "/parseList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsDiseResult>> parseList( @RequestParam(value = "idsStr") String idsStr){
        return dmsDiseService.parseList(idsStr);
    }

}
