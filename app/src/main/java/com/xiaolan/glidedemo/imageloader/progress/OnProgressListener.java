package com.xiaolan.glidedemo.imageloader.progress;

public interface OnProgressListener {

    void onProgress(boolean isComplete, int percentage, long bytesRead, long totalBytes);
}
