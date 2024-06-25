package com.mcal.uidesigner.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class UndoManager {
    private final Stack<Change> contents = new Stack<>();
    private final Stack<Change> redoContents = new Stack<>();
    private final List<UndoRedoListener> listeners = new ArrayList<>();

    public void addListener(UndoRedoListener l) {
        listeners.add(l);
    }

    public void removeListener(UndoRedoListener l) {
        listeners.remove(l);
    }

    public void addBaseVersion(String filepath, String content, int change) {
        if (filepath != null && !content.equals(getContent(filepath))) {
            redoContents.clear();
            contents.push(new Change(filepath, content, change));
            fireUndoRedoStateChange();
        }
    }

    public void addVersion(String filepath, String content, int change) {
        if (filepath != null) {
            redoContents.clear();
            contents.push(new Change(filepath, content, change));
            fireUndoRedoStateChange();
        }
    }

    public void load(@NonNull Bundle bundle) {
        contents.clear();
        List<Change> undo = bundle.getParcelableArrayList("undo");
        if (undo != null) {
            contents.addAll(undo);
        }
        redoContents.clear();
        ArrayList<Change> redo = bundle.getParcelableArrayList("redo");
        if (redo != null) {
            redoContents.addAll(redo);
        }
    }

    public void save(@NonNull Bundle bundle) {
        bundle.putParcelableArrayList("undo", new ArrayList<>(contents));
        bundle.putParcelableArrayList("redo", new ArrayList<>(redoContents));
    }

    public boolean canUndo() {
        Set<String> paths = new HashSet<>();
        for (int i = contents.size() - 1; i >= 0; i--) {
            String filepath = contents.get(i).filepath;
            if (paths.contains(filepath)) {
                return true;
            }
            paths.add(filepath);
        }
        return false;
    }

    public boolean canRedo() {
        return redoContents.size() > 0;
    }

    public void redo() {
        Change change = redoContents.pop();
        contents.push(change);
        fireUndoRedo(change);
    }

    public void undo() {
        Change change = contents.pop();
        redoContents.push(change);
        fireUndoRedo(change);
    }

    private String getContent(String filepath) {
        for (int i = contents.size() - 1; i >= 0; i--) {
            if (contents.get(i).filepath.equals(filepath)) {
                return contents.get(i).content;
            }
        }
        return "";
    }

    private void fireUndoRedoStateChange() {
        for (UndoRedoListener l : listeners) {
            l.undoRedoStateChanged();
        }
    }

    private void fireUndoRedo(Change change) {
        for (UndoRedoListener l : listeners) {
            l.undoRedoStateChanged();
            l.revertToVersion(change.filepath, getContent(change.filepath), change.change);
        }
    }

    public interface UndoRedoListener {
        void revertToVersion(String str, String str2, int i);

        void undoRedoStateChanged();
    }

    public static class Change implements Parcelable {
        public static final Parcelable.Creator<Change> CREATOR = new Parcelable.Creator<>() {

            @NonNull
            @Contract("_ -> new")
            @Override
            public Change createFromParcel(Parcel in) {
                return new Change(in);
            }


            @NonNull
            @Contract(value = "_ -> new", pure = true)
            @Override
            public Change[] newArray(int size) {
                return new Change[size];
            }
        };
        public int change;
        public String content;
        public String filepath;

        public Change(String filepath, String content, int change) {
            this.filepath = filepath;
            this.content = content;
            this.change = change;
        }

        public Change(@NonNull Parcel in) {
            this(in.readString(), in.readString(), in.readInt());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeString(filepath);
            dest.writeString(content);
            dest.writeInt(change);
        }
    }
}
