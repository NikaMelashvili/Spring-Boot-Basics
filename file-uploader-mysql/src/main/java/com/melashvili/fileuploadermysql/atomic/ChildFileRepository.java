package com.melashvili.fileuploadermysql.atomic;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildFileRepository extends JpaRepository<ChildFile, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ChildFile f SET f.filename = :newFilename WHERE f.filename = :oldFilename AND f.directory = :directoryPath")
    int updateFilename(String oldFilename, String newFilename, String directoryPath);

}
