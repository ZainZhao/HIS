package com.neu.his.cloud.zuul.distribution.api.pc.bms;

import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.bms.BmsSettlementCatParam;
import com.neu.his.cloud.zuul.dto.bms.BmsSettlementCatResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcBmsSettlementCatDistributionService {


    @RequestMapping(value = "/settleCat/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody BmsSettlementCatParam bmsSettlementCatParam );


    @RequestMapping(value = "/settleCat/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/settleCat/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody BmsSettlementCatParam bmsSettlementCatParam );


    @RequestMapping(value = "/settleCat/select", method = RequestMethod.POST)
    CommonResult<CommonPage<BmsSettlementCatResult>> list(@RequestBody BmsSettlementCatParam queryParam,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/settleCat/selectAll", method = RequestMethod.GET)
    public CommonResult<List<BmsSettlementCatResult >> listAll();


}
