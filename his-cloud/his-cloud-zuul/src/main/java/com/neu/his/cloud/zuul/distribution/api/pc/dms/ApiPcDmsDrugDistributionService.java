package com.neu.his.cloud.zuul.distribution.api.pc.dms;


import com.neu.his.cloud.zuul.common.CommonPage;
import com.neu.his.cloud.zuul.common.CommonResult;
import com.neu.his.cloud.zuul.dto.dms.DmsDosageResult;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugParam;
import com.neu.his.cloud.zuul.dto.dms.DmsDrugResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-api-pc")
public interface ApiPcDmsDrugDistributionService {

    @RequestMapping(value = "/drug/createDrug", method = RequestMethod.POST)
    CommonResult createDrug(@RequestBody DmsDrugParam dmsDrugParam );

    @RequestMapping(value = "/drug/deleteDrug", method = RequestMethod.POST)
    CommonResult deleteDrug(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/drug/updateDrug/{id}", method = RequestMethod.POST)
    CommonResult updateDrug(@PathVariable Long id, @RequestBody DmsDrugParam dmsDrugParam);

    @RequestMapping(value = "/drug/selectDrug", method = RequestMethod.POST)
    CommonResult<CommonPage<DmsDrugResult>> listDrug(@RequestBody DmsDrugParam queryParam,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/drug/selectAllDrug", method = RequestMethod.GET)
    CommonResult<List<DmsDrugResult>> listAllDrug();

    @RequestMapping(value = "/drug/selectAllDosage", method = RequestMethod.GET)
    CommonResult<List<DmsDosageResult>> listAllDrugDosage();

    @RequestMapping(value = "/drug/selectById", method = RequestMethod.GET)
    CommonResult<DmsDrugResult> selectById(@RequestParam("id") Long id);

}
