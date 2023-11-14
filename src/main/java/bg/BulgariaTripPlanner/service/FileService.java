package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.FileDownloadModel;
import bg.BulgariaTripPlanner.dto.FileUploadModel;
import bg.BulgariaTripPlanner.model.FileEntity;
import bg.BulgariaTripPlanner.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

  private final FileRepository fileRepository;

  public FileService(FileRepository fileRepository) {

    this.fileRepository = fileRepository;
  }

  public long upload(FileUploadModel model) throws IOException {
    MultipartFile img = model.getImg();

    FileEntity newFile = new FileEntity();

    newFile.setFileData(img.getBytes());
    newFile.setContentType(img.getContentType());
    newFile.setFileName(img.getOriginalFilename());

    return fileRepository.save(newFile).getId();
  }

  public FileDownloadModel download(int fileId) {
    FileEntity file = fileRepository.findById(fileId).orElseThrow(() -> new IllegalArgumentException("File" + fileId + " not found!"));

    return new FileDownloadModel()
        .setContentType(file.getContentType())
        .setName(file.getFileName()).
        setDocument(file.getFileData());
  }

}
