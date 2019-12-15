package com.neu.his.cloud.api.pc.service.bms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.bms.BmsSettlementCatParam;
import com.neu.his.cloud.api.pc.dto.bms.BmsSettlementCatResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-bms")
public interface BmsSettlementCatService {

    @RequestMapping(value = "/settleCat/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody BmsSettlementCatParam bmsSettlementCatParam);


    @RequestMapping(value = "/settleCat/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/settleCat/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody BmsSettlementCatParam bmsSettlementCatParam );

    @RequestMapping(value = "/settleCat/select", method = RequestMethod.POST)
    CommonResult<CommonPage<BmsSettlementCatResult>> list(@RequestBody BmsSettlementCatParam queryParam,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/settleCat/selectAll", method = RequestMethod.GET)
    CommonResult<List<BmsSettlementCatResult >> listAll();

}
