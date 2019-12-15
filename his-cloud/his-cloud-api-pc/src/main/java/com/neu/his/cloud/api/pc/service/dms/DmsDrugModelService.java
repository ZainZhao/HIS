package com.neu.his.cloud.api.pc.service.dms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugModelParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsDrugModelResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "his-cloud-service-dms")
public interface DmsDrugModelService {


    @RequestMapping(value = "/drugModel/createModel", method = RequestMethod.POST)
    CommonResult createModel(@RequestBody DmsDrugModelParam dmsDrugModelParam);



    @RequestMapping(value = "/drugModel/deleteModel", method = RequestMethod.POST)
    CommonResult deleteModel(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/drugModel/updateModel", method = RequestMethod.POST)
    public CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsDrugModelParam dmsDrugModelParam);


    @RequestMapping(value = "/drugModel/listModel", method = RequestMethod.POST)
    public CommonResult<CommonPage<DmsDrugModelResult>> listModel(@RequestBody DmsDrugModelParam queryParam,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin);
}
