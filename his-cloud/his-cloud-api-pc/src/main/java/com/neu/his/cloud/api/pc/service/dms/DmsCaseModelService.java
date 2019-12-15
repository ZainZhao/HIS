package com.neu.his.cloud.api.pc.service.dms;

import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseModelListResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsCaseModelOrCatalogParam;
import com.neu.his.cloud.api.pc.model.DmsCaseModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsCaseModelService {

    @RequestMapping(value = "/DmsCaseModel/create", method = RequestMethod.POST)
    CommonResult createCatOrModel(@RequestBody DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam);

    @RequestMapping(value = "/DmsCaseModel/listModelCatTree", method = RequestMethod.POST)
    CommonResult<List<DmsCaseModelCatalogNode>> listModelCatTree(@RequestParam Long ownId, @RequestParam Integer scope) ;

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
