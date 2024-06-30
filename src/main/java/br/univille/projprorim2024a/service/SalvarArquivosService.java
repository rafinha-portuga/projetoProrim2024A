package br.univille.projprorim2024a.service;

import org.springframework.web.multipart.MultipartFile;

public interface SalvarArquivosService {
    String save(MultipartFile file);
}
