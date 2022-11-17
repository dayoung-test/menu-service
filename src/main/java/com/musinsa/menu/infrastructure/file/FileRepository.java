package com.musinsa.menu.infrastructure.file;

import com.musinsa.menu.domain.file.File;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

	Optional<File> findByFileToken(String fileToken);

}
