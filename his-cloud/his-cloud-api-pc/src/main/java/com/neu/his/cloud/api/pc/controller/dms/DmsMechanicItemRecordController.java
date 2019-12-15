package com.neu.his.cloud.api.pc.controller.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsMechanicItemRecordResult;
import com.neu.his.cloud.api.pc.service.dms.DmsMechanicItemRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "DmsMechanicItemRecordController", description = "医技工作台")
@RequestMapping("/DmsMechanicItemRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsMechanicItemRecordController {

    @Autowired
    private DmsMechanicItemRecordService dmsMechanicItemRecordService;


    @ApiOperation(value = "根据科室id刷新患者列表")
    @RequestMapping(value = "/listByDept", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMechanicItemRecordResult>> listByDept(@RequestParam("deptId") Long deptId){
        return  dmsMechanicItemRecordService.listByDept(deptId);
    }


    @ApiOperation(value = "登记")
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult log(@RequestParam("itemRecordId") Long itemRecordId, @RequestParam("logStaffId") Long logStaffId){
        return dmsMechanicItemRecordService.log(itemRecordId,logStaffId);

    }


    @ApiOperation(value = "上传结果")
    @RequestMapping(value = "/uploadResult", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadResult(@RequestParam("id") Long id,
                                     @RequestParam("executeStaffId") Long excuteStaffId,
                                     @RequestParam("checkResult") String checkResult,
                                     @RequestParam("resultImgUrlList") String resultImgUrlList){
        return dmsMechanicItemRecordService.uploadResult(id,excuteStaffId,checkResult,resultImgUrlList);
    }

}
