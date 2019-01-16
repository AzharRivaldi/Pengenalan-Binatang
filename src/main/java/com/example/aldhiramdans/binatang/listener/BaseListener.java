package com.example.aldhiramdans.binatang.listener;

import java.util.ArrayList;

public interface BaseListener<T> {
    void onSuccess(ArrayList<T> results);

    void onError(Throwable e);
}
