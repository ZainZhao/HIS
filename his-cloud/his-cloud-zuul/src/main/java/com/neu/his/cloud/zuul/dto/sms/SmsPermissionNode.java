package com.neu.his.cloud.zuul.dto.sms;


import com.neu.his.cloud.zuul.model.SmsPermission;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class SmsPermissionNode extends SmsPermission implements Serializable {

    @Getter
    @Setter
    private List<SmsPermissionNode> children;
}
