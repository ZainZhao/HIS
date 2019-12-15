package com.neu.his.cloud.zuul.distribution.api.pc.sms;

import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.sms.SmsDeptParam;
import com.neu.his.cloud.zuul.dto.sms.SmsDeptResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcSmsDeptDistributionService {
    @RequestMapping(value = "/dept/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody SmsDeptParam smsDeptParam);

    @RequestMapping(value = "/dept/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/dept/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable("id") Long id, @RequestBody SmsDeptParam smsDeptParam);

    @RequestMapping(value = "/dept/select", method = RequestMethod.POST)
    CommonResult<CommonPage<SmsDeptResult>> list(@RequestBody SmsDeptParam queryParam,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);
    @RequestMapping(value = "/dept/selectAll", method = RequestMethod.GET)
    CommonResult<List<SmsDeptResult>> listAll();

}
