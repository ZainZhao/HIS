package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsDiseDistributionService {

    @RequestMapping(value = "/DmsDise/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody DmsDiseParam dmsDiseParam);


    @RequestMapping(value = "/DmsDise/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsDise/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody DmsDiseParam dmsDiseParam);



    @RequestMapping(value = "/DmsDise/list", method = RequestMethod.POST)
    CommonResult<CommonPage<DmsDiseResult>> list(@RequestBody DmsDiseParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);


    @RequestMapping(value = "/DmsDise/listAll", method = RequestMethod.POST)
    CommonResult<List<DmsDiseResult>> listAll();


    @RequestMapping(value = "/DmsDise/parseList", method = RequestMethod.POST)
    CommonResult<List<DmsDiseResult>> parseList( @RequestParam(value = "idsStr") String idsStr);

}
