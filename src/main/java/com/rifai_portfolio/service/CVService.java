package com.rifai_portfolio.service;

import com.rifai_portfolio.models.CV;
import com.rifai_portfolio.respositories.CVRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class CVService {

    private final CVRepository cvRepository;

    public CVService(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public CV uploadCV(MultipartFile file) throws IOException {
        CV cv = new CV();
        cv.setFileName(file.getOriginalFilename());
        cv.setData(file.getBytes());
        return cvRepository.save(cv);
    }

    public Optional<CV> getCV(Long id) {
        return cvRepository.findById(id);
    }
}
