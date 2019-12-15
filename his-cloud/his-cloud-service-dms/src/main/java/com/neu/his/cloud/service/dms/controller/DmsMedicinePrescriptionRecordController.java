package com.neu.his.cloud.service.dms.controller;

import com.neu.his.cloud.service.dms.common.CommonResult;
import com.neu.his.cloud.service.dms.component.RabbitMQOrderSender;
import com.neu.his.cloud.service.dms.dto.dms.DmsMedicinePrescriptionRecordParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsMedicinePrescriptionRecordResult;
import com.neu.his.cloud.service.dms.service.DmsMedicinePrescriptionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "DmsMedicinePrescriptionRecordController", description = "成药处方管理")
@RequestMapping("/DmsMedicinePrescriptionRecord")
@CrossOrigin(allowCredentials = "true")
public class DmsMedicinePrescriptionRecordController {

    @Autowired
    private DmsMedicinePrescriptionRecordService dmsMedicinePrescriptionRecordService;

    @Autowired
    private RabbitMQOrderSender rabbitMQOrderSender;
    /**
     * 描述:开立处方（发送）
     * <p>author: ma
     */
    @ApiOperation(value = "开立处方（发送）")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestBody DmsMedicinePrescriptionRecordParam dmsMedicinePrescriptionRecordParam, BindingResult result){
        Long currentId = dmsMedicinePrescriptionRecordService.apply(dmsMedicinePrescriptionRecordParam);
        if(currentId > 0){
            //获取订单超时时间，假设为30s
            long delayTimes = 60 * 1000 * 60 * 12;
            //发送延迟消息
            rabbitMQOrderSender.sendMessage(currentId, 5, delayTimes);

            return CommonResult.success(currentId, "开立成功");
        }
        return CommonResult.failed("开立失败");
    }

    /**
     * 描述:作废处方
     * <p>author: ma
     */
    @ApiOperation(value = "作废处方")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult invalid(@RequestParam("ids") List<Long> ids){
        int count = dmsMedicinePrescriptionRecordService.invalid(ids);
        if(count > 0){
            return CommonResult.success(count, "作废成功");
        }
        return CommonResult.failed("作废失败");
    }

    /**
     * 描述:根据registrationId查询处方
     * <p>author: ma
     */
    @ApiOperation(value = "根据registrationId查询处方")
    @RequestMapping(value = "/listByReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByReg(@RequestParam("registrationId") Long registrationId){
        List<DmsMedicinePrescriptionRecordResult> list = dmsMedicinePrescriptionRecordService.listByReg(registrationId);
        return CommonResult.success(list);
    }

    /**
     * 描述:根据处方id查询成药处方项
     * <p>author: 赵煜
     */
    @ApiOperation(value = "ids")
    @RequestMapping(value = "/listByIds", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<DmsMedicinePrescriptionRecordResult>> listByIds(@RequestParam("ids") List<Long> ids){
        List<DmsMedicinePrescriptionRecordResult> list = dmsMedicinePrescriptionRecordService.listByIds(ids);
        return CommonResult.success(list);
    }



}
