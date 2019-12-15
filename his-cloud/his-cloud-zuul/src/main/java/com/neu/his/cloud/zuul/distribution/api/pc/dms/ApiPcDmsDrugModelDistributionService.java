package com.neu.his.cloud.zuul.distribution.api.pc.dms;

import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugModelParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugModelResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *药品模版
 */
@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsDrugModelDistributionService {

    @RequestMapping(value = "/drugModel/createModel", method = RequestMethod.POST)
    CommonResult createModel(@RequestBody DmsDrugModelParam dmsDrugModelParam);


    @RequestMapping(value = "/drugModel/deleteModel", method = RequestMethod.POST)
    CommonResult deleteModel(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/drugModel/updateModel", method = RequestMethod.POST)
    CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsDrugModelParam dmsDrugModelParam);


    @RequestMapping(value = "/drugModel/listModel", method = RequestMethod.GET)
    CommonResult<CommonPage<DmsDrugModelResult>> listModel(DmsDrugModelParam queryParam,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin);

}
