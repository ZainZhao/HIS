package com.neu.his.cloud.api.pc.controller.bms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsSettlementCatParam;
import com.neu.his.cloud.api.pc.dto.bms.BmsSettlementCatResult;
import com.neu.his.cloud.api.pc.service.bms.BmsSettlementCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "BmsSettlementCatController", description = "结算类别管理")
@RequestMapping("/settleCat")
@CrossOrigin(allowCredentials = "true")
public class BmsSettlementCatController {

    @Autowired
    private BmsSettlementCatService bmsSettlementCatService;


    @ApiOperation("新增一个结算类别")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody BmsSettlementCatParam bmsSettlementCatParam , BindingResult result){
        return bmsSettlementCatService.create(bmsSettlementCatParam);
    }

    @ApiOperation("根据ids删除结算类别")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        return bmsSettlementCatService.delete(ids);
    }

    @ApiOperation("更新一个结算类别信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody BmsSettlementCatParam bmsSettlementCatParam , BindingResult result){
      return bmsSettlementCatService.update(id,bmsSettlementCatParam);
    }


    @ApiOperation("模糊查询结算类别、且分页")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<BmsSettlementCatResult>> list(@RequestBody BmsSettlementCatParam queryParam,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return bmsSettlementCatService.list(queryParam,pageSize,pageNum);
    }

    @ApiOperation("查询所有结算类别")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BmsSettlementCatResult >> listAll(){
        return bmsSettlementCatService.listAll();
    }


}
