package online.shop.repository;

import online.shop.domain.FileProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilePropertyRepository extends JpaRepository<FileProperty, Long> {
    boolean existsByUploadFileName(String name);
}
