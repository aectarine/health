package com.ksd.health.vo.member;

import com.ksd.health.model.Member;

public class HealthBoardForm {
    private Long seq;
    private String title;
    private String video;
    private Long views;
    private Long recommend;
    private Member member;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getRecommend() {
        return recommend;
    }

    public void setRecommend(Long recommend) {
        this.recommend = recommend;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "HealthBoardForm{" + "seq=" + seq + ", title='" + title + '\'' + ", video='" + video + '\'' + ", views=" + views + ", recommend=" + recommend + ", member=" + member + '}';
    }
}
