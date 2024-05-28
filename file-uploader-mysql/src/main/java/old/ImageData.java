package old;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file_uploader")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

    @Id
    @Column(name = "id")
    private Long ImageId;

    @Column(name = "file_name")
    private String FileName;

    @Column(name = "file_type")
    private String FileType;

    @Lob
    @Column(name = "file")
    private byte[] file;
}
