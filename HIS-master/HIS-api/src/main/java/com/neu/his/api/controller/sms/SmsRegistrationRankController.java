package com.neu.his.api.controller.sms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.sms.SmsRegistrationRankParam;
import com.neu.his.common.dto.sms.SmsRegistrationRankResult;
import com.neu.his.sms.SmsRegistrationRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "SmsRegistrationRankController", description = "挂号级别管理")
@RequestMapping("/registerRank")
@CrossOrigin(allowCredentials = "true")
public class SmsRegistrationRankController {

    @Autowired
    private SmsRegistrationRankService smsRegistrationRankService;

    /**
     * 描述:新增一个挂号级别
     * <p>author: ma
     */
    @ApiOperation("新增挂号级别")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
        int count = smsRegistrationRankService.create(smsRegistrationRankParam);
        if(count > 0){
            return CommonResult.success(count, "添加成功");
        }
        return CommonResult.failed("添加失败");
    }

    /**
     * 描述:根据ids删除挂号级别
     * <p>author: ma
     */
    @ApiOperation("根据ids删除挂号级别")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = smsRegistrationRankService.delete(ids);
        if(count > 0){
            return CommonResult.success(count,"删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    /**
     * 描述:更新一个挂号级别的全部信息
     * <p>author: ma
     */
    @ApiOperation("更新挂号级别信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody SmsRegistrationRankParam smsRegistrationRankParam, BindingResult result){
        int count = smsRegistrationRankService.update(id,smsRegistrationRankParam);
        if(id > 0){
            return CommonResult.success(count,"更新成功");
        }
        return CommonResult.failed("更新失败");
    }

    /**
     * 描述:模糊查询挂号级别、且分页
     * <p>author: ma
     */
    @ApiOperation("模糊查询挂号级别、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SmsRegistrationRankResult>> list(SmsRegistrationRankParam queryParam,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        Page page =PageHelper.startPage(pageNum, pageSize);
        List<SmsRegistrationRankResult> list = smsRegistrationRankService.select(queryParam);
        Long pageTotal=page.getTotal();
        return CommonResult.success(CommonPage.restPage(list,pageTotal));
    }

    /**
     * 描述:查询所有挂号级别
     * <p>author: ma
     */
    @ApiOperation("查询所有挂号级别")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsRegistrationRankResult>> listAll(){
        List<SmsRegistrationRankResult> list = smsRegistrationRankService.selectAll();
        return CommonResult.success(list);
    }
}
