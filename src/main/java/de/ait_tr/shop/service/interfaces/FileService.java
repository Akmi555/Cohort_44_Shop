package de.ait_tr.shop.service.interfaces;

import org.springframework.web.multipart.MultipartFile; /**
 * @author Sergey Bugaenko
 * {@code @date} 03.09.2024
 */

public interface FileService {
    String upload(MultipartFile file, String productTitle);
}
