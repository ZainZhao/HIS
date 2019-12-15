package com.neu.his.common.dto.sms;

import com.neu.his.mbg.model.SmsPermission;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.List;

public class SmsPermissionNode extends SmsPermission  implements Serializable {

    @Getter
    @Setter
    private List<SmsPermissionNode> children;
}
