package com.neu.his.cloud.api.pc.service.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsNonDrugService {

    @RequestMapping(value = "/DmsNonDrug/create", method = RequestMethod.POST)
    CommonResult create(@RequestBody DmsNonDrugParam dmsNonDrugParam);

    @RequestMapping(value = "/DmsNonDrug/delete", method = RequestMethod.POST)
    CommonResult delete(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/DmsNonDrug/update/{id}", method = RequestMethod.POST)
    CommonResult update(@PathVariable Long id, @RequestBody DmsNonDrugParam dmsNonDrugParam);

    @RequestMapping(value = "/DmsNonDrug/list", method = RequestMethod.POST)
    CommonResult<CommonPage<DmsNonDrugResult>> list(@RequestBody DmsNonDrugParam queryParam,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);


    @RequestMapping(value = "/DmsNonDrug/listAll", method = RequestMethod.POST)
    public CommonResult<List<DmsNonDrugResult>> listAll();


}
