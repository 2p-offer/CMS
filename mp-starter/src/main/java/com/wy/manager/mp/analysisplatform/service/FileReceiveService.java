package com.wy.manager.mp.analysisplatform.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 2P on 19-3-21.
 */
public interface FileReceiveService {
    /**
     * 对不同的文件,按照文件类型处理
     * @param file
     * @param fileTypep
     * @return
     */
    Object dealFile(MultipartFile file,String fileTypep);

}
