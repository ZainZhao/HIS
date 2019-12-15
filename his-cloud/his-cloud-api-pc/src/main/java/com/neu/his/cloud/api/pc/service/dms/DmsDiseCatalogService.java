package com.neu.his.cloud.api.pc.service.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseCatalogParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDiseCatalogResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsDiseCatalogService {


    @RequestMapping(value = "/DmsDiseCatalog/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody DmsDiseCatalogParam dmsDiseCatalogParam);

    @RequestMapping(value = "/DmsDiseCatalog/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/DmsDiseCatalog/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody DmsDiseCatalogParam dmsDiseCatalogParam );

    @RequestMapping(value = "/DmsDiseCatalog/listAll", method = RequestMethod.POST)
    CommonResult<List<DmsDiseCatalogResult>> listAll();

}
