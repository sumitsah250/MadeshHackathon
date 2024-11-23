package com.boss.modelClass;

public class NoticeModel {
    private String NoticeName;
    private String NoticeTime;

    public NoticeModel() {
    }

    public String getNoticeTime() {
        return NoticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        NoticeTime = noticeTime;
    }

    public String getNoticeName() {
        return NoticeName;
    }

    public void setNoticeName(String noticeName) {
        NoticeName = noticeName;
    }

    public NoticeModel(String noticeName, String noticeTime) {
        NoticeName = noticeName;
        NoticeTime = noticeTime;
    }
}
