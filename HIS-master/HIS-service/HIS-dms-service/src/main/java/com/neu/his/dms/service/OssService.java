package com.neu.his.dms.service;



import com.neu.his.common.dto.oss.OssCallbackResult;
import com.neu.his.common.dto.oss.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 */
public interface OssService {
    OssPolicyResult policy();
    OssCallbackResult callback(HttpServletRequest request);
}
