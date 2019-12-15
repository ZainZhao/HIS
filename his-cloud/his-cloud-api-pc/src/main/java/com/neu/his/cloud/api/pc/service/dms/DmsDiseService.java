package com.neu.his.cloud.api.pc.service.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsDiseService {


    @RequestMapping(value = "/DmsDise/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody DmsDiseParam dmsDiseParam);


    @RequestMapping(value = "/DmsDise/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsDise/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDiseParam dmsDiseParam);


    @RequestMapping(value = "/DmsDise/list", method = RequestMethod.POST)
    public CommonResult<CommonPage<DmsDiseResult>> list(@RequestBody DmsDiseParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/DmsDise/listAll", method = RequestMethod.POST)
    public CommonResult<List<DmsDiseResult>> listAll();

    @RequestMapping(value = "/DmsDise/parseList", method = RequestMethod.POST)
    public CommonResult<List<DmsDiseResult>> parseList( @RequestParam(value = "idsStr") String idsStr);
}
