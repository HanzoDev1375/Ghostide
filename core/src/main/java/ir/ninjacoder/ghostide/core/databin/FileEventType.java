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

package ir.ninjacoder.ghostide.core.databin;

import android.os.FileObserver;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum FileEventType {
    ACCESS, // Data was read from a file
    MODIFY, // Data was written to a file
    ATTRIB, // Metadata (permissions, owner, timestamp) was changed explicitly
    CLOSE_WRITE, // Someone had a file or directory open for writing, and closed it
    CLOSE_NOWRITE, // Someone had a file or directory open read-only, and closed it
    OPEN, // A file or directory was opened
    MOVED_FROM, // A file or subdirectory was moved from the monitored directory
    MOVED_TO, // A file or subdirectory was moved to the monitored directory
    CREATE, // A new file or subdirectory was created under the monitored directory
    DELETE, // A file was deleted from the monitored directory
    DELETE_SELF, // The monitored file or directory was deleted; monitoring effectively stops
    MOVE_SELF; // The monitored file or directory was moved; monitoring continues

    private static final HashMap<Integer, FileEventType> fileObserverMap = new HashMap<>();

    static {
        fileObserverMap.put(FileObserver.ACCESS, FileEventType.ACCESS);
        fileObserverMap.put(FileObserver.MODIFY, FileEventType.MODIFY);
        fileObserverMap.put(FileObserver.ATTRIB, FileEventType.ATTRIB);
        fileObserverMap.put(FileObserver.CLOSE_WRITE, FileEventType.CLOSE_WRITE);
        fileObserverMap.put(FileObserver.CLOSE_NOWRITE, FileEventType.CLOSE_NOWRITE);
        fileObserverMap.put(FileObserver.OPEN, FileEventType.OPEN);
        fileObserverMap.put(FileObserver.MOVED_FROM, FileEventType.MOVED_FROM);
        fileObserverMap.put(FileObserver.MOVED_TO, FileEventType.MOVED_TO);
        fileObserverMap.put(FileObserver.CREATE, FileEventType.CREATE);
        fileObserverMap.put(FileObserver.DELETE, FileEventType.DELETE);
        fileObserverMap.put(FileObserver.DELETE_SELF, FileEventType.DELETE_SELF);
        fileObserverMap.put(FileObserver.MOVE_SELF, FileEventType.MOVE_SELF);
    }

    public static EnumSet<FileEventType> create(int event) {
        EnumSet<FileEventType> result = EnumSet.noneOf(FileEventType.class);
        for (Map.Entry<Integer, FileEventType> entry : fileObserverMap.entrySet()) {
            if ((entry.getKey() & event) == entry.getKey()) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

}
