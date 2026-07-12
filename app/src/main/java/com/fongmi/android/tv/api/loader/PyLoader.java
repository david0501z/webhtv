package com.fongmi.android.tv.api.loader;

import com.fongmi.android.tv.App;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PyLoader {

    private final ConcurrentHashMap<String, Spider> spiders;
    private volatile String recent;

    public PyLoader() {
        spiders = new ConcurrentHashMap<>();
    }

    public void clear() {
        spiders.values().forEach(Spider::destroy);
        spiders.clear();
        recent = null;
    }

    public void setRecent(String recent) {
        this.recent = null; // Python runtime disabled for Android 6 build
    }

    public Spider getSpider(String key, String api, String ext) {
        // Python runtime not available on Android 6 (minSdk 23)
        return new SpiderNull();
    }

    public Object[] proxy(Map<String, String> params) throws Exception {
        return null;
    }
}
