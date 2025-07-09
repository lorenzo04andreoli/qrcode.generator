package com.LorenzoAndreoli.qrcode.generator.ports;

public interface storagePort {

    String uploadFile(byte[] fileData, String fileName, String contentType);
}
