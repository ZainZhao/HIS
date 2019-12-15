package com.neu.his.cloud.api.pc.service.dms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDosageResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsDrugService {

    @RequestMapping(value = "/drug/createDrug", method = RequestMethod.POST)
    CommonResult createDrug(@RequestBody DmsDrugParam dmsDrugParam);

    @RequestMapping(value = "/drug/deleteDrug", method = RequestMethod.POST)
    public CommonResult deleteDrug(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/drug/updateDrug/{id}", method = RequestMethod.POST)
    public CommonResult updateDrug(@PathVariable Long id, @RequestBody DmsDrugParam dmsDrugParam);


    @RequestMapping(value = "/drug/selectDrug", method = RequestMethod.POST)
    public CommonResult<CommonPage<DmsDrugResult>> listDrug(@RequestBody DmsDrugParam queryParam,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    @RequestMapping(value = "/drug/selectAllDrug", method = RequestMethod.GET)
    public CommonResult<List<DmsDrugResult>> listAllDrug();


    @RequestMapping(value = "/drug/selectAllDosage", method = RequestMethod.GET)
    public CommonResult<List<DmsDosageResult>> listAllDrugDosage();



    @RequestMapping(value = "/drug/selectById", method = RequestMethod.GET)
    CommonResult<DmsDrugResult> selectById(@RequestParam("id") Long id);
}
