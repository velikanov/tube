package com.company.scheduler.schedule;

import com.company.scheduler.crawler.VideoCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CrawlSchedules {
    private final VideoCrawler videoCrawler;

    @Autowired
    public CrawlSchedules(VideoCrawler videoCrawler) {
        this.videoCrawler = videoCrawler;
    }

    @Scheduled(fixedDelay = 1 * 60 * 1000)
    public void scheduleNewVideosCrawl() {
        videoCrawler.crawl();
    }
}