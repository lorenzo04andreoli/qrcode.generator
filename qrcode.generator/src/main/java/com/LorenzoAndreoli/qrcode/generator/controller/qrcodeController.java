package com.LorenzoAndreoli.qrcode.generator.controller;

import com.LorenzoAndreoli.qrcode.generator.dto.qrCodeGenerateRequest;
import com.LorenzoAndreoli.qrcode.generator.dto.qrCodeGenerateResponse;
import com.LorenzoAndreoli.qrcode.generator.service.qrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class qrcodeController {

    private final qrCodeGeneratorService qrCodeGeneratorService;

    public qrcodeController(qrCodeGeneratorService qrCodeService){
        this.qrCodeGeneratorService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<qrCodeGenerateResponse> generate(@RequestBody qrCodeGenerateRequest request) {
        try {
            qrCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }
}

