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

import java.util.EnumSet;

public class FileEvent {

    private EnumSet<FileEventType> eventTypeEnumSet;
    private String path;

    private FileEvent(int event, String path) {
        this.eventTypeEnumSet = FileEventType.create(event);
        this.path = path;
    }

    public static FileEvent create(int event, String path) {
        return new FileEvent(event, path);
    }

    public EnumSet<FileEventType> getEventTypeEnumSet() {
        return eventTypeEnumSet;
    }

    public String getPath() {
        return path;
    }

    public boolean isAccess() {
        return eventTypeEnumSet.contains(FileEventType.ACCESS);
    }

    public boolean isModify() {
        return eventTypeEnumSet.contains(FileEventType.MODIFY);
    }

    public boolean isAttrib() {
        return eventTypeEnumSet.contains(FileEventType.ATTRIB);
    }

    public boolean isCloseWrite() {
        return eventTypeEnumSet.contains(FileEventType.CLOSE_WRITE);
    }

    public boolean isCloseNoWrite() {
        return eventTypeEnumSet.contains(FileEventType.CLOSE_NOWRITE);
    }

    public boolean isOpen() {
        return eventTypeEnumSet.contains(FileEventType.OPEN);
    }

    public boolean isMovedFrom() {
        return eventTypeEnumSet.contains(FileEventType.MOVED_FROM);
    }

    public boolean isMovedTo() {
        return eventTypeEnumSet.contains(FileEventType.MOVED_TO);
    }

    public boolean isMoveSelf() {
        return eventTypeEnumSet.contains(FileEventType.MOVE_SELF);
    }

    public boolean isCreate() {
        return eventTypeEnumSet.contains(FileEventType.CREATE);
    }

    public boolean isDelete() {
        return eventTypeEnumSet.contains(FileEventType.DELETE);
    }

    public boolean isDeleteSelf() {
        return eventTypeEnumSet.contains(FileEventType.DELETE_SELF);
    }

    @Override
    public String toString() {
        return "FileEvent{" + "event=" + eventTypeEnumSet.toString() + ", path='" + path + '\'' + '}';
    }
}
