package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseModelListResult;
import com.neu.his.cloud.zuul.dto.dms.DmsCaseModelOrCatalogParam;
import com.neu.his.cloud.zuul.model.DmsCaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsCaseModelDistributionService {

    @RequestMapping(value = "/DmsCaseModel/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam);


    @RequestMapping(value = "/DmsCaseModel/listModelCatTree", method = RequestMethod.POST)
    CommonResult<List<DmsCaseModelCatalogNode>> listModelCatTree(@RequestParam Long ownId, @RequestParam Integer scope);


    @RequestMapping(value = "/DmsCaseModel/deleteModelOrCat", method = RequestMethod.POST)
    CommonResult deleteModelOrCat(@RequestParam("id") Long id);


    @RequestMapping(value = "/DmsCaseModel/updateModel", method = RequestMethod.POST)
    CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsCaseModel dmsCaseModel);


    @RequestMapping(value = "/DmsCaseModel/updateModel/{id}", method = RequestMethod.GET)
    CommonResult updateName(@PathVariable("id") Long id, @RequestParam("name")String name);


    @RequestMapping(value = "/DmsCaseModel/getModelDetail/{id}", method = RequestMethod.GET)
    CommonResult<DmsCaseModel> getModelDetail(@PathVariable("id") Long id);

    @RequestMapping(value = "/DmsCaseModel/getAllStaffModel", method = RequestMethod.GET)
    CommonResult<DmsCaseModelListResult> getAllStaffModel(@RequestParam("staffId") Long staffId);
}
