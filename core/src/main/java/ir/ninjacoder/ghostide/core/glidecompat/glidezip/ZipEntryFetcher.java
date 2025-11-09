package ir.ninjacoder.ghostide.core.glidecompat.glidezip;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import ir.ninjacoder.ghostide.core.glidecompat.glidezip.ZipEntryModel;

public class ZipEntryFetcher implements DataFetcher<InputStream> {
  private final ZipEntryModel model;

  public ZipEntryFetcher(ZipEntryModel model) {
    this.model = model;
  }

  @Override
  public void loadData(Priority priority, DataCallback<? super InputStream> callback) {
    try {
      ZipFile zipFile = new ZipFile(model.zipFilePath);
      ZipEntry entry = zipFile.getEntry(model.entryPath);
      if (entry != null) {
        InputStream inputStream = zipFile.getInputStream(entry);
        callback.onDataReady(inputStream);
      } else {
        callback.onLoadFailed(new FileNotFoundException("Entry not found: " + model.entryPath));
      }
    } catch (IOException e) {
      callback.onLoadFailed(e);
    }
  }

  @Override
  public void cleanup() {}

  @Override
  public void cancel() {}

  @Override
  public Class<InputStream> getDataClass() {
    return InputStream.class;
  }

  @Override
  public DataSource getDataSource() {
    return DataSource.LOCAL;
  }
}
