package com.neu.his.cloud.api.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.his.cloud.api.app.common.CommonResult;
import com.neu.his.cloud.api.app.dto.app.AppDocSkdResult;
import com.neu.his.cloud.api.app.dto.app.AppRegistrationParam;
import com.neu.his.cloud.api.app.dto.app.AppStaffDescriptionResult;
import com.neu.his.cloud.api.app.dto.pms.PmsPatientResult;
import com.neu.his.cloud.api.app.dto.sms.SmsDeptResult;
import com.neu.his.cloud.api.app.dto.sms.SmsSkdParam;
import com.neu.his.cloud.api.app.dto.sms.SmsSkdResult;
import com.neu.his.cloud.api.app.service.dms.DmsRegistrationService;
import com.neu.his.cloud.api.app.service.pms.PmsPatientService;
import com.neu.his.cloud.api.app.service.sms.SmsDeptService;
import com.neu.his.cloud.api.app.service.sms.SmsDescriptionService;
import com.neu.his.cloud.api.app.service.sms.SmsSkdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "AppRegistrationController", description = "APP 挂号管理")
@RequestMapping("/appRegistration")
//@CrossOrigin(allowCredentials = "true")
public class AppRegistrationController {

    @Autowired
    private SmsDeptService smsDeptService;

    @Autowired
    private SmsSkdService smsSkdService;

    @Autowired
    private DmsRegistrationService dmsRegistrationService;

    @Autowired
    private PmsPatientService pmsPatientService;

    @Autowired
    private SmsDescriptionService smsDescriptionService;

    @Value("${server.port}")
    private String port;

     @HystrixCommand(fallbackMethod = "loginFallbackInfo")
     @ApiOperation("患者 手机端登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsPatientResult> login(@RequestParam("identificationNo") String identificationNo,
                                                @RequestParam("medicalRecordNo") String medicalRecordNo){
       return pmsPatientService.login(identificationNo ,medicalRecordNo);
    }
    private CommonResult<PmsPatientResult> loginFallbackInfo( String identificationNo,String medicalRecordNo){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listAllDeptFallbackInfo")
    @ApiOperation("查询所有科室")
    @RequestMapping(value = "/listAllDept", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsDeptResult>> listAllDept(){
      return smsDeptService.listAll();
    }
    private CommonResult<List<SmsDeptResult>> listAllDeptFallbackInfo(){
        return CommonResult.success(null,"请检查您的网络+prot:"+port) ;
    }

    @HystrixCommand(fallbackMethod = "listDeptDoctorFallbackInfo")
    @ApiOperation("查询某个科室所有专家")
    @RequestMapping(value = "/listDeptDoctor", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppStaffDescriptionResult>> listDeptDoctor(@RequestParam("deptId") Long deptId){
        return smsDescriptionService.listDeptDoctor(deptId);
    }
    private CommonResult<List<AppStaffDescriptionResult>> listDeptDoctorFallbackInfo(Long deptId){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "listDoctorSkdFallbackInfo")
    @ApiOperation("查询某个专家所有排班及描述信息")
    @RequestMapping(value = "/listDoctorSkd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AppDocSkdResult> listDoctorSkd(@RequestParam("staffId") Long staffId,
                                                       @RequestParam(value = "endDate",required = false) Date endDate){
        SmsSkdParam smsSkdParam = new SmsSkdParam();
        smsSkdParam.setStaffId(staffId);
        Calendar calendar = Calendar.getInstance();
        //设置起始时间为当天00:00:00.0
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        smsSkdParam.setStartDate(calendar.getTime());

        //设置截止时间为最后一天23:59:59.0
        if(endDate != null){
            calendar.setTime(endDate);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 0);
            smsSkdParam.setEndDate(calendar.getTime());
        }

        List<SmsSkdResult> skdResultList = smsSkdService.listSkd(smsSkdParam).getData();  //与单体不一样 20190626

        AppDocSkdResult result = smsDescriptionService.getStaffDetailById(staffId).getData();

        if(result != null){
            result.setSkdResultList(skdResultList);
        }
        return CommonResult.success(result);
    }
    private CommonResult<AppDocSkdResult> listDoctorSkdFallbackInfo(Long staffId, Date endDate){
        return CommonResult.success(null,"请检查您的网络") ;
    }

    @HystrixCommand(fallbackMethod = "registrationFallbackInfo")
    @ApiOperation("挂号")
    @RequestMapping(value = "/appReg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult registration(@RequestBody AppRegistrationParam appRegistrationParam, BindingResult result){
        return dmsRegistrationService.appRegistration(appRegistrationParam);
    }
    private CommonResult registrationFallbackInfo(AppRegistrationParam appRegistrationParam, BindingResult result){
        return CommonResult.success(null,"请检查您的网络") ;
    }

}