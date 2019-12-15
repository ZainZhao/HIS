package com.neu.his.cloud.api.pc.service.dms;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.cloud.api.pc.common.CommonPage;
import com.neu.his.cloud.api.pc.common.CommonResult;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugModelParam;
import com.neu.his.cloud.api.pc.dto.dms.DmsNonDrugModelResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "his-cloud-service-dms")
public interface DmsNonDrugModelService {


    @RequestMapping(value = "/NonDrugModel/createModel", method = RequestMethod.POST)
    CommonResult create(@RequestBody DmsNonDrugModelParam dmsNonDrugModelParam);


    @RequestMapping(value = "/NonDrugModel/deleteModel", method = RequestMethod.POST)
    CommonResult deleteModel(@RequestParam("ids") List<Long> ids);


    @RequestMapping(value = "/NonDrugModel/deleteModelItem", method = RequestMethod.POST)
    CommonResult deleteModelItem(@RequestParam("modelId") Long modelId, @RequestParam("ids") List<Long> itemIds);


    @RequestMapping(value = "/NonDrugModel/updateModel", method = RequestMethod.POST)
    CommonResult updateModel(@RequestParam("modelId") Long modelId, @RequestBody DmsNonDrugModelParam dmsNonDrugModelParam);


    @RequestMapping(value = "/NonDrugModel/listModel", method = RequestMethod.POST)
    CommonResult<CommonPage<DmsNonDrugModelResult>> list(@RequestBody DmsNonDrugModelParam queryParam,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "isAdmin") Integer isAdmin);


}