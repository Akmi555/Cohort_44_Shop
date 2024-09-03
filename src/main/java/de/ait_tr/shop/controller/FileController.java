package de.ait_tr.shop.controller;

import de.ait_tr.shop.exception_handling.Response;
import de.ait_tr.shop.service.interfaces.FileService;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.multipart.MultipartFile; /**
 * @author Sergey Bugaenko
 * {@code @date} 03.09.2024
 */

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public Response upload(@RequestParam MultipartFile file, @RequestParam String productTitle) {
        // Временно верну null
        String url = fileService.upload(file, productTitle);
        return new Response("File upload! Url: " + url);
    }
}
