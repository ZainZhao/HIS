package com.neu.his.cloud.zuul.distribution.api.pc.dms;

import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseCatalogParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDiseCatalogResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsDiseCatalogDistributionService {

    @RequestMapping(value = "/DmsDiseCatalog/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody DmsDiseCatalogParam dmsDiseCatalogParam);


    @RequestMapping(value = "/DmsDiseCatalog/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/DmsDiseCatalog/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody DmsDiseCatalogParam dmsDiseCatalogParam);

    @RequestMapping(value = "/DmsDiseCatalog/listAll", method = RequestMethod.POST)
    CommonResult<List<DmsDiseCatalogResult>> listAll();
}
