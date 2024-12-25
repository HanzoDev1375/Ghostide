/*
 * Copyright (C) 2015 Pawel Hajduk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.ninjacoder.ghostide.databin;

import android.os.FileObserver;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;

public class FileObservable implements ObservableOnSubscribe<FileEvent> {

  private String pathToWatch;

  public FileObservable(String pathToWatch) {
    this.pathToWatch = pathToWatch;
  }

  @Override
  public void subscribe(ObservableEmitter<FileEvent> emitter) throws Throwable {
    final FileObserver observer =
        new FileObserver(pathToWatch) {
          @Override
          public void onEvent(int event, String file) {
            if (emitter.isDisposed()) {
              return;
            }

            FileEvent fileEvent = FileEvent.create(event, file);
            emitter.onNext(fileEvent);

            if (fileEvent.isDeleteSelf()) {
              emitter.onComplete();
            }
          }
        };
    observer.startWatching();

    emitter.setCancellable(
        new Cancellable() {
          @Override
          public void cancel() {
            observer.stopWatching();
          }
        });
  }
}
